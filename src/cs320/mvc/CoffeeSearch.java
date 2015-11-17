package cs320.mvc;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;


@WebServlet("/mvc/CoffeeSearch")
public class CoffeeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("type");
		String searchlat = request.getParameter("lat");
		String searchlon = request.getParameter("lon");
		String lat=request.getParameter("lat");
		String lon=request.getParameter("lon");
		String columnName = "";
		String columnName1 = "";
		String searchString="";

		String searchString1="";
		

		
		String citysearch=request.getParameter("City");
		String Zipcodesearch=request.getParameter("PostalCode");
		 
		  String viewUrl ="/mvc/";
		  
		
		String columnname=null;
		
		
		//Searching in database 
		if (searchType != null && searchType.equals("City")){
			viewUrl += "CitySearch.jsp";
			columnname = "City";
			searchString = request.getParameter("name");
		}
		else if (searchType != null && searchType.equals("PostalCode") ){
			viewUrl += "ZipcodeSearch.jsp";
			columnname = "PostalCode";
			searchString = request.getParameter("zip");
		}
		else if(searchType != null && searchType.equals("gps")){
	    
			viewUrl += "LocateMaps.jsp";
			columnName = "Latitude";
			columnName1 = "Longitude";
			searchString = lat;
			
			System.out.println("Latitude: "+searchString);		
			searchString1 = lon;
			//Displaying coffeeshops within 5miles			
			
		}
		else if(citysearch !=null && !citysearch.isEmpty() && Zipcodesearch !=null && !Zipcodesearch.isEmpty()){
			//response.sendRedirect("../../mvc/index.jsp");
			//return;
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
	        		           System.out.println("Executing the querry");
	        		           if(searchType != null && searchType.equals("gps")){
	        		        	   String sql="SELECT *,(((acos(sin(("
							+searchString+"*pi()/180)) * sin((`"+columnName+"`*pi()/180))+cos(("+searchString+"*pi()/180)) * cos((`"
							+columnName+"`*pi()/180)) * cos((("+searchString1+"- `"+columnName1+
							"`)* pi()/180))))*180/pi())*60*1.1515) as distance FROM `CoffeeShops` HAVING distance <=5";
	        		           	   ResultSet rs=statement.executeQuery(sql);
	        						ArrayList<MapClass> mms = new ArrayList<MapClass>();

	        		           	 System.out.println("Entering the search field in maps");
	        		           	   
	        		           	while(rs.next() ){
	        		           	mms.add(new MapClass(rs.getString("StoreId"),rs.getString("Name"),
										rs.getString("Phone"),
									    rs.getString("City"),rs.getString("Latitude"), rs.getString("Longitude"), rs.getString("PostalCode")));
	        		           	}
	        					request.setAttribute("mms", mms);	
	        					System.out.println("Maping");
	        					int vb=0;
	        					int vc=0;
	        					int vd=0;
	        		       		  String[] arraymap=new String[5];
	        		       		  String[] arraylon=new String[5];
	        		       		  String[] arrayname=new String[5];
	        					for (MapClass msps : mms)
	        				    {
	        						System.out.println("loca: "+msps.getLati());
	        						 arraymap[vb]=msps.getLati();
		        		       			arraylon[vc]=msps.getLongi();
		        		       			  arrayname[vd]=msps.getName();
		        		       			  vb++;vc++;vd++;
		        		       			String lat1=arraymap[0]; String lon1=arraylon[0]; String nam1=arrayname[0];
			        		       		 String lat2=arraymap[1]; String lon2=arraylon[1]; String nam2=arrayname[1];
			        		       		 String lat3=arraymap[2]; String lon3=arraylon[2]; String nam3=arrayname[2];
			        		       		request.setAttribute("lat1",lat1);   
			        		       		request.setAttribute("lon1",lon1);
			        		       		request.setAttribute("lat2",lat2);   
			        		       		request.setAttribute("lon2",lon2);   
			        		       		request.setAttribute("nam1",nam1);   
			        		       		request.setAttribute("nam2",nam2);
	        				    }
	        					System.out.println("loca: "+arraymap[0]);
	        					

	        		       		
	        		           }
	        		           else if (searchType != null && searchType.equals("City")){
	        		        	   //SELECT DISTINCT * FROM cs320.coffeeshops WHERE city like '%las %' or SOUNDEX(coffeeshops.city) like Soundex('huston');
	           	String   sql="SELECT DISTINCT StoreId, Name, Phone, Street1, Street2, Street3, City, PostalCode, Latitude, Longitude FROM CoffeeShops WHERE `" 
										+ columnname 
										+ "` like '%" 
										+ searchString 
										+ "%' or SOUNDEX("
										+ columnname
										+ ") like Soundex('"
										+ searchString
										+ "')";
	           	   ResultSet rs=statement.executeQuery(sql);
	          // 	ResultSet resultSet = statement.executeQuery(query);
	           	   System.out.println("Entering the search field");
	           	   

					ArrayList<ModelCoffeeSearch> books = new ArrayList<ModelCoffeeSearch>();
					
					System.out.println("Iterating Over Results");
					while(rs.next() ){
						books.add(new ModelCoffeeSearch(rs.getString("StoreId"),rs.getString("Name"),
											rs.getString("Phone"),
										    rs.getString("City"),rs.getString("Latitude"), rs.getString("Longitude"), rs.getString("PostalCode")));
				
						//request.setAttribute("MVCCoffeeSearch", books);
						
					}
					request.setAttribute("MVCCoffeeSearch", books);
	        		           // Attach the results to the request object
					
					System.out.println("Successfully Searched");
					for (ModelCoffeeSearch coffeeShop : books)
				    {
					System.out.println(coffeeShop.getName());	
				    }				
					}
	        		           else{
	        			           	String   sql="SELECT StoreId, Name, Phone, Street1, Street2, Street3, City, PostalCode, Latitude, Longitude FROM CoffeeShops WHERE `" 
	        												+ columnname 
	        												+ "` like '%" 
	        												+ searchString 
	        												+ "%'";
	        			           	   ResultSet rs=statement.executeQuery(sql);
	        			          // 	ResultSet resultSet = statement.executeQuery(query);
	        			           	   System.out.println("Entering the search field");
	        			           	   

	        							ArrayList<ModelCoffeeSearch> books = new ArrayList<ModelCoffeeSearch>();
	        							
	        							System.out.println("Iterating Over Results");
	        							while(rs.next() ){
	        								books.add(new ModelCoffeeSearch(rs.getString("StoreId"),rs.getString("Name"),
	        													rs.getString("Phone"),
	        												    rs.getString("City"),rs.getString("Latitude"), rs.getString("Longitude"), rs.getString("PostalCode")));
	        						
	        								//request.setAttribute("MVCCoffeeSearch", books);
	        								
	        							}
	        							request.setAttribute("MVCCoffeeSearch", books);
	        			        		           // Attach the results to the request object
	        							
	        							System.out.println("Successfully Searched");
	        							for (ModelCoffeeSearch coffeeShop : books)
	        						    {
	        							System.out.println(coffeeShop.getName());	
	        						    }				
	        							}
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
	
	@SuppressWarnings("unused")
	private double deg2rad(double deg){
		return (deg*Math.PI/180.0);
	}

	@SuppressWarnings("unused")
	private double rad2deg(double rad) {
		
		return (rad * 180.0 / Math.PI);
		
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
   	         
	}
	
}
