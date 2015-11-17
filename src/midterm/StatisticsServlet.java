package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/midterm/StatisticsServlet")
public class StatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException{
		
	}


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		@SuppressWarnings("unchecked")
		List<Quotes> insertt = (List<Quotes>)request.getServletContext().getAttribute("entries");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>CS320 Midterm Quotation Generator</title>");
		out.println("</head>");
		out.println("<center><p style='background-color:azure'><font color='red'>CS320 Midterm Quotation Generator</center>");
		out.println("<br /><br /><br />");
		out.println("<div align='center'>");
		out.println("<table border='1' cellpadding='8'>");
		out.println("<tr>");
		out.println("<th>QUOTE</th>");
		out.println("<th>AUTHOR</th>");
		out.println("<th>OPTIONS</th>");
		out.println("</tr>");

	if(insertt != null){
		for (Quotes q : insertt) {
			out.println("<tr>");
			out.println("<form action=\"QuotationAdminServlet\" method=\"POST\">");
		
			out.println("<td>" + q.getQuote() + "</td><br>");
			out.println("<td>" + q.getAuthor() + "</td><br>");
			out.println("<td>" + q.getAuthor() + "</td><br>");
			
			out.println("</form>");
			out.println("</tr>");
			
		}}

		out.println("</table>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");
	}





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
