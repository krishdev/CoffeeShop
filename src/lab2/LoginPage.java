package lab2;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab3.mystore;


@WebServlet("/cs320/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//function functionObject=new function(fnan, fnan, fnan, fnan, fnan, fnan, fnan, fnan, fnan, fnan);

		public void init() throws ServletException {
	//ServletContext context = this.getServletContext();
	ServletContext context = this.getServletContext();
			
			if( context.getAttribute("reg") == null ){
				ArrayList<function> posts = new ArrayList<function>();
				
				function s=new function("Joe", "Doe","aa1!","joe@boxer.com","Apt94 401","EBay State St","Alhambra","CA","91801","6266237336" );
				function s1=new function("John", "Doe","bb2@","john@doe.com","Apt94 401","EBay State St","Alhambra","CA","91801","6266237336" );
				//posts.add(new function("Mary", "Game Over!") );
				posts.add(s);
				posts.add(s1);
				getServletContext().setAttribute("reg", posts);
			}
		}
		
		
		String fnan;
		String fpoas;
		
		
		
		
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter writer = response.getWriter();
			
			//ServletContext context = this.getServletContext();
			@SuppressWarnings("unchecked")
			ArrayList<function> posts = (ArrayList<function>) getServletContext().getAttribute("LoginPageList");
			if(posts!=null){
			for(function s:posts)
			{
				System.out.println(s.getemail());
				System.out.println(s.getpassword());
			}}
			writer.println("<!DOCTYPE html><html lang=\"en\">");
			writer.println("<head><title>Single Page Counter</title></head>");
			writer.println("<body>");

			// Do we have a new post to add to our GuestBook?
			//String uname = request.getParameter("namelogin");
			//String upass = request.getParameter("passwordenter")	
			
			// Display the Input Form
					writer.println("<form action=\"LoginPage\" method=\"post\">");
					
					// Prompt for name
					
					writer.println("<hr />");
					
					writer.println("<div align=\"center\">");
					writer.println("<h2 style=\"color: blue;\">Sign In Here</h2>");
					writer.println("<table>");
					writer.println("<tr>");
					writer.println("<td>");
					writer.println("Email id");
					writer.println("</td>");
					writer.println("<td>");
					writer.println("<input type=\"text\" name=\"fname1\" />");	
					
					writer.println("</td>");
					
					writer.println("</tr>");
					writer.println("<tr>");
					writer.println("<td>");
					writer.println("Password");
					writer.println("</td>");
					writer.println("<td>");
					writer.println("<input type=\"password\" name=\"upass\" />");					
					writer.println("</td>");
					writer.println("<td>");
					writer.println("<input type=\"submit\" value=\"Login\" />");
					writer.println("</td>");
					writer.println("</tr>");
					writer.println("<tr>");
					writer.println("<td>");
					writer.println("<a href=\"/cs320stu08/CS320/Registration\">Register Here</a>");
					writer.println("</td>");
					writer.println("</tr>");
					writer.println("</table>");
					
					
					
						
					
					

					
					
					writer.println("</form>");
					
					writer.println("</body>");
					writer.println("</html>");
					
					
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
			List<function> l=(List<function>) getServletContext().getAttribute("reg");
			
			String un=request.getParameter("fname1");
			String pass=request.getParameter("upass");
			
			
			String msg=" ";
			
			for(function f:l)
			{
				if(f.getemail().equals(un) && f.getpassword().equals(pass))
				{
					response.sendRedirect("/cs320stu08/cs320/welcome?email="+f.getfName());
					
				}
				
			}
			
			/*
			if(un.equals(username) && pass.equals(password1)){
				response.sendRedirect("/Loginsession/Index.html");
				
			}
			else if(un.equals(username2) && pass.equals(password2)){
				response.sendRedirect("/Loginsession/Index.html");
				// msg="Sorry Try again";
				
			}
			else if(un.equals(fnan) && pass.equals(fpoas)){
				response.sendRedirect("/Loginsession/Index.html");
				
			}
			
			else{
				 msg="Sorry Try again";
			}*/
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<h1 style=\"color: red\"> Sorry Try Again </h1>");
			
					
		}

	}