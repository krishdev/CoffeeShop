package cs320.mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mvc/CoffeeShopDetails")
public class CoffeeShopDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchid = request.getParameter("id");
		  String viewUrl ="/mvc/";

		  String columnname=null;
			String searchString=null;
			//Searching in database 
			if (searchid != null && !searchid.isEmpty()){
				viewUrl += "CoffeeShopDetails.jsp";
				columnname = "StoreId";
				searchString = searchid;
			}
			else if(searchid.isEmpty())
			{
				viewUrl = "../../mvc/index.jsp";
				columnname = searchString = null;
			}
			
			
			// Construct the URL
		String username = "cs320stu08";
			String password = "n0l9w.wf";
			String host 	= "cs3.calstatela.edu";
			String port 	= "3306";
			String dbName 	= "cs320stu08";

			String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName; 
		
			    Connection   conn=null;   
			    System.out.println("Entering the Querry");
		           if( searchString != null && searchString.trim().length() > 0 ){
		        	   try{
		        		// Register JDBC driver
	        		        Class.forName("com.mysql.jdbc.Driver");

	        		        // Open a connection
	        		        conn = DriverManager.getConnection(url, username, password);

	        		           Statement statement = conn.createStatement();
	        		        // Execute SQL query
	        		           //Showing all the list
	        		          // stmt = conn.createStatement();
	        		           System.out.println("Executing the querry1");
	        					System.out.println(searchString);
	        					System.out.println(columnname);

	           	String   sql="SELECT Name, Phone, Street1, Street2, Street3, City, PostalCode, Latitude, Longitude FROM CoffeeShops WHERE `" 
										+ columnname 
										+ "` like '" 
										+ searchString 
										+ "'";
	           	   ResultSet rs=statement.executeQuery(sql);
	           	   System.out.println("Entering the search field");
	           	   
	
	           	   CoffeeShopBean csb = new CoffeeShopBean();
	           	   
	           	while(rs.next() ){
	           	csb.setSName(rs.getString("Name"));
	           	csb.setSStreet1(rs.getString("Street1"));
	           	csb.setSStreet2(rs.getString("Street2"));
	           	csb.setSStreet3(rs.getString("Street3"));
	           	csb.setSTelephone(rs.getString("Phone"));
	           	csb.setSLatitude(rs.getString("Latitude"));
	           	csb.setSLongitude(rs.getString("Longitude"));
	           	csb.setSCity(rs.getString("City"));
	           	csb.setSZipcode(rs.getString("PostalCode"));
	           	
	           	}
	           	request.setAttribute("csbeans", csb);
	           	
	           	System.out.println(csb.getSName());

		        	   }
		        	   catch (SQLException sqle){
							System.out.println(sqle.getMessage());
							
						}catch(Exception e){
							System.out.println(e.getMessage());
							
						}finally{
							
								try {
									conn.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
		           }
		   	         request.getRequestDispatcher( viewUrl ).forward(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
