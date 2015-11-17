package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserReg")
public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		DataBaseUser r=(DataBaseUser) getServletContext().getAttribute("reg");
		
		out.println("<html><head><title>User Registration Form</title></head><body>");
		out.println(" <form method='post' action='UserReg'>");
		out.println("<div align='center'> <h4 style='color:blue'>Register Here</h4>");
		out.println("<table align='center'>");
		out.println("<tr> <td> User Email </td> ");
		out.println("<td><input type='text' name='uemail'");
		if(r==null || r.getUsemail()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+r.getUsemail()+"></td></tr>");
			
		}
		
		out.println("<tr><td>Re-type E-mail:</td><td><input type='text' name='uemailcon'");
		if(r==null || r.getUsemail()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+r.getUsemail()+"></td></tr>");
			
		}
		
		out.println("<tr><td>Password:</td><td><input type='password' name='upass'");
		if(r==null || r.getUspass()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+r.getUspass()+"></td></tr>");
			
		}
		
		out.println("<tr><td>Confirm Password:</td><td><input type='password' name='uconpass'");
		if(r==null || r.getUspass()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+r.getUspass()+"></td></tr>");
			
		}

		out.println("<tr><td>First Name:</td><td><input type='text' name='ufname' minlength='1'");
		if(r==null || r.getUsfname()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+r.getUsfname()+"></td></tr>");
			
		}
		out.println("<tr><td>Last Name:</td><td><input type='text' name='ulname' minlength='1'");
		if(r==null || r.getUslname()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+r.getUslname()+"></td></tr>");
			
		}

		out.println("<tr><td>Address:</td></tr>");
		out.println("<tr><td>Street1</td><td><input type='text' name='uaddSt1'");
		if(r==null || r.getUsaddst1()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+r.getUsaddst1()+"></td></tr>");
			
		}

		out.println("<tr><td>City</td><td><input type='text' name='uaddCity'");
		if(r==null || r.getcity()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+r.getcity()+"></td></tr>");
			
		}

		out.println("<tr><td>State</td><td><input type='text' name='uaddState' minlength='2'");
		if(r==null || r.getUsstate()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+r.getUsstate()+"></td></tr>");
			
		}

		out.println("<tr><td>Zip</td><td><input type='text' name='uaddZip' minlength='5' maxlength='5'");
		if(r==null || r.getUszip()==null)
		{
			out.println("></td></tr>");
		}
		else
		{
			out.println("value="+r.getUszip()+"></td></tr>");
			
		}

		out.println("<tr><td>Telephone</td><td width=30px>");
		out.println("<input type='text' name='areaCode' maxlength='3' style='width:40px;''");
		if(r==null || r.getUsareacode()==null)
		{
			out.println(">");
		}
		else
		{
			out.println("value="+r.getUsareacode()+"></td>");
			
		}
		out.println("<input type='text' name='prefix' maxlength='3' style='width:40px;'");
		if(r==null || r.getUsprefix()==null)
		{
			out.println(">");
		}
		else
		{
			out.println("value="+r.getUsprefix()+">");
			
		}
		
		out.println("<input type='text' name='suffix' maxlength='4' style='width:40px;'");
		if(r==null || r.getUssuffix()==null)
		{
			out.println("/></td></tr>");
		}
		else
		{
			out.println("value="+r.getUssuffix()+"></td></tr>");
			
		}
		
		out.println("<tr align='center'><td colspan='2' align='center'><input type='submit' value='Register'></td></tr>");
		out.println("</table></form>");
	//	out.println("<p><a href='Login'");
		out.println("</body></html>");
	}

	
	@SuppressWarnings({ "unchecked", "unused" })

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<DataBaseUser> register = (ArrayList<DataBaseUser>) getServletContext().getAttribute("reg");
		ArrayList<DataBaseUser> st=new ArrayList<DataBaseUser>();
      //  DataBaseUser r=new DataBaseUser( "em", "pass", "ufn", "uln", "addst1", "addst2", "addcity", "addstate", "addzip", "pharea", "phprefix", "phsuffix"); 
		  DataBaseUser r=new DataBaseUser(); 
		PrintWriter out = response.getWriter();
        
      ArrayList<String> error= new ArrayList<String>();
        
        response.setContentType("text/html");

        String em = request.getParameter("uemail");
        String emcon = request.getParameter("uemailcon");
        String pass = request.getParameter("upass");
        String conpass = request.getParameter("uconpass");
        String ufn = request.getParameter("ufname");
        String uln = request.getParameter("ulname");
        String addst1 = request.getParameter("uaddSt1");
        String addst2 = request.getParameter("uaddSt2");
        String addcity = request.getParameter("uaddCity");
        String addstate = request.getParameter("uaddState");
        String addzip = request.getParameter("uaddZip");
        String pharea = request.getParameter("areaCode");
        String phprefix = request.getParameter("prefix");
        String phsuffix = request.getParameter("suffix");
		double latt=34.092606;
		double longi=-118.137703;
		
    	boolean flag=true;
		

        
        if(!em.equals(emcon) || !em.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
        {
        	
        	out.println("E-mail and Re-Type Email is not same</br>");
        	flag=false;
       // 	r.setUsaddst1(null);
        }
       // if(em.equals(arg0))
        if(!pass.equals(conpass)){
        	
        	out.println("Password and Re-Type Password is not same\n</br>");
        	flag=false;
        }	
        if(ufn.length()<1){
        	out.println("First Name should be minimum 1\n</br>");
        	flag=false;
        	r.setUsfname(ufn);
        }
        else r.setUsfname(ufn);
        
        if(uln.length()<1){
        	out.println("<font color='red'>Last Name should be minimum 1</font> </br>");
        	flag=false;
        }else  r.setUslname(uln);
        
        if(addstate.length()<2){
        	out.println("Address State should be minimum 2 </br>");
        	flag=false;
        } else r.setUsstate(addstate);
        
        if(addzip.length()>5 && addzip.length()<5){
        	out.println("Address Zip should be exactly 5 </br>");
        	flag=false;
        } else r.setUszip(addzip);
       
        if(pass.length()<4){
        	out.println("Password Length should be minimum 4 </br>");
        	flag=false;
        }else r.setUspass(pass);

        if(em.isEmpty()){
        	out.println("User Email is empty</br>");
        	flag=false;
        }
        
        if(!em.isEmpty() && !em.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
        {
        	out.println("User Email is not Formatted Correctly</br>");
        	flag=false;
        }else r.setUsemail(em);
        if(emcon.isEmpty()){
        	out.println("User Retype Email is empty</br>");
        	flag=false;
        }
        if(pass.isEmpty()){
        	out.println("User Password is empty</br>");
        	flag=false;
        }
    /*    if(!pass.isEmpty() && !pass.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{4,20})")){
        	
        	out.println("User Password is not Properly Formatted</br>");
        	flag=false;
        	
        }else r.setUspass(pass);*/
        if(conpass.isEmpty()){
        	out.println("User Retype Password is empty</br>");
        	flag=false;
        }
        if(ufn.isEmpty()){
        	out.println("User First Name is empty</br>");
        }
        if(uln.isEmpty()){
        	out.println("User Last Name is empty</br>");
        	flag=false;
        }
        if(addst1.isEmpty()){
        	out.println("Street 1 is empty</br>");
        	flag=false;
        }else r.setUsaddst1(addst1);
        if(addcity.isEmpty()){
        	out.println("City is empty</br>");
        	flag=false;
        }else r.setUscity(addcity);
        
        if(addstate.isEmpty()){
        	out.println(" State is empty</br>");
        	flag=false;
        }else r.setUsstate(addstate);
        if(addzip.isEmpty()){
        	out.println("Zip is empty</br>");
        	flag=false;
        }else r.setUszip(addzip);
        if(pharea.isEmpty()){
        	out.println("Phone Area Code is empty</br>");
        	flag=false;
        }else r.setUsareacode(pharea);
        if(phprefix.isEmpty()){
        	out.println("Phone Prefix is empty</br>");
        	flag=false;
        }else r.setUsprefix(phprefix);
        
        if(phsuffix.isEmpty()){
        	out.println("Phone Suffix is empty</br>");
        	flag=false;
        }else r.setUssuffix(phsuffix);
        
        if(flag==true)
        {
        	if(register==null)
        	{
        		System.out.println("Entered Null");
        //	ArrayList<DataBaseUser> a=new ArrayList<DataBaseUser>();
        	DataBaseUser regis = new DataBaseUser(ufn, uln, pass,em, addst1, addst2, addcity, addzip,addstate, pharea, phprefix, phsuffix, latt, longi);
            st.add(regis);
            getServletContext().setAttribute("register", st);
            response.sendRedirect("GoIn");
        
        	}
        	else
        	{
        		System.out.println("Not null");
        		DataBaseUser regis = new DataBaseUser(ufn, uln, pass,em, addst1, addst2, addcity, addzip,addstate, pharea, phprefix, phsuffix,  latt, longi);
        register.add(regis);
        getServletContext().setAttribute("register", register);
		//ArrayList<DataBaseUser> r1 = (ArrayList<DataBaseUser>) getServletContext().getAttribute("reg");
		   
	     out.println("You are successfully Registered now Login");
	    // out.println("<a href='/cs320stu08/lab3/Signin'>Login Here</a>");
        response.sendRedirect("GoIn");
        	}
	}
        //reg.add(r);
        getServletContext().setAttribute("reg", r);
               doGet(request, response);
}

}
