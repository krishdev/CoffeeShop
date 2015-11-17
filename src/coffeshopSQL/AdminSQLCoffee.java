package coffeshopSQL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AdminSQLCoffee")
public class AdminSQLCoffee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException {
		String file = this.getServletContext().getRealPath("/") + "All_Starbucks_Locations_in_the_World.txt";
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			// JDBC driver name and database URL
		     String JDBC_DRIVER="com.mysql.jdbc.Driver";  
		     String DB_URL="jdbc:mysql://localhost/cs320";
		     int count=0;
		      //  Database credentials
		     String USER = "root";
		     String PASS = "abcd";
		     Connection   conn=null;
		     Statement   stmt =null;
		     Class.forName("com.mysql.jdbc.Driver");

	         // Open a connection
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);

	         // Execute SQL query
	            stmt = conn.createStatement();
			System.out.println("Entering values in database");
			while ((line = br.readLine()) != null) {
				try{
			   String[] tokens = line.split("\t");
			   String storeid=tokens[0].trim();
			   String storename=tokens[1].trim();
			   String storenumber=tokens[2].trim();
			   String phonenumber=tokens[3].trim();
			   String stree1=tokens[4].trim();
			   String stree2=tokens[5].trim();
			   String stree3=tokens[6].trim();
			   String city=tokens[7].trim();			   
			   String country=tokens[8].trim();
			   String zipcode=tokens[9].trim();
			   String lati=tokens[10].trim();
			   String longi=tokens[11].trim();
			    String zone=tokens[12].trim();
			   
		
		            String sql2;
			         sql2="INSERT INTO coffeeshops(StoreId, Name, StoreNumber, Phone, Street1, Street2, Street3, City, Country, PostalCode, Latitude, Longitude, Timezone) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			         PreparedStatement prep = conn.prepareStatement(sql2); // Setting the values which we got from JSP form
			         prep.setString(1, storeid);
					 prep.setString(2, storename);
					 prep.setString(3,storenumber);
			         prep.setString(4, phonenumber);
			         prep.setString(5, stree1);
			         prep.setString(6, stree2);
			         prep.setString(7, stree3);
			         prep.setString(8, city);
			         prep.setString(9, country);
			         prep.setString(10, zipcode);
					 prep.setString(11, lati);
			         prep.setString(12, longi);
					 prep.setString(13, zone);
			         prep.executeUpdate(); prep.close();
			         System.out.println(count++);
				}
				catch(Exception e){
					e.printStackTrace();
				} 
			   
			   
			}
			System.out.println("Entered successfully");
			conn.close();
		}
		catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
			    
			   
			   
			   

	}
	
	
	
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
	         "<head><title> Coffee Shop </title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<form action=\"AdminSQLCoffee\" method=\"GET\">"+
	         
	         "<h1 align=\"center\"> Search for Coffee Shops </h1>\n");
	      try{
	         // Register JDBC driver
	         Class.forName("com.mysql.jdbc.Driver");

	         // Open a connection
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);

	         // Execute SQL query
	            //Showing all the list
	            stmt = conn.createStatement();
	       /*     stmt = conn.createStatement();
	         String sql;
	         sql = "SELECT name, phonenumber, address, city, state, zipcode, lati, longi FROM coffeeshop";
	         ResultSet rs = stmt.executeQuery(sql);
	         
	         while(rs.next()){
	        	 String name=rs.getString("name");
	        	 String phonenumber=rs.getString("phonenumber");
	        	 String address=rs.getString("address");
	        	 
	        	 
	        	 out.println("Name of the Coffee Shop: "+name+"<br>");
	        	 out.println("Phone Number: "+phonenumber+"<br>");
	        	 out.println("Address: "+address+"<br>");
	        	 out.println("<br><br><br>");
	        	 
	         }
	         
	         
	         rs.close();
	         stmt.close();
	         conn.close();    */
	            
	            //Displaying according to the search
	          //SEARCH QUERY
	   	     String citysearch=request.getParameter("city");
	   	     String zipcodesearch=request.getParameter("zipcode");
	             
	           // sql="SELECT name, phonenumber, address, city, state, zipcode FROM coffeeshop WHERE city LIKE 'Los Angeles'";
	            if(citysearch != null && zipcodesearch !=null && !citysearch.isEmpty() && !zipcodesearch.isEmpty()){
	            	String   sql="SELECT name, phonenumber, address, city, state, zipcode FROM coffeeshop WHERE city LIKE '"+citysearch+"' AND zipcode LIKE '"+zipcodesearch+"'";
	            	   ResultSet rs=stmt.executeQuery(sql);
	    	           out.println("<b>Search Results</b>");
	    	            while(rs.next()){
	    	            	String namecoffe=rs.getString("name");
	    	            	String phonenocoffe=rs.getString("phonenumber");
	    	            	String addresscoffee=rs.getString("address");
	    	            	String citycoffee=rs.getString("city");
	    	            	
	    	            	//displaying
	    	            	 out.println("Name of the Coffee Shop: "+namecoffe+"<br>");
	    		        	 out.println("Phone Number: "+phonenocoffe+"<br>");
	    		        	 out.println("Address: "+addresscoffee+"<br>");
	    		        	 out.println("City: "+citycoffee+"<br>");
	    		        	 out.println("<br><br><br>");
	    	            }
	    	           // prep.executeUpdate(); prep.close();
	    	            

	    	            rs.close();
	    	            stmt.close();
	    	            conn.close();
	            }
	            else if((citysearch != null && !citysearch.isEmpty()) ||( zipcodesearch !=null  && !zipcodesearch.isEmpty())){
	            	String   sql="SELECT name, phonenumber, address, city, state, zipcode FROM coffeeshop WHERE city LIKE '"+citysearch+"' OR zipcode LIKE '"+zipcodesearch+"'";
	            	   ResultSet rs=stmt.executeQuery(sql);
	    	           out.println("<b>Search Results</b>");
	    	            while(rs.next()){
	    	            	String namecoffe=rs.getString("name");
	    	            	String phonenocoffe=rs.getString("phonenumber");
	    	            	String addresscoffee=rs.getString("address");
	    	            	String citycoffee=rs.getString("city");
	    	            	
	    	            	//displaying
	    	            	 out.println("Name of the Coffee Shop: "+namecoffe+"<br>");
	    		        	 out.println("Phone Number: "+phonenocoffe+"<br>");
	    		        	 out.println("Address: "+addresscoffee+"<br>");
	    		        	 out.println("City: "+citycoffee+"<br>");
	    		        	 out.println("<br><br><br>");
	    		        	 
	    	            }
	    	            rs.close();
 	    	            stmt.close();
 	    	            conn.close();
	    	            	
	    	            }
	            else if((citysearch == null || citysearch.isEmpty()) &&( zipcodesearch ==null  || zipcodesearch.isEmpty())){
	            	out.println("Enter any of the fields");
	            }
	    	           // prep.executeUpdate(); prep.close();
	    	            

	    	           
	            
	            out.println("<div align='center'>");
	         out.println("Enter the values");
		       //table
		 		out.println("<table>");
		 		out.println("<tr>");
		 		out.println("<td>");
		 		out.println("Enter City");
		 		out.println("</td>");
		 		//--
		 		out.println("<td>");
		 		out.println("<input type='text'name='city' /><br>");
		 		out.println("</td>");
		 		out.println("</tr>");
		 		out.println("<tr>");
		 		
		 		out.println("<td>");
		 		out.println("Enter Zipcode");
		 		out.println("</td>");
		 		//--
		 		out.println("<td>");
		 		out.println("<input type='text' name='zipcode'/><br>");
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
		 		out.println("<div>");
		         out.println("</form></body></html>");
	           
	            
		       
	         
	      }
	      catch(SQLException se){
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
	      }
	      
	          
	          
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
