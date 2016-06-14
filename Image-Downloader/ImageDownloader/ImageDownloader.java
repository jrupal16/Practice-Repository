package Lab2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.InputStream;


@WebServlet("/Lab2/ImageDownloader")
public class ImageDownloader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	 String image = null;
	 System.out.println("Image is ="+image);
		if(request.getParameter("image") != null){
			
		String filename = request.getParameter("image") + ".png";
		
		System.out.println("Image is ="+image);
		System.out.println("filename is ="+filename);
		String path = this.getServletContext().getRealPath("images/"+filename);
		
		    response.setContentType("image/png");
	        response.setHeader("Content-Disposition","attachment;filename="+filename); 
		
	        OutputStream out = response.getOutputStream();
		
	        File file = new File(path);
	        FileInputStream inStream = new FileInputStream(file); 
	           
	       
	    	
	    	
	    	 byte[] buffer = new byte[4096];
	         int bytesRead = -1;
	          
	         while ((bytesRead = inStream.read(buffer)) != -1) {
	             out.write(buffer, 0, bytesRead);
	         }
	          
	         inStream.close();
	         out.close();     
	       
	      //  InputStream input = (InputStream) getServletContext().getResourceAsStream("/image");
			
		}
		
		else{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Image</title>");
		out.println ("<meta charset=\"utf-8\">");
		out.println ("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println ("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<div class=\"jumbotron\">");
		out.println("<h1>ImageDownloader</h1>");
		out.println("<div class=\"container\">");
		out.println("<form action=\"ImageDownloader\" role=\"form\" method=\"post\">");
		out.println("<a href=\"ImageDownloader?image=bean\">Mr. Bean</a></br>");
		out.println("<a href=\"ImageDownloader?image=clint\">Clint</a></br>");
		out.println("<a href=\"ImageDownloader?image=gaga\">Gaga</a></br>");
		out.println("<a href=\"ImageDownloader?image=hermoine\">Hermoine</a></br>");
		out.println("<a href=\"ImageDownloader?image=joker\">Joker</a></br>");
		out.println("<a href=\"ImageDownloader?image=mj\">MJ</a></br>");
		out.println("<a href=\"ImageDownloader?image=penny\">Penny</a></br>");
		out.println("<a href=\"ImageDownloader?image=sheldon\">Sheldon</a></br>");
		out.println("<a href=\"ImageDownloader?image=steve\">Steve</a>");
		out.println ("</form>");
		out.println("</body>");
		out.println("</html>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request,response);
	}

}
