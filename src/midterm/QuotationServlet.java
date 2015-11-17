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


@WebServlet("/midterm/QuotationServlet")
public class QuotationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public QuotationServlet() {
		super();
	}

	private int count;
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);

		@SuppressWarnings("unchecked")
		List<Quotes> entries = (List<Quotes>)getServletContext().getAttribute("entries");
		if(entries == null){
			List<Quotes> InitialEntry = new ArrayList<Quotes>();

			InitialEntry.add(new Quotes(1,"Joe", "Love makes life beautiful"));
			InitialEntry.add(new Quotes(2,"Albert John", "Work Hard Talk Less!"));
			
			InitialEntry.add(new Quotes(3,"Janu", "Programming is the best hobby"));
			
			InitialEntry.add(new Quotes(4,"Swami", "Caution! Programming is on process"));
			InitialEntry.add(new Quotes(5,"Tom", "Belive in yourself"));
			
			
			getServletContext().setAttribute("entries", InitialEntry);
		}
		count=0;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<Quotes> move = (List<Quotes>)request.getServletContext().getAttribute("entries");

		//ArrayList idthrow = new ArrayList();
		//ArrayList<StatisticsServlet> posts = new ArrayList<StatisticsServlet>();

		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html>");
		out.println("<head>");
		out.println("<div align='center'><h1><font color= 'aqua'><title>CS320 Midterm Quotation Generator</title></h1></b></div>");
		out.println("</head>");
		out.println("<form action=\"QuotationServlet\" method=\"POST\">");
		out.println("<div align='center'");
		out.println("<a href='/QuotationAdminServlet'>Admin Page");
		out.println("<h2><p style='background-color:azure'>CS320 Midterm Quotation Generator</h2>");
		out.println("<br /><br /><br />");


		if(move.size()>0){
			int index = (int) (Math.random() * move.size());
			Quotes quotes = move.get(index);
			
			
			out.println("<p><font color='red'><h3>" + quotes.getQuote() + "</h3></p>");
			out.println("<p><b><h2 style='color:violet'>by" + quotes.getAuthor() + "</h2></b></p>");
			out.println("Count"+count);
			
			count++;
			int passid=0;
			//passid=quotes.getQuoteId();
			//String passm=""+passid;
		//	List<Count> postit = new ArrayList<Count>();

		//	quotes.add(new (passid+1));
			//getServletContext().setAttribute("postit", postit);
		//	request.getRequestDispatcher("/midterm/StatisticsServlet").include(request, response);
			
			
			
			out.println ("<input type=\"submit\" value=\"Next\" name=\"submit\"/>");
			out.println("</div>");
			out.println("</form>");

			out.println("</body>");
			out.println("</html>");
		}
		else{
			out.println("SORRY !!! NO OTHER QUOTES ARE AVAILABLE");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
