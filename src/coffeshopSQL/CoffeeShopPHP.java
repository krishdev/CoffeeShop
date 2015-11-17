package coffeshopSQL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/CoffeeShopPHP")
public class CoffeeShopPHP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String file = this.getServletContext().getRealPath("/") + "All_Starbucks_Locations_in_the_World.txt";
		try{
			int count=0;
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			// JDBC driver name and database URL
		     String JDBC_DRIVER="com.mysql.jdbc.Driver";  

		      //  Database credentials
		     String USER = "cs320stu08";
		     String PASS = "n0l9w.wf";
		     Connection   conn=null;
		     Statement   stmt =null;
		     String host 	= "cs3.calstatela.edu";
				String port 	= "3306";
				String dbName 	= "cs320stu08";
		     String DB_URL="jdbc:mysql://" + host + ":" + port + "/" + dbName;

		     Class.forName("org.gjt.mm.mysql.Driver").newInstance();

	         // Open a connection
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Entering values in to database");
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
			   
	

		         // Execute SQL query
		            stmt = conn.createStatement();
		            String sql2;
			         sql2="INSERT INTO CoffeeShops(StoreId, Name, StoreNumber, Phone, Street1, Street2, Street3, City, Country, PostalCode, Latitude, Longitude, Timezone) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			br.close();
			System.out.println("Finished Entering");
			  conn.close();
		}
		catch(IOException | SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Error in inputout");
		} 
			
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
