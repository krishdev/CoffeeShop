package lab3;

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


@WebServlet("/lab3/Signin")
public class In extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		
		 if( context.getAttribute("regist") == null ){
				ArrayList<mystore> register = new ArrayList<mystore>();
				//ArrayList<mystore> register = (ArrayList<mystore>) getServletContext().getAttribute("register");
		 mystore s=new mystore("Doe","John","aa1!","joe@boxer.com",  "Apt94 401", "EBay State St", "Alhambra","CA","91801","626","623","7336");
			//@SuppressWarnings("unchecked")
		
			register.add(s);
			getServletContext().setAttribute("regist", register);
			}
	}

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<mystore> l=(ArrayList<mystore>) getServletContext().getAttribute("regist");
		for(mystore s:l)
		{
			System.out.println(s.getUsemail());
			System.out.println(s.getUspass());
		}
		
		
		//passing cookie
		
		//cookies1=(Cookie[]) getServletContext().getAttribute("myCookie1");
	//	String chk="";
	
		
		//--End of passing cookie
		
		
		
		PrintWriter writer =  response.getWriter();
		response.setContentType("text/html");
		
		writer.println("<!DOCTYPE html><html lang=\"en\">");
		writer.println("<head><title>Login Page</title></head>");
		writer.println("<body>");
		writer.println("<form action=\"Signin\" method=\"post\">");
		writer.println("<div align=\"center\">");
		writer.println("<h4 style=\"color:blue\">Log In</h4>");
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<td>");
		writer.println("User Email id");
		writer.println("</td>");
		writer.println("<td>");
	//	writer.println("<input type=\"text\" name=\"username\"/>");
		
			//----
		//if(cookies1 != null)
		//{
			/*@SuppressWarnings("rawtypes")
			Map cookieMap = new HashMap();
			
*/
	//	ArrayList<Loginuser> sec=(ArrayList<Loginuser>) getServletContext().getAttribute("myCookie");
		String cookieName = "myCookie1";
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
		
		//}
		
		
	
		
	
		
		//End of displaying cookie
		
		
		
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
		writer.println("<a href=\"/Lab2CS320/lab3/Reguser\">Sign Up</a>");
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

	
	@SuppressWarnings({ "unchecked", "unused" })

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<mystore> l=(ArrayList<mystore>) getServletContext().getAttribute("regist");
		PrintWriter writer =  response.getWriter();
		
		
String un=request.getParameter("username");
		
		
		String pass=request.getParameter("password");
		String chk=request.getParameter("chk"); 
		response.setContentType("text/html");
	
		// cookie
		
		Cookie[] cookies = request.getCookies();		
	
		
		
		if(chk != null)
		{
			Cookie cookie = new Cookie("myCookie1", un);
			cookie.setMaxAge(1 * 60 * 60);
			response.addCookie(cookie);
			
				
			
		
		}
		else
		{
			Cookie c = new Cookie("myCookie1", "");
			   c.setMaxAge(5);
			   response.addCookie(c);
		}
			//End Cookie
		
		for(mystore s:l)
		{
			System.out.println(s.getUsemail());
		}
		
		
		for(mystore f:l)
		{
			if(f.getUsemail().equals(un) && f.getUspass().equals(pass))
			{
				response.sendRedirect("Indexx?email="+f.getUsfname());
				
			}
			else
			{
				writer.println("<h4 style=\"color:blue\">Sorry try again</h4>");
			}
			
		} 
	}

}
