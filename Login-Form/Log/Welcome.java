package Homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Homework2/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Welcome() {
        super();
    } 

	
	@SuppressWarnings({"unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

ArrayList<CS320User> Homework2User = (ArrayList<CS320User>) this.getServletContext().getAttribute("HomeworkUsers");
                            HttpSession session = request.getSession();

                    
            if (Homework2User == null) {
            	response.sendRedirect("Login");
                return;
            }


              if(session.getAttribute("CurrentUser") == null){
	
   	               Cookie[] C = request.getCookies();
                   if (C != null) {
                	   for (Cookie cookie : C) {
                		   if (cookie.getName().equals("Homework2")) {
                			   
                			   
                
                			   for(CS320User ur : Homework2User){
                	
                				   try {
                					   MessageDigest digest = MessageDigest.getInstance("SHA-256");
                					   byte[] hash = digest.digest(ur.getemail().getBytes("UTF-8"));
                					   StringBuffer stringBuffer = new StringBuffer();
                					   for (int j = 0; j < hash.length; j++) {
                						   stringBuffer.append(Integer.toString((hash[j] & 0xff) + 0x100, 16).substring(1));
                					   }
   						 
                					   if(cookie.getValue().equals(stringBuffer.toString())){
                		

                						   session.setAttribute("CurrentUser",ur);
                						
                						   break;
                					   }
                					   
                	
                				   }// try close 
                				   catch (NoSuchAlgorithmException e) {
                					   e.printStackTrace();
                				   }// catch close
                			   }// for close
                		   }//if close
                   
                  
                	   }// for close
                   }// if close

                   if (session.getAttribute("CurrentUser") == null) {
	                   response.sendRedirect("Login");
	                   return;
	               }
              }
              

	
                             
              out.println("<!DOCTYPE html>");
              out.println("<html>");
              out.println("<head>");
              out.println("	<meta charset=\"UTF-8\">");
              out.println("	<title>Welcome</title>");
              out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
              out.println("</head>");
              out.println("<body>");
              out.println("<p class=\"text-right\">");
              out.println("</p>");
              out.println("<div class=\"container\">");
out.println("	<div class=\"page-header\">");
out.println("	</div>");
							CS320User ur = (CS320User)session.getAttribute("CurrentUser");
							if ( ur == null)
								out.println("session is null");
							else
								out.println("<h2> Session And Cookies</h2>");
								out.println("<h1>Welcome, " + ur.getfirst() + " "+ ur.getlast() +"!</h1>" );
     out.println("</div>");
     out.println("</body>");
     out.println("</html>");

	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request,response);
		}}
