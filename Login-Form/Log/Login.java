package Homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Homework2/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		
		if (context.getAttribute("HomeworkUsers") == null ){
			
			ArrayList<CS320User> Homework2User = new ArrayList<CS320User>();
			
			
            Homework2User.add( new CS320User("John","Doe","john@doe.com","1!"));
			Homework2User.add( new CS320User("Joe", "Boxer","joe@boxer.com","2@"));
			context.setAttribute("HomeworkUsers", Homework2User);
		}
	}
 
   
	@SuppressWarnings({"unchecked", "unused" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*ServletContext context = this.getServletContext();

		ArrayList<CS320User> Homework2User = (ArrayList<CS320User>) 
				context.getAttribute("HomeworkUsers");*/

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login</title>");
		out.println ("<meta charset=\"utf-8\">");
		out.println ("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println ("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("	<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<div class=\"jumbotron\">");
		out.println("<h2>LOGIN</h2>");
		if (request.getAttribute("error") != null)
			out.println("<p class=\"text-danger\">" + request.getAttribute("error") + "</p>");
		out.println("<form action='Login' method='post'>");
		out.println(" <div class=\"form-group\">");
		out.println("    <label for=\"username\"> Username:</label>");
    	out.println("    <input type=\"text\" name =\"username\" class=\"form-control\" id=\"username\">");
		out.println("  </div>");
		out.println("  <div class=\"form-group\">");
		out.println("    <label for=\"password\">Password:</label>");
	    out.println("  <input  type=\"password\" name=\"password\" class=\"form-control\" id=\"password\">");
		out.println("  </div>");
		out.println("  <div class=\"checkbox\">");
	    out.println("    <label><input name=\"rememberme\" type=\"checkbox\"> Remember Me</label>");
		out.println("  </div>");
		out.println("  <button type=\"Login\" class=\"btn btn-default\" value=\"Login\">Login</button>");
		out.println("</div>");
		out.println("</div>"); 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
			}
		
		
		
		
	

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		ArrayList<CS320User> Homework2User = (ArrayList<CS320User>) context.getAttribute("HomeworkUsers");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		request.setAttribute("error", "Invalid Username / Password");
			
			if( request.getParameter("username") != null && request.getParameter("password") != null ){
				for(CS320User U: Homework2User){
				
					if (U.getemail().equals(username) && U.getpassword().equals(password)){
						if(request.getParameter("rememberme")!= null){
							try {
								MessageDigest digest = MessageDigest.getInstance("SHA-256");
								byte[] hash = digest.digest(username.getBytes("UTF-8"));
								StringBuffer stringBuffer = new StringBuffer();
								for (int j = 0; j < hash.length; j++) {
									stringBuffer.append(Integer.toString((hash[j] & 0xff) + 0x100, 16)
											.substring(1));
								}
								Cookie C = new Cookie("Homework2", stringBuffer.toString());
								C.setMaxAge(60*60*24);
								response.addCookie( C );

							} catch (NoSuchAlgorithmException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						 }//if close
							
						HttpSession session = request.getSession();
						
			            session.setAttribute("CurrentUser", U);
						response.sendRedirect("Welcome");
						
					}
				

					
				
			}// for close
			}//if close

		
		
		doGet(request,response);
		
		
	}
}
