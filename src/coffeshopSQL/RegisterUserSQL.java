package coffeshopSQL;

import homework2.DataBaseUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import lab3.mystore;



@WebServlet("/RegisterUserSQL")
public class RegisterUserSQL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		
		 if( context.getAttribute("valid") == null ){
				ArrayList<Validationclass> registser = new ArrayList<Validationclass>();
				//ArrayList<mystore> register = (ArrayList<mystore>) getServletContext().getAttribute("register");
				Validationclass s=new Validationclass("Doe","test","joe@boxer.com","17336");
			//@SuppressWarnings("unchecked")
		
			registser.add(s);
			getServletContext().setAttribute("valid", registser);
			}
	}
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creating a Array List

		ArrayList<Validationclass> val=new ArrayList<Validationclass>();
		Validationclass v=new Validationclass();
		boolean flag=true;
		
		PrintWriter out = response.getWriter();
		
		 // JDBC driver name and database URL
	     String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	     String DB_URL="jdbc:mysql://localhost/cs320";

	      //  Database credentials
	     String USER = "root";
	     String PASS = "abcd";
	     Connection   conn=null;
	     Statement   stmt =null;

	     //Side validation
	     String errorname="";
	     try{
	         // Register JDBC driver
	         Class.forName("com.mysql.jdbc.Driver");

	         // Open a connection
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);

	         // Execute SQL query
	            //Showing all the list
	            stmt = conn.createStatement();
	           stmt = conn.createStatement();
	         String sql;
	         String name=request.getParameter("name");
	         String password=request.getParameter("password");
	         String confipass=request.getParameter("confpassword");
	         String email=request.getParameter("email");
	         String confiemail=request.getParameter("confiemail");
	         String zipcode=request.getParameter("zipcode");
	         int active=1;
	         
	         if(name != null && !name.isEmpty() && password !=null && !password.isEmpty() && email !=null && !email.isEmpty() && zipcode != null && !zipcode.isEmpty()){
	        	 
	        	 
	        	 
	        	 if(!email.equals(confiemail) || !email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
	        		 flag=false;
	        		 if(!email.equals(confiemail))
	        		 {	
	        			 out.println("Email id and Confirm Email id doesn't match each other<br>");
	        		 }
	        		 if(!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
	        		 {	
	        			 out.println("Enter a valid Email address<br>");
	        		 }	
	        	 }else v.setEmail(email);
	        		 
	        	 //String numbervali="[0-9+]";
	        	 
	        	 if(name.length()==1 || !name.matches("^[a-zA-Z ]*$")){
	        		 flag=false;
	        		 if(!name.matches("[a-zA-Z]")){
	        			 errorname="Only Alphabets are allowed";
	        			 request.setAttribute("errorname", "Only Alphabets are allowed");
	        			 out.println("Only Alphabets are allowed<br>");
	        		 }
	        		 if(name.length()==1){
	        			 errorname="Name should be more than one letter";
	        			 request.setAttribute("errorname", "Name should be more than one letter");
	        			 out.println("Name should be more than one letter<br>");
	        		 }
	        	 }else v.setName(name);
	        	 
	        	 if(zipcode.length()!=5 || !zipcode.matches("\\d+")){
	        		 flag=false;
	        		 if(zipcode.length()!=5){
	        			 out.println("Zipcode is not valid it requires minimum 5 numbers");
	        		 }
	        		 if(!zipcode.matches("\\d+")){
	        			 out.println("Zipcode is not valid it only numbers are allowed");
	        		 }
	        	 }else v.setZipcode(zipcode);
	        		 
	        	
	        	 
	        	 if(flag==true){
	        		
	                 getServletContext().setAttribute("register", val);
	        	  sql = "INSERT INTO user_registration (name,password,email,zipcode,active) VALUES (?,?,?,?,?)";
	 	         PreparedStatement prep = conn.prepareStatement(sql); // Setting the values which we got from JSP form
	 	         prep.setString(1, name);
	 	         prep.setString(2, password);
	 	         prep.setString(3, email);
	 	         prep.setString(4, zipcode);
	 	         prep.setInt(5, active);
	 	         prep.executeUpdate(); prep.close();

	 	         conn.close();
	 	         out.println("Congratulations! You Are Registered Successfully");
	 	    //    getServletContext().setAttribute("valid", "");
	 	        
	 	        response.sendRedirect("RegisterUserSQL");
	        	 }
	        	 getServletContext().setAttribute("valid", v);
	        	
	         }
	        
			   
			   
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	         
		//HTML Design Part
		response.setContentType("text/html");
		out.println("<html><head><title>User Registration Form</title></head><body>");
		out.println(" <form method='get' action='RegisterUserSQL'>");
		out.println("<div align='center'> <h4 style='color:blue'>Register Here</h4>");
		out.println("<table align='center'>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<b>Name</b>");
		out.println("</td>");
		
		out.println("<td>");
		out.println("<input type='text' name='name'");
		
		if(v==null || v.getName()==null)
		{
			out.println("></td>");
		}
		else
		{
			out.println("value="+v.getName()+"></td>");
			
		}
		
		out.println("<td>");
		out.println("<message styleClass='errorname'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<b>Password</b>");
		out.println("</td>");
		
		out.println("<td>");
		out.println("<input type='text' name='password'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("<b>Confirm Password</b>");
		out.println("</td>");
		
		out.println("<td>");
		out.println("<input type='text' name='confpassword'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("<b>Email Id(user id)</b>");
		out.println("</td>");
		
		out.println("<td>");
		out.println("<input type='text' name='email'");
		if(v==null || v.getEmail()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+v.getEmail()+"></td></tr>");
			
		}
		
		
		
		
		out.println("<tr>");
		out.println("<td>");
		out.println("<b>Confirm Email Id</b>");
		out.println("</td>");
		
		out.println("<td>");
		out.println("<input type='text' name='confiemail'");
		if(v==null || v.getEmail()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+v.getEmail()+"></td></tr>");
			
		}
		
		out.println("<tr>");
		out.println("<td>");
		out.println("<b>Zipcode</b>");
		out.println("</td>");
		
		out.println("<td>");
		out.println("<input type='text' name='zipcode' maxlength='5'");
		if(v==null || v.getZipcode()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+v.getZipcode()+"></td></tr>");
			
		}
		
		out.println("<tr>");
		out.println("<td>");
		
		out.println("</td>");
		
		out.println("<td>");
		out.println("<input type='submit' value='email'>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form></body></html>");
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
	}

}
