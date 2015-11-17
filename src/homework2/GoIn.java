package homework2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/GoIn")
public class GoIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {

		ServletContext context = this.getServletContext();
		
		 if( context.getAttribute("register") == null ){
				ArrayList<DataBaseUser> register = new ArrayList<DataBaseUser>();
				//ArrayList<DataBaseUser> register = (ArrayList<DataBaseUser>) getServletContext().getAttribute("register");
		 DataBaseUser s=new DataBaseUser("Joe","Boxer","1234","joe@boxer.com",  "Apt94 401", "EBay State St", "Alhambra","92101","CA","626","623","7336",32.7253,-117.1721);
			//@SuppressWarnings("unchecked")
		 DataBaseUser s1=new DataBaseUser("Doe","John","abcd","john@doe.com",  "Apt94 401", "EBay State St", "Alhambra","90071","CA","626","623","7336",34.0525,-118.2544);

			register.add(s);
			register.add(s1);
			getServletContext().setAttribute("register", register);
				
			}
		 
		 
		 
		// Create the list of Starbucks Stores
			if ( context.getAttribute("CoffeeShops") == null ){
				ArrayList<DBShopCoffee> coffeeShops = new ArrayList<DBShopCoffee>();
				String file = this.getServletContext().getRealPath("/") + "Starbucks-tab-delimited2.txt";
				try{
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line;
					
					while ((line = br.readLine()) != null) {
					   String[] tokens = line.split("\t");
					   coffeeShops.add(new DBShopCoffee( tokens[1].replace('"', ' ').trim(), tokens[3].trim(), tokens[4].trim(), "CA",
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

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ( action != null && action.equals("logout") ){
			HttpSession session = request.getSession();
			session.invalidate(); // Invalidate the session
		}

		ArrayList<DataBaseUser> l=(ArrayList<DataBaseUser>) getServletContext().getAttribute("register");
		for(DataBaseUser s:l)
		{
			System.out.println(s.getUsemail());
			System.out.println(s.getUspass());
		}
		
		
		
		
		
		
		PrintWriter writer =  response.getWriter();
		response.setContentType("text/html");
		
		writer.println("<!DOCTYPE html><html lang=\"en\">");
		writer.println("<head><title>Login Page</title></head>");
		writer.println("<body>");
		writer.println("<form action=\"GoIn\" method=\"post\">");
		writer.println("<div align=\"center\">");
		writer.println("<h4 style=\"color:blue\">Log In</h4>");
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("User Email id");
		writer.println("</td>");
		writer.println("<td>");
		//writer.println("<input type=\"text\" name=\"username\"/>");
		String cookieName = "myCookie";
		Cookie[] cookies1 = request.getCookies();
		String see="";
		writer.println("<input type=\"text\" name=\"username\"");
		if(cookies1 != null)
		{
		for(int i=0; i<cookies1.length; i++){
			Cookie cookie = cookies1[i];
			  //  cookieMap.put(cookie.getName(), cookie);
			// We should do some checking
			if (cookieName.equals(cookie.getName())) {
				 see=cookie.getValue();
				 
			
		}}	} 
		
		writer.println("value="+see+">");

	
		
		
		
		writer.println("</td>");
		writer.println("</tr>");
		//--2nd row
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("User Password");
		writer.println("</td>");
		writer.println("<td>");
		writer.println("<input type=\"password\" name=\"password\"/>");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("<a href=\"UserReg\">Sign Up</a>");
		writer.println("<td>");
		writer.println("<input type=\"submit\" value=\"Login\"/>");
		writer.println("</td");
		writer.println("</tr>");
		writer.println("</table>");
		writer.println("<input type='checkbox' name='chk' value='chk'>Remember");

		writer.println("</div>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
		
		
	}

	
	@SuppressWarnings({ "unused", "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<DataBaseUser> l=(ArrayList<DataBaseUser>) getServletContext().getAttribute("register");
		PrintWriter writer =  response.getWriter();
		
		
String un=request.getParameter("username");
		
		
		String pass=request.getParameter("password");
		String chk=request.getParameter("chk"); 
		response.setContentType("text/html");
		
Cookie[] cookies = request.getCookies();		
	
		
		
		if(chk != null)
		{
			Cookie cookie = new Cookie("myCookie", un);
			cookie.setMaxAge(1 * 60 * 60);
			response.addCookie(cookie);
			
				
			
		
		}
		else
		{
			Cookie c = new Cookie("myCookie", "");
			   c.setMaxAge(5);
			   response.addCookie(c);
		}
	
		for(DataBaseUser s:l)
		{
			System.out.println(s.getUsemail());
		}
		
		
		for(DataBaseUser f:l)
		{
			if(f.getUsemail().equals(un) && f.getUspass().equals(pass))
			{
				HttpSession session = request.getSession();					
				session.setAttribute("currentCoffeeUser", f);
				
				response.sendRedirect("IndexPage");
				break;
			}
			else
			{
				writer.println("<h4 style=\"color:blue\">Sorry try again</h4>");
			}
			
		} 
		doGet(request, response);
	}

}
