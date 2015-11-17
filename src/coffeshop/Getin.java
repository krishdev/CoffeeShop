package coffeshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Getin")
public class Getin extends HttpServlet {
	private static final long serialVersionUID = 1L;

public void init() throws ServletException {
		
		// Get reference to the Servlet Context
		ServletContext context = this.getServletContext();
		
		// Create the list of Users
		if ( context.getAttribute("CoffeeUsers") == null ){
			
			ArrayList<CoffeeUser> coffeeUsers = new ArrayList<CoffeeUser>();
			
			// Pre-populate the list of Users with two known Users
			coffeeUsers.add( new CoffeeUser("John", "Doe",   "90071", "john@doe.com",  "abcd") );  // Los Angeles
			coffeeUsers.add( new CoffeeUser("Joe",  "Boxer", "92101", "joe@boxer.com", "1234") );  // San Diego
			
			context.setAttribute("CoffeeUsers", coffeeUsers);
		}
		
		// Create the list of Starbucks Stores
		if ( context.getAttribute("CoffeeShops") == null ){
			ArrayList<CoffeeShop> coffeeShops = new ArrayList<CoffeeShop>();
			String file = this.getServletContext().getRealPath("/") + "Starbucks-tab-delimited2.txt";
			try{
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				while ((line = br.readLine()) != null) {
				   String[] tokens = line.split("\t");
				   coffeeShops.add(new CoffeeShop(tokens[1].replace('"', ' ').trim(), tokens[3].trim(), tokens[4].trim(), "CA",
						   tokens[5].trim(), tokens[2].trim(), Double.parseDouble(tokens[6]), Double.parseDouble(tokens[7]) ) );
				   /*
				   Store ID	Name	Phone Number	Street Combined	City	Postal Code	Latitude	Longitude
				   1005886
					Heavenly Village, S Lake Tahoe, CA
					5305412596
					1001 Heavenly Village Way
					South Lake Tahoe
					96150
					38.95607758
					-119.9422684
					*/
				   
				   for (String token : tokens)
				    	System.out.println("\t" + token.replace('"', ' ').trim() );
				    System.out.println("-------------------");
				}
				br.close();
				
				context.setAttribute("CoffeeShops", coffeeShops);
			}catch(IOException e){
				e.printStackTrace();
			}			
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getParameter("action");
				if ( action != null && action.equals("logout") ){
					HttpSession session = request.getSession();
					session.invalidate(); // Invalidate the session
				}
				
				// Print the HTML
				response.setContentType("text/html");
				
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html><html lang=\"en\">");
				out.println("<head><title>Coffee Shop Locator - Login</title></head>");
				out.println("<body>");
				
				out.println("<p><strong>Context Path: </strong>" + this.getServletContext().getContextPath() + "</p>");
				out.println("<p><strong>Real Path: </strong>" + this.getServletContext().getRealPath("/") + "</p>");
				
				out.println("<form action=\"Login\" method=\"post\">");
				out.println("	<input type=\"text\" placeholder=\"Username\" name=\"username\" /><br />");
				out.println("	<input type=\"password\" placeholder=\"Password\" name=\"password\" /><br />");
				out.println("	<input type=\"submit\" value=\"Login\" />");
				
				out.println("</form>");
				
				out.println("</body>");
				out.println("</html>");
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ArrayList<CoffeeUser> coffeeUsers = (ArrayList<CoffeeUser>) this.getServletContext().getAttribute("CoffeeUsers1");
		
		for (CoffeeUser user1 : coffeeUsers){
			ServletContext context = this.getServletContext();
			context.setAttribute("CoffeeUsers1", user1);
		}
		// If the form was submitted then let's authenticate the User
		if (username != null && username.trim().length() > 0 && 
		    password != null && password.trim().length() > 0){
			
			// Get the list of Users from the Servlet Context
			
			for (CoffeeUser user : coffeeUsers){
				if ( user.isUser(username.trim(), password.trim() ) ){
					
					// Store the User in the Session
					HttpSession session = request.getSession();					
					session.setAttribute("currentCoffeeUser", user);
					
					// Redirect to List of nearby starbucks page
					response.sendRedirect("CoffeeShopSearch");
					
					// Break out of foreach loop
					break;
				}
			}
		
		}
		
		doGet(request, response);
	}

}
