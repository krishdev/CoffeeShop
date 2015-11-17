package finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lend
 */
@WebServlet("/Lend")
public class Lend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("added1");
		String name= request.getParameter("name");
		String id = request.getParameter("id");
		DateFormat dateformate= new SimpleDateFormat("yyyy/mm/dd HH:MM:SS");
		Date date=new Date();
	

		String username = "cs320stu08";
		String password = "n0l9w.wf"; 
		String host 	= "cs3.calstatela.edu";
		String port 	= "3306";
		String dbName 	= "cs320stu08";

		String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		
		/*	String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	     String DB_URL="jdbc:mysql://localhost/cs320";
	      //  Database credentials
	     String USER = "root";
	     String PASS = "abcd";
*/
		try {
			System.out.println("try");
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection c = DriverManager.getConnection(url, username, password);
		     // Connection c = DriverManager.getConnection(DB_URL,USER,PASS);
		      Statement   stmt = c.createStatement();
System.out.println("Connection");

			String sql1 = "UPDATE Media SET BorrowerName = '"+name+"',Loan = 'Yes',LoanTime = '"+dateformate.format(date)+"' WHERE id ='"+id+"'";
		      stmt.executeUpdate(sql1);
			
		
			System.out.println("successfully"+dateformate.format(date));
			
	System.out.println("added");

			c.close();
		} catch (SQLException e) {
			throw new ServletException(e);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	         request.getRequestDispatcher( "/finals/Lend.jsp" ).forward(request,response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
