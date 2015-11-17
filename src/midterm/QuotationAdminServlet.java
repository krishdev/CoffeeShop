package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/midterm/QuotationAdminServlet")
public class QuotationAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig  config) throws ServletException {
		super.init(config);
		List<Quotes> InputQuotes = new ArrayList<Quotes>();

		InputQuotes.add(new Quotes(1,"Dont delete it", "Default data please don't dlt it"));
		getServletContext().setAttribute("entries", InputQuotes);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String poss = (String)request.getParameter("op");
		
		if(poss != null && poss.toLowerCase().equals("remove")) {
			int id = Integer.parseInt(request.getParameter("id"));
		
			@SuppressWarnings("unchecked")
			List<Quotes> entries = (List<Quotes>)request.getServletContext().getAttribute("entries");
			
			if(id <= entries.size()) {
				
				entries.remove(id);
				
			}
			
		
			
		}
	
		
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

	
		for (Quotes q : insertt) {
			out.println("<tr>");
			out.println("<form action=\"QuotationAdminServlet\" method=\"POST\">");
		
			out.println("<td>" + q.getQuote() + "</td><br>");
			out.println("<td>" + q.getAuthor() + "</td><br>");
			out.println("<td><a href=\"" + getURLWithContextPath(request)+ "?id=" + q.getQuoteId() + "&op=remove\">Remove</a></td><br>");
			out.println("<input type=\"hidden\" name=\"id\" value=\"" + q.getQuoteId() + "\">");
			out.println("<input type=\"hidden\" name=\"op\" value=\"delete\">");
			
			out.println("</form>");
			out.println("</tr>");
			
		}

		out.println("</table>");
		out.println("</div>");
		out.println("<br/><br/><br />");
		
		String error = (String)request.getAttribute("isError");
		if (error != null) {
			out.println("<p style=\"color:crimson;\">" + error + "</p>");
		}
		
		out.println("<form action=\"QuotationAdminServlet\" method=\"POST\">");
		out.println("<div align='center'>");
		out.println("Add Quotes Here");
		//table
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Write a Quote");
		out.println("</td>");
		//--
		out.println("<td>");
		out.println("<input type='text'name='Quote' /><br>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		
		out.println("<td>");
		out.println("Writen by");
		out.println("</td>");
		//--
		out.println("<td>");
		out.println("<input type='text' name='Author'/><br>");
		out.println("</td>");
		out.println("</tr>");	
		out.println("<tr>");
		
		out.println("<td>");
		out.println("</td>");
		out.println("<td>");
		out.println("<p><input type=\"hidden\" name=\"op\" value=\"insert\">");
		out.println ("<p><b><input type=\"submit\" value=\"SUBMIT\" name=\"submit\"/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		
		
		
		out.println("</div>");
		
		out.println("</form>");

		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("op");


		if(operation.toLowerCase().equals("insert")) {
			String quote = request.getParameter("Quote");
			String author = request.getParameter("Author");

			@SuppressWarnings("unchecked")
			List<Quotes> insertt = (List<Quotes>)request.getServletContext().getAttribute("entries");
            int id= insertt.size();
            int id1=insertt.get(id-1).getQuoteId();

			if(quote!= null && author!=null && !quote.isEmpty() && !author.isEmpty()){
				insertt.add(new Quotes(id1++,author, quote));
			}
			else if((quote == null || quote.isEmpty()) && (author== null || author.isEmpty())) {request.setAttribute("isError", "ERROR: Quote & Author field are Empty!!!");
			}
			else if(quote == null || quote.isEmpty()){request.setAttribute("isError", "Oops: Quote Field can't be Empty");
			}
			else if(author== null || author.isEmpty()){request.setAttribute("isError", "Oops: Author Field can't be Empty");
			}
		}
		
		else if(operation.toLowerCase().equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));

			@SuppressWarnings("unchecked")
			List<Quotes> alQuotes = (List<Quotes>)request.getServletContext().getAttribute("alQuotes");
			alQuotes.remove(id);
		}

		doGet(request, response);
	}
	
	public static String getURLWithContextPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" +request.getServerPort() + request.getRequestURI();
	}

}
