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


@WebServlet("/Adminadd")
public class Adminadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("added1");
		String title= request.getParameter("title");
		String type = request.getParameter("type");
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
*/   if(type != null && !type.isEmpty()){
		try {
			System.out.println("added2");
			System.out.println("added3"+dateformate.format(date)+ title+type);
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection c = DriverManager.getConnection(url, username, password);
		     // Connection c = DriverManager.getConnection(DB_URL,USER,PASS);
		      Statement   stmt = c.createStatement();


			String sql1 = "INSERT INTO Media (TypeMedia, MediaName, CreatedDate, Loan) values (?, ?, ?, ?)";
			
			//INSERT INTO `Media`(`Id`, `TypeMedia`, `MediaName`, `CreatedDate`, `Loan`, `LoanTime`, `BorrowerName`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7])
			PreparedStatement pstmt = c.prepareStatement(sql1);
			
			pstmt.setString(1, type);
			pstmt.setString(2, title);
			pstmt.setString(3, dateformate.format(date));
			pstmt.setString(4, "No");

			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("added3"+dateformate.format(date));
			
	System.out.println("added");

			c.close();
		} catch (SQLException e) {
			throw new ServletException(e);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
}
	         request.getRequestDispatcher( "/finals/AddMedia.jsp" ).forward(request,response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
