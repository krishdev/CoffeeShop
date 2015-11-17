package finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String type1=request.getParameter("TypeMedia1");
			String search1 = request.getParameter("MediaName1");
			String type2=request.getParameter("TypeMedia2");
			String search2 = request.getParameter("MediaName2");
			String type3=request.getParameter("TypeMedia3");
			String search3 = request.getParameter("MediaName3");
			String lloan=request.getParameter("Loan");
		/*	
			String username = "cs320stu08";
		String password = "n0l9w.wf";  
		String host 	= "cs3.calstatela.edu";
		String port 	= "3306";
		String dbName 	= "cs320stu08";

		String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		
		*/
			/*
			String JDBC_DRIVER="com.mysql.jdbc.Driver";  
		     String DB_URL="jdbc:mysql://localhost/cs320";
		      //  Database credentials
		     String USER = "root";
		     String PASS = "abcd";
		     */
		     
		     /*
		      * // this will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // setup the connection with the DB.
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/feedback?"
              + "user=sqluser&password=sqluserpw");

      // statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // resultSet gets the result of the SQL query
      resultSet = statement
          .executeQuery("select * from FEEDBACK.COMMENTS");
      writeResultSet(resultSet);
		      * 
		      * */
		     
	System.out.println("About to enter try");	
try {
	System.out.println("Entered try");	
	System.out.println(search1);

	// Connection c = DriverManager.getConnection(url, username, n0l9w.wf);
  //  Connection c = DriverManager.getConnection(DB_URL,USER,PASS);
	if(request.getParameter("CDSearch") != null){
		System.out.println("Entered");
	  /*  Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Class");

		Statement stmt1 = c.createStatement();
		
	System.out.println("Result set");
		String sql="select TypeMedia,MediaName,CreatedDate,Borrower,LoanTime from Media Where TypeMedia like '"
																	+type1
																	+"' AND MediaName like '%" 
																	+ search1
																	+ "%'";
		 ResultSet rs=stmt1.executeQuery(sql);*/
	
//
	      Class.forName("com.mysql.jdbc.Driver") ;
	      System.out.println("Driver loaded success");
	      // Step 2: Establish the connection to the database.
	      String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu08";
	      Connection connect = DriverManager.getConnection(url,"cs320stu08","n0l9w.wf" );
	      
	      System.out.println("Connection Successful");

	      
	      // statements allow to issue SQL queries to the database
	   Statement statement = connect.createStatement();
	      // resultSet gets the result of the SQL query
	      System.out.println("Statement");
String Sql="select id,TypeMedia,MediaName,CreatedDate,BorrowerName,LoanTime from Media Where TypeMedia like '"
																						+type1
																						+"' AND MediaName like '%" 
																						+ search1
																						+ "%'";
System.out.println("SQL");
	    ResultSet  rs = statement.executeQuery(Sql);
	     
		System.out.println("Completed Result set");
			ArrayList<library> entries = new ArrayList<library>();

		while (rs.next()) {
			System.out.println("While loop"+rs.getInt("id"));
			entries.add(new library(rs.getInt("id"),rs.getString("MediaName"),rs.getDate("CreatedDate"),rs.getString("BorrowerName"),
				    rs.getDate("LoanTime"),rs.getString("TypeMedia")));

		}
		request.setAttribute("cdsearch", entries);
		for(library li:entries)
		{
		System.out.println(li.getMedianame()+" "+li.getId());	
		}
		connect.close();
	}
	
	
	else if(request.getParameter("DVDSearch") != null){
		System.out.println("Entered");
		 Class.forName("com.mysql.jdbc.Driver");
	  /*  Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Class");

		Statement stmt1 = c.createStatement();
		
	System.out.println("Result set");
		String sql="select TypeMedia,MediaName,CreatedDate,Borrower,LoanTime from Media Where TypeMedia like '"
																	+type1
																	+"' AND MediaName like '%" 
																	+ search1
																	+ "%'";
		 ResultSet rs=stmt1.executeQuery(sql);*/
		
		// this will load the MySQL driver, each DB has its own driver
		  String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu08";
	      Connection connect = DriverManager.getConnection(url,"cs320stu08","n0l9w.wf" );
	           System.out.println("Connection Successful");

	      // statements allow to issue SQL queries to the database
	   Statement statement = connect.createStatement();
	      // resultSet gets the result of the SQL query
	      System.out.println("Statement");
	      String Sql="select id,TypeMedia,MediaName,CreatedDate,BorrowerName,LoanTime from Media Where TypeMedia like '"
																						+type2
																						+"' AND MediaName like '%" 
																						+ search2
																						+ "%'";
System.out.println("SQL");
	    ResultSet  rs = statement.executeQuery(Sql);
	     
		System.out.println("Completed Result set");
			ArrayList<library> entries = new ArrayList<library>();

		while (rs.next()) {
			System.out.println("While loop");
			entries.add(new library(rs.getInt("id"),rs.getString("MediaName"),rs.getDate("CreatedDate"),rs.getString("BorrowerName"),
				    rs.getDate("LoanTime"),rs.getString("TypeMedia")));

		}
		request.setAttribute("DVDsearch", entries);
		for(library li:entries)
		{
		System.out.println(li.getMedianame()+" "+li.getId());	
		}
		connect.close();
}
//----
	else if(request.getParameter("BluSearch") != null){
		System.out.println("Entered");
		  /*  Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class");

			Statement stmt1 = c.createStatement();
			
		System.out.println("Result set");
			String sql="select TypeMedia,MediaName,CreatedDate,Borrower,LoanTime from Media Where TypeMedia like '"
																		+type1
																		+"' AND MediaName like '%" 
																		+ search1
																		+ "%'";
			 ResultSet rs=stmt1.executeQuery(sql);*/
			
			// this will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Class");
		      // setup the connection with the DB.  jdbc:mysql://localhost/cs320
		      String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu08";
		      Connection connect = DriverManager.getConnection(url,"cs320stu08","n0l9w.wf" );
		        System.out.println("Connection Successful");

		      // statements allow to issue SQL queries to the database
		   Statement statement = connect.createStatement();
		      // resultSet gets the result of the SQL query
		      System.out.println("Statement");
	String Sql="select id,TypeMedia,MediaName,CreatedDate,BorrowerName,LoanTime from Media Where TypeMedia like '"
																							+type3
																							+"' AND MediaName like '%" 
																							+ search3
																							+ "%'";
	System.out.println("SQL");
		    ResultSet  rs = statement.executeQuery(Sql);
		     
			System.out.println("Completed Result set");
				ArrayList<library> entries = new ArrayList<library>();

			while (rs.next()) {
				System.out.println("While loop");
				entries.add(new library(rs.getInt("id"),rs.getString("MediaName"),rs.getDate("CreatedDate"),rs.getString("BorrowerName"),
					    rs.getDate("LoanTime"),rs.getString("TypeMedia")));

			}
			request.setAttribute("Blusearch", entries);
			for(library li:entries)
			{
			System.out.println(li.getMedianame());	
			}
			connect.close();
	}else if(request.getParameter("Loan") != null){
		System.out.println("update querry");
		  /*  Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class");

			Statement stmt1 = c.createStatement();
			
		System.out.println("Result set");
			String sql="select TypeMedia,MediaName,CreatedDate,Borrower,LoanTime from Media Where TypeMedia like '"
																		+type1
																		+"' AND MediaName like '%" 
																		+ search1
																		+ "%'";
			 ResultSet rs=stmt1.executeQuery(sql);*/
			
			// this will load the MySQL driver, each DB has its own driver
		int Loan=Integer.parseInt(lloan);

	      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Class of update");
		      // setup the connection with the DB.  jdbc:mysql://localhost/cs320
		      String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu08";
		      Connection connect = DriverManager.getConnection(url,"cs320stu08","n0l9w.wf" );
		         System.out.println("Connection Successful in update");

		      // statements allow to issue SQL queries to the database
		   Statement statement = connect.createStatement();
		      // resultSet gets the result of the SQL query
		      System.out.println("Statement in update");
	String Sql="UPDATE Media SET Loan = 'No',BorrowerName='' WHERE id = '"+Loan+"'";
	/*
	 * UPDATE cs320.media SET Loan ='No' AND BorrowerName='' WHERE lid like "+Loan;
	 */
	//UPDATE cs320.media SET Loan ='No' AND BorrowerName='' WHERE TypeMedia like '1' AND BorrowerName like 'Krishna';

	
	System.out.println("SQL update"+Loan);
		   // ResultSet  rs = statement.executeQuery(Sql);
		    statement.executeUpdate(Sql);
			System.out.println("Completed Result set in update");
			
			//rs.close();
			connect.close();
	}
	
	
	} catch (SQLException e) {
	throw new ServletException(e);
}catch(Exception e) {
	throw new ServletException(e);
}
request.getRequestDispatcher( "/finals/Display.jsp" ).forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
