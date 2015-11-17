package lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CS320/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void init() throws ServletException {

	}
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter writer = response.getWriter();
		
		ServletContext context = this.getServletContext();
		ArrayList<function> posts = (ArrayList<function>) context.getAttribute("reg");
		ArrayList<function> st=new ArrayList<function>();
		writer.println("<!DOCTYPE html><html lang=\"en\">");
		writer.println("<head><title>User Registration Page</title></head>");
		writer.println("<body>");

		// Do we have a new post to add to our GuestBook?
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("Email");
		String email2 = request.getParameter("Email2");
		String password = request.getParameter("password");
		String passwrod2=request.getParameter("password2");
		String street1 = request.getParameter("street1");
		String street2 = request.getParameter("street2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String telephone = request.getParameter("telephone");
		
		System.out.println(password);
		// If both the name and message parameters are present
		// in the request, add a new UserPost object to the list of posts
		boolean passerror=false;
		boolean mailerror=false;
		//boolean fnameerror=false;
		//boolean lnameerror=false;
	//	boolean ziperror=false;
	//	boolean telephoneerror=false;
	
		
	/*	if(fname != null && lname != null){
			
			if(!password.equals(passwrod2))
				passerror=true;
			
			//if(!email.equals(email2))
			if (!email.equals(email2) || !email.matches("^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$")) 
				mailerror=true;
			
			if(!fname.matches("[a-zA-Z]"))
				fnameerror=true;
			if(!zipcode.matches("[0-9]"))
				ziperror=true;
			
			
		if (passerror==false && mailerror==false && fnameerror==false && ziperror==false )	
		
		{
			posts.add(new function(fname, lname,password,email,street1,street2,city,state,zipcode,telephone) );
			getServletContext().setAttribute("reg", posts);
			
			List<function> l=(List<function>) getServletContext().getAttribute("reg");
			
			for(function f:l)
			{
				System.out.println(f.getemail());
				System.out.println(f.getpassword());
			}
			response.sendRedirect("/Loginsession/cs320/LoginPage");
		}
		else {
			
			if (passerror==true )	
			{
			String errormsg="chk the password";
			writer.println(errormsg);
			}
			
			
			if (mailerror==true )	
			{
			String errormsg="chk the email";
			writer.println(errormsg);
			}
			
			if (fnameerror==true )	
			{
			String errormsg="Only alphabets for first name allowed";
			writer.println(errormsg);
			}
			
			if (ziperror==true )	
			{
			String errormsg="Only numbers for zipcode allowed";
			writer.println(errormsg);
			}
			
		}
		

		
		
		}
		*/
		
		if(fname != null && lname != null){
			
			if(!password.equals(passwrod2))
				passerror=true;
			
			if(!email.equals(email2)||!email.matches("^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$"))
				mailerror=true;
		
		if (passerror==false && mailerror==false && email!=null)	
		
		{
			function regis = new function(fname,lname,password,email,street1,street2,city,state,zipcode,telephone);
			 st.add(regis);
	            getServletContext().setAttribute("reg", st);
					
			List<function> l=(List<function>) getServletContext().getAttribute("reg");
			
			for(function f:l)
			{
				System.out.println(f.getemail());
				System.out.println(f.getpassword());
			}
			response.sendRedirect("/cs320stu08/cs320/LoginPage");
		}
		else {
			
			if (passerror==true )	
			{
			String errormsg="chk the password";
			writer.println(errormsg);
			}
			
			
			if (mailerror==true )	
			{
			String errormsg="chk the email";
			writer.println(errormsg);
			}
			
			
		}
		

		
		
		}
		
		
		
				writer.println("<form action=\"Registration\" method=\"get\">");
				
				// Prompt for name
				
				writer.println("<hr />");
				
				
				writer.println("<div align=\"center\">");
				writer.println("<h2 style=\"color: blue;\">Sign Up Here</h2>");
				writer.println("<table style=\"align: center\">");
				//row1
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("First Name");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"fname\"/>");
				writer.println("</td>");
				writer.println("</tr>");
				//row2
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("Last Name");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"lname\" />");
				writer.println("</td>");
				writer.println("</tr>");
				//row3
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("Email Address");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"Email\" />");
				writer.println("</td>");
				writer.println("</tr>");
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("Confirm Email Address");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"Email2\" />");
				writer.println("</td>");
				writer.println("</tr>");
				//row4
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("Password");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"password\" />");
				writer.println("</td>");
				writer.println("</tr>");
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("Confirm Password");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"password2\" />");
				writer.println("</td>");
				writer.println("</tr>");
				//row5
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("Street 1");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"Street1\" />");
				writer.println("</td>");
				writer.println("</tr>");
				//row6
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("Street 2");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"Street2\" />");
				writer.println("</td>");
				writer.println("</tr>");
				//row7
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("City");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"City\" />");
				writer.println("</td>");
				writer.println("</tr>");
				
				//row9
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("State");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"State\" />");
				writer.println("</td>");
				writer.println("</tr>");
				//row10
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("Zipcode");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"Zipcode\" />");
				writer.println("</td>");
				writer.println("</tr>");
				//row8
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				writer.println("Telephone");
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"text\" name=\"Telephone\" style=\"width:40px \" />");
				
				writer.println("<input type=\"text\" name=\"Telephone2\" style=\"width:40px \"/>");
				
				writer.println("<input type=\"text\" name=\"Telephone3\" style=\"width:45px \"/>");
				writer.println("</td>");
				writer.println("</tr>");
				//row11
				writer.println("<tr>");
				//col1
				writer.println("<td>");
				
				writer.println("</td>");
				//col2
				writer.println("<td>");
				writer.println("<input type=\"submit\" value=\"Register\" style=\"background-color: darkkhaki;color: cornsilk;height: 30px;width: 76px;border-bottom-left-radius: 10px;border-bottom-right-radius: 10px;border-top-left-radius: 10px;border-top-right-radius: 10px;cursor: pointer;\" />");
				writer.println("</td>");
				writer.println("</tr>");
				writer.println("</table>");
				writer.println("</div>");
				
				writer.println("</form>");
				
				writer.println("</body>");
				writer.println("</html>");
		
				
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
