package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/IndexPage")
public class IndexPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		DataBaseUser user = (DataBaseUser) session.getAttribute("currentCoffeeUser");
		
		ArrayList<DBShopCoffee> coffeeShops1 = (ArrayList<DBShopCoffee>) this.getServletContext().getAttribute("CoffeeShops");	
		
		//Textbox values
		/*String zcode=request.getParameter("userzip");
		String zcity=request.getParameter("usercity");
		*/
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<!DOCTYPE html><html lang=\"en\">");
		writer.println("<head><title>User Registration Page</title></head>");
		writer.println("<body>");
		writer.println("<form action=\"IndexPage\" method=\"post\">");
		writer.println("<p style=\"text-align: right;\"><a href=\"GoIn?action=logout\">Logout</a></p>");
		
		
		writer.println("<hr />");
		
		
		writer.println("<div align=\"center\">");
		writer.println("<h2 style=\"color: blue;\">Hello User</h2>");
		writer.println("<table style=\"align: center\">");
		//row1
		writer.println("<tr align=\"center\">");
		//col1
		writer.println("<td>");
		writer.println("Welcome "+user.getUsfname());
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>");
	//	writer.println("<p style=\"color: #fff; background-color: #000;\">Displaying coffee shops in your zipcode: " + user.getUszip() + "</p>");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("</table>");
		writer.println("<div style=\"height:10px\">");
		writer.println("</div>");
		writer.println("<div>");
		writer.println("<h4>Search for Coffee Shops by entering any of the fields bellow</h4>");
		writer.println("<table style=\"align: center\">");
		//row1
		writer.println("<tr align=\"center\">");
		//col1
		writer.println("<td>");
		
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr align=\"center\">");
		//col1
		writer.println("<td>");
		writer.println("Enter the Zip Code");
		writer.println("</td>");
		writer.println("<td>");
		writer.println("<input type=\"text\" name=\"userzip\">");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr align=\"center\">");
		//col1
		writer.println("<td>");
		writer.println("Enter the City");
		writer.println("</td>");
		writer.println("<td>");
		writer.println("<input type=\"text\" name=\"usercity\">");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr align=\"center\">");
		//col1
		writer.println("<td>");
		writer.println("Shops with in");
		writer.println("</td>");
		writer.println("<td>");
		writer.println("<input type=\"text\" name=\"userdist\"> miles");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("<tr align=\"center\">");
		//col1
		writer.println("<td>");
		writer.println("<input type=\"submit\" value=\"Search\"");
		writer.println("</td>");
		writer.println("</tr>");
		writer.println("</table>");
		
		
		
		
		
		writer.println("</div>");
		writer.println("</div>");
		
		writer.println("</form>");
		
		writer.println("</body>");
		writer.println("</html>");	
		
		writer.println("<div align=\"center\"  style=\"color:blue;font-size: 20;\"> Coffee Shop's According to Users ZipCode.</div>");

		for (DBShopCoffee coffeeShop1 : coffeeShops1)
	    {
			if(coffeeShop1.getZip().equals( user.getUszip())){
				
				//calculating latitude and longitude
				double latt1=user.getLatt();
				double latt2=coffeeShop1.getLat();
				double long1=user.getLongi();
				double long2=coffeeShop1.getLon();
				double theta = long1-long2;
				
				  double dist = Math.sin(deg2rad(latt1)) * Math.sin(deg2rad(latt2)) + Math.cos(deg2rad(latt1)) * Math.cos(deg2rad(latt2)) * Math.cos(deg2rad(theta));
				  dist = Math.acos(dist);
				  dist = rad2deg(dist);
				  dist = dist * 60 * 1.1515;
				  double round=Math.floor(dist * 100) / 100;
				//end cal lat and longitude
				
				
				
				writer.println("<div align=\"center\">");
				writer.println("<p> Name: " + coffeeShop1.getName() + "</br> Address: "+coffeeShop1.getAddress()+ "</br> Phone Number: "+coffeeShop1.getPhone()+"</p>" );
				writer.println("<p>Distance: "+round+" miles</p>");
				writer.println("</div>");
				writer.println("<hr />");
			}
			else
				writer.println("");
			/* int far=2;
			double latt1=user.getLatt();
			double latt2=coffeeShop1.getLat();
			double long1=user.getLongi();
			double long2=user.getLongi();
			double theta = long1-long2;
			
			  double dist = Math.sin(deg2rad(latt1)) * Math.sin(deg2rad(latt2)) + Math.cos(deg2rad(latt1)) * Math.cos(deg2rad(latt2)) * Math.cos(deg2rad(theta));
			  dist = Math.acos(dist);
			  dist = rad2deg(dist);
			  dist = dist * 60 * 1.1515;
			  double round=Math.floor(dist * 100) / 100;
			  if(round<=far){
				  writer.println("<p>Coffee shops within 2 miles</p>");
				  writer.println("<p style=\"color:red\">"+coffeeShop1.getName()+"</p>");
			  }
			  else
				  writer.println(""); */
	    }
	}



	private double deg2rad(double deg){
		return (deg*Math.PI/180.0);
	}

	private double rad2deg(double rad) {
		
		return (rad * 180.0 / Math.PI);
		
		}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		DataBaseUser user = (DataBaseUser) session.getAttribute("currentCoffeeUser");
		
		ArrayList<DBShopCoffee> coffeeShops = (ArrayList<DBShopCoffee>) this.getServletContext().getAttribute("CoffeeShops");	
		String zcode=request.getParameter("userzip");
		String zcity=request.getParameter("usercity");
		String zdist=request.getParameter("userdist");
		boolean numbb=false;
		int udist = 0;
		if(!zdist.isEmpty()){
		try{
			//if(!zdist.isEmpty())
		 udist=Integer.parseInt(zdist);
		 
		 numbb=true;
		}
		catch(NumberFormatException e){
			numbb=false;
		}}
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
	//	writer.println("<div align=\"center\"  style=\"color:blue;font-size: 25;\"> Coffee Shop's According to Users ZipCode.</div>");
		
		
		
		writer.println("<div align=\"left\" style=\"color:blue;font-size: 20;\"> Coffee Shop's According to your search.</div>");
		for (DBShopCoffee coffeeShop : coffeeShops)
	    {
			
			
		if(!zcode.isEmpty() || !zcity.isEmpty()){
			if(!zcode.isEmpty() && !zcity.isEmpty() && numbb==true){
				if (coffeeShop.getZip().equals( zcode ) && coffeeShop.getCity().contains( zcity )){
					//calculating latitude and longitude
					double latt1=user.getLatt();
					double latt2=coffeeShop.getLat();
					double long1=user.getLongi();
					double long2=coffeeShop.getLon();
					double theta = long1-long2;
					
					  double dist = Math.sin(deg2rad(latt1)) * Math.sin(deg2rad(latt2)) + Math.cos(deg2rad(latt1)) * Math.cos(deg2rad(latt2)) * Math.cos(deg2rad(theta));
					  dist = Math.acos(dist);
					  dist = rad2deg(dist);
					  dist = dist * 60 * 1.1515;
					  double round=Math.floor(dist * 100) / 100;
					  if(round<=udist){
						  writer.println("<div>");
							writer.println("<p> Name: " + coffeeShop.getName() + "</br> Address: "+coffeeShop.getAddress()+ "</br> Phone Number: "+coffeeShop.getPhone()+"</p>");
							writer.println("<p>Distance: "+round+" miles</p>");
							writer.println("</div>");
							writer.println("<hr />");
					  }
					  else
						  writer.println("");
					//end cal lat and longitude
					  
						}
				else
				writer.println("");
			}
			else if (coffeeShop.getZip().equals( zcode ) || coffeeShop.getCity().equals( zcity ) || numbb==true ){
				//calculating latitude and longitude
				double latt1=user.getLatt();
				double latt2=coffeeShop.getLat();
				double long1=user.getLongi();
				double long2=user.getLongi();
				double theta = long1-long2;
				
				  double dist = Math.sin(deg2rad(latt1)) * Math.sin(deg2rad(latt2)) + Math.cos(deg2rad(latt1)) * Math.cos(deg2rad(latt2)) * Math.cos(deg2rad(theta));
				  dist = Math.acos(dist);
				  dist = rad2deg(dist);
				  dist = dist * 60 * 1.1515;
				  double round=Math.floor(dist * 100) / 100;
				//end cal lat and longitude
				  if(coffeeShop.getZip().equals( zcode ) && zcity.isEmpty() && numbb==false){
					  writer.println("<div>");
						writer.println("<p> Name1: " + coffeeShop.getName() + "</br> Address: "+coffeeShop.getAddress()+ "</br> Phone Number: "+coffeeShop.getPhone()+"</p>");
						writer.println("<p>Distance: "+round+" miles</p>");
						writer.println("</div>");
						writer.println("<hr />");
				  }
				  else if(zcode.isEmpty() && coffeeShop.getCity().equals( zcity ) && numbb==false){
					  writer.println("<div>");
						writer.println("<p> Name2: " + coffeeShop.getName() + "</br> Address: "+coffeeShop.getAddress()+ "</br> Phone Number: "+coffeeShop.getPhone()+"</p>");
						writer.println("<p>Distance: "+round+" miles</p>");
						writer.println("</div>");
						writer.println("<hr />");
				  }
				  else if(coffeeShop.getZip().equals( zcode ) && coffeeShop.getCity().contains( zcity )){
				writer.println("<div>");
				writer.println("	<p> Name3: " + coffeeShop.getName() + "</br> Address: "+coffeeShop.getAddress()+ "</br> Phone Number: "+coffeeShop.getPhone()+"</p>");
				writer.println("<p>Distance: "+round+" miles</p>");
				writer.println("</div>");
				writer.println("<hr />");	}


				  
				  else if(coffeeShop.getZip().equals( zcode ) && numbb==true){
					  if(round<=udist){
						  writer.println("<div>");
							writer.println("<p> Name4: " + coffeeShop.getName() + "</br> Address: "+coffeeShop.getAddress()+ "</br> Phone Number: "+coffeeShop.getPhone()+"</p>");
							writer.println("<p>Distance: "+round+" miles</p>");
							writer.println("</div>");
							writer.println("<hr />");
					  }	}
				  else if(coffeeShop.getCity().contains( zcity ) && numbb==true){
					  if(round<=udist){
						  writer.println("<div>");
							writer.println("<p> Name5: " + coffeeShop.getName() + "</br> Address: "+coffeeShop.getAddress()+ "</br> Phone Number: "+coffeeShop.getPhone()+"</p>");
							writer.println("<p>Distance: "+round+" miles</p>");
							writer.println("</div>");
							writer.println("<hr />");
					  }	}
				  
				  }
			
			
		/*	else if(coffeeShop.getCity().contains(zcity)){
				writer.println("<div>");
				writer.println("	<p> Name: " + coffeeShop.getName() + "</br> Address: "+coffeeShop.getAddress()+ "</br> Phone Number: "+coffeeShop.getPhone()+"</p>");
				writer.println("</div>");
				writer.println("<hr />");
			}*/
			else if(numbb==false){
				writer.println("");
				//break;
			}
			else
			writer.println("");
		}
		else if(zcode.isEmpty() && zcity.isEmpty()){
			writer.println("<p> Please Enter Some Values</p>");
		break;	
		
		}		
		
		}
		
		writer.println("<hr />");
		writer.println("<h4>Other Coffee Shops near by</h4>");
		writer.println("<p>Coffee shops within "+udist+" miles</p>");
		for (DBShopCoffee coffeeShop1 : coffeeShops)
	    {
			
			if(!zdist.isEmpty()){
				double latt1=34.0964873;
				double latt2=coffeeShop1.getLat();
				double long1=-118.12043489999999;
				double long2=coffeeShop1.getLon();
				double theta = long1-long2;
				
				  double dist = Math.sin(deg2rad(latt1)) * Math.sin(deg2rad(latt2)) + Math.cos(deg2rad(latt1)) * Math.cos(deg2rad(latt2)) * Math.cos(deg2rad(theta));
				  dist = Math.acos(dist);
				  dist = rad2deg(dist);
				  dist = dist * 60 * 1.1515;
				  double round=Math.floor(dist * 100) / 100;
				  if(round<=udist){
					 // writer.println("<p>Coffee shops within "+udist+" miles</p>");
					  writer.println("<p style=\"color:red\">"+coffeeShop1.getName()+" Distance:"+round+" miles</p>");
				  }
				  else
					  writer.println("");
			}
	    }
		
	//}
		doGet(request,response);
	}
}
