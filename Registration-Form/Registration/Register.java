package Homework1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Homework1/Register")



public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private boolean flag =false;
	boolean valid=false;
	
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean isnameempty = false;
		boolean nolastname = false;
		boolean invalidename = false;
		boolean invalideemail = false;
		boolean noemail = false;
	    boolean nopassword = false;
	    boolean invalidepassword = false;
	    boolean emptypassword = false;
	    boolean notmatches = false;
	    String firstname = null;
		
		
		
		

	     String name = request.getParameter("name");
	     System.out.println("name is "+ name+"\t"+ flag);
	     if( name!=null ) {  
	    	 name = name.trim();
	    	 if(name.trim().isEmpty()) {
	   	      isnameempty = true;
	  	            System.out.println("error, Please enter name");
	    		 
	    	 }
	    	 
	    	 else if( !name.matches("([a-zA-Z ]*)")){
    			 System.out.println( " invalide name");
    			 invalidename = true;
	    	 }
	    		 if(name.length()>0){
	    			 System.out.println("name is ="+name);
	    			 String[] fullname =name.split(" ");
	    			 firstname=fullname[0];
	    			 if(fullname.length <=1 ) {
	    				 nolastname = true;
	    				 System.out.println("no last name");
	    			 }
	    			 
	    		 } else
	    			 isnameempty=true;
	    	 
	     }
	     
	     if (!isnameempty && !invalidename)
	    	 name = (request.getParameter("name")) == null? "": request.getParameter("name").toString();
	     //if (!isnameempty)
	    	 
		//if(!isnameempty || nolastname)
			
		
		
		
		String email = request.getParameter("email");   
	    String password1 = request.getParameter("password1");
	    String password2 = request.getParameter("password2");
	    int MAX_LEN=20;
		
		 
		//private ServletRequest request;
	     if  (email != null) {
	           
	            if (email.trim().isEmpty()) {
	            	noemail = true;
	                System.out.println("error, Please enter email");
	            } else if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
	                System.out.println("error, Invalid email, please try again.");
	                invalideemail = true;
	                
	            } else {
	              
	                System.out.println("success, good");
	            }
	            
	     }
	     if(!noemail && !invalideemail)
				email = (request.getParameter("email")) == null? "": request.getParameter("email").toString();

		//String password1 = request.getParameter("password1");
	     if (password1 != null) {
	          // Validate password
			if(password1.isEmpty()) {
				nopassword = true;
	              System.out.println("error, Please enter password");
	          } else if(!password1.matches("(?=.*\\d)(?=.*[!@#$%^&*]).*$")){
	        	  
	        	  invalidepassword = true;
	              System.out.println("error, Invalid password");
	          } else {
	              // Password is valid
	              System.out.println("success, good");
	          }
			//String password2 = request.getParameter("password2");
	     }
	     
	     if(!nopassword && !invalidepassword)
				password1 = (request.getParameter("password1")) == null? "": request.getParameter("password1").toString();
	     
	     
			if (password2 != null) {
	          // Validate password
				
	          if(password2.isEmpty()) {
	              System.out.println("error, Please enter password");
	              emptypassword = true;
	          } 
	          else if(password2.equals(password1)) {
	              System.out.println("error, Passwords do not match");
	              notmatches = false;
	              
	          } else {
	              // Password is valid
	        	  notmatches=true;
	              System.out.println("success, good");
	          }
	          
	      }

			
			   if(!emptypassword)
					password2 = (request.getParameter("password2")) == null? "": request.getParameter("password2").toString();
			
			
			
if(flag ==false||isnameempty == true||nolastname == true || invalidename == true || noemail==true ||invalideemail == true || nopassword == true || invalidepassword == true||notmatches==true||emptypassword==true){
			
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Bootstrap Example</title>");
		out.println ("<meta charset=\"utf-8\">");
		out.println ("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println ("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println ("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>");

		out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>");
		out.println("	<title>rupal</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<div class=\"jumbotron\">");
		out.println("<h2>REGISTRATION FORM</h2>");
		out.println("<div class=\"container\">");
		out.println("<form action=\"Register\" role=\"form\" method=\"post\">");
		
		out.println ("<div class=\"form-group\">");
		System.out.println("isnameempty" + isnameempty + "nolastname" + nolastname + "name" +name);
		out.println ("<h3>Name:</h3><input type=\"text\" name= \"name\" class=\"form-control\" value=\"" +(isnameempty || invalidename ? ""  :name) +"\" placeholder=\"Enter Name\">");
		if(isnameempty)
			out.println("<P class=\"text-danger\"> Enter Your Name</p>");
		else if(invalidename)
			out.println("<P class=\"text-danger\"> Invalide Name</p>");
		else if(nolastname)
			out.println("<P class=\"text-danger\"> Enter last Name</p>");
		out.println("</div>");
		
		out.println("<div class=\"fo rm-group\">");
		out.println("<label for=\"email\"><h3>Email:</h3></label>");
		System.out.println(invalideemail + " "+ noemail + email);
		out.println("<input type=\"text\" name=\"email\" class=\"form-control\" id=\"email\"  value=\"" +(invalideemail || noemail  ? ""  :email) +"\" placeholder=\"Enter email\">");
		if(invalideemail)
			out.println("<P class=\"text-danger\"> Enter correct email</p>");
		else if(noemail)
			out.println("<P class=\"text-danger\"> Enter Email</p>");
		
		out.println("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"pwd\"><h3>Password:</h3></label>");
		out.println("<input type=\"password\" name=\"password1\" class=\"form-control\" id=\"pwd\"  value=\"" +(invalidepassword || nopassword || notmatches || emptypassword ? ""  :password1) +"\" placeholder=\"Enter password\">");
		if(nopassword)
			out.println("<P class=\"text-danger\"> Enter Password</p>");
		else if(invalidepassword)
			out.println("<P class=\"text-danger\"> Enter Correct Password</p>");
		out.println  ("</div>");
		
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"pwd\"><h3>Re-Enter Password:</h3></label>");
		out.println("<input type=\"password\" name=\"password2\" class=\"form-control\" id=\"pwd\"  value=\"" +(notmatches || emptypassword ? ""  :password2) +"\" placeholder=\"Re-Enter password\">");
		if(emptypassword)
			out.println("<P class=\"text-danger\"> Re-Enter Password</p>");
		else if(notmatches)
			out.println("<P class=\"text-danger\"> Password Not Matches</p>");
		out.println  ("</div>");  
		out.println(" <input type=\"submit\" value=\"Register\" class=\"btn btn-primary\"></input>");
		out.println ("</form>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");
		
				}else{
					PrintWriter out=response.getWriter();
					out.println("<html>");
					out.println("<head><title>success</title>");
							out.println("<body>");
									out.println("<p><h1>Welcome,  " + firstname+ "</h1></p>");
									out.println("<a href=\"http://cs3.calstatela.edu:8080/cs320stu46/Homework2/Login\"><h2>LOGIN</h2></a>");
										out.println("</body></html>");
										flag=false;
				}

		}
	


		
		
		
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		flag=true;
		
	     doGet(request,response);
		
	}

}
