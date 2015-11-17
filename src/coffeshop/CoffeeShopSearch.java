package coffeshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CoffeeShopSearch")
public class CoffeeShopSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		CoffeeUser user = (CoffeeUser) session.getAttribute("currentCoffeeUser");
		
		// If the User is not authenticated, redirect to Login Servlet
	if (user == null){
			response.sendRedirect("Getin");
		}
	else{
			
			ArrayList<CoffeeShop> coffeeShops = (ArrayList<CoffeeShop>) this.getServletContext().getAttribute("CoffeeShops");			
			
			// Print the HTML
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html><html lang=\"en\">");
			out.println("<head><title>Coffee Shop Locator</title></head>");
			out.println("<body>");
			
			out.println("<p style=\"text-align: right;\"><a href=\"Getin?action=logout\">Logout</a></p>");
			out.println("<h2 style=\"color: #fff; background-color: #000;\">Welcome, " + user.getFirstName() + "!</h2>");
			out.println("<p style=\"color: #fff; background-color: #000;\">Displaying coffee shops in your zipcode: " + user.getZipcode() + "</p>");
			
			
			// Print all coffee shops nearby
			for (CoffeeShop coffeeShop : coffeeShops){
				if (coffeeShop.getZip().equals( user.getZipcode() ) ){
					out.println("<div>");
					out.println("	<h4>" + coffeeShop.getName() + "</h4>");
					out.println("</div>");
					out.println("<hr />");
				}
				else
					System.out.println("coffee shop: '" + coffeeShop.getZip() + "' - user: '" + user.getZipcode() + "'" );
			}
			
			
			
			out.println("</body>");
			out.println("</html>");
		}
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

}
