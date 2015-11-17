package coffeshopSQL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminofCoffee")
public class AdminofCoffee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // JDBC driver name and database URL
	     String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	     String DB_URL="jdbc:mysql://localhost/cs320";

	      //  Database credentials
	     String USER = "root";
	     String PASS = "abcd";
	     Connection   conn=null;
	     Statement   stmt =null;
	      // Set response content type
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      String title = "Database Result";
	      String docType =
	        "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
	         out.println(docType +
	         "<html>\n" +
	         "<head><title> Addition </title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<form action=\"AdminofCoffee\" method=\"GET\">"+
	         
	         "<h1 align=\"center\"> Addition using DATABASE </h1>\n");
	      try{
	         // Register JDBC driver
	         Class.forName("com.mysql.jdbc.Driver");

	         // Open a connection
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);

	         // Execute SQL query
	            stmt = conn.createStatement();
	         String sql;
	         sql = "SELECT id, adda, addb FROM addition";
	         ResultSet rs = stmt.executeQuery(sql);
	         
	          String add1=request.getParameter("val1");
	          String add2 = request.getParameter("val2");
	         String sql2="INSERT INTO addition(adda,addb) VALUES (?,?)";
	         PreparedStatement prep = conn.prepareStatement(sql2); // Setting the values which we got from JSP form
	         prep.setString(1, add1); prep.setString(2, add2); prep.executeUpdate(); prep.close();

	         // Extract data from result set
	         while(rs.next()){
	            //Retrieve by column name
	            int id  = rs.getInt("id");
	            int adda = rs.getInt("adda");
	            int addb = rs.getInt("addb");
	           

	            //Display values
	            out.println("ID: " + id + "<br>");
	            out.println("First Value: " + adda + "<br>");
	            out.println("Second Value: " + addb + "<br>");
	            int finalss=adda+addb;
	            out.println("Final Value" +finalss);
	            out.println("<br><br>");
	            
	         }
	         
	         out.println("Enter the values");
	       //table
	 		out.println("<table>");
	 		out.println("<tr>");
	 		out.println("<td>");
	 		out.println("Value 1");
	 		out.println("</td>");
	 		//--
	 		out.println("<td>");
	 		out.println("<input type='text'name='val1' /><br>");
	 		out.println("</td>");
	 		out.println("</tr>");
	 		out.println("<tr>");
	 		
	 		out.println("<td>");
	 		out.println("Value 2");
	 		out.println("</td>");
	 		//--
	 		out.println("<td>");
	 		out.println("<input type='text' name='val2'/><br>");
	 		out.println("</td>");
	 		out.println("</tr>");	
	 		out.println("<tr>");
	 		
	 		out.println("<td>");
	 		out.println("</td>");
	 		out.println("<td>");
	 		//out.println("<p><input type=\"hidden\" name=\"op\" value=\"insert\">");
	 		out.println ("<p><b><input type=\"submit\" value=\"SUBMIT\" name=\"submit\"/>");
	 		out.println("</td>");
	 		out.println("</tr>");
	 		out.println("</table>");
	         out.println("</form></body></html>");

	         // Clean-up environment
	         rs.close();
	         stmt.close();
	         conn.close();
	      }catch(SQLException se){
	         //Handle errors for JDBC
	         se.printStackTrace();
	      }catch(Exception e){
	         //Handle errors for Class.forName
	         e.printStackTrace();
	      }finally{
	         //finally block used to close resources
	         try{
	            if(stmt!=null)
	               stmt.close();
	         }catch(SQLException se2){
	         }// nothing we can do
	         try{
	            if(conn!=null)
	            conn.close();
	         }catch(SQLException se){
	            se.printStackTrace();
	         }//end finally try
	      } //end try
	   }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
