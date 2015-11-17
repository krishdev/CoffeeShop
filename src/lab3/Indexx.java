package lab3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lab3/Indexx")
public class Indexx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<!DOCTYPE html><html lang=\"en\">");
		writer.println("<head><title>User Registration Page</title></head>");
		writer.println("<body>");
		writer.println("<form action=\"Reguser\" method=\"get\">");
		
		// Prompt for name
		
		writer.println("<hr />");
		
		
		writer.println("<div align=\"center\">");
		writer.println("<h2 style=\"color: blue;\">Hello User</h2>");
		writer.println("<table style=\"align: center\">");
		//row1
		writer.println("<tr>");
		//col1
		writer.println("<td>");
		writer.println("Welcome "+request.getParameter("email"));
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("</table>");
		writer.println("</div>");
		
		writer.println("</form>");
		
		writer.println("</body>");
		writer.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
