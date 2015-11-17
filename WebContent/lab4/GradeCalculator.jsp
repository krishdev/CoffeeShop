<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grade Scale Calculator</title>
</head>
<body>
<form action="GradeCalculator.jsp" method="post">





<div align="center">
<div>
Calculate Your GPA
</div>
<table>

<tr>
<td>
</td>
<td>
User Total
</td>
<td>
Total Points
</td>
</tr>

<tr>
<td>
Assignment
</td>
<td>
<input type="text" name="txt1">
</td>
<td>
<input type="text" name="totaltxt1">
</td>
</tr>
<tr>
<td>
Midterm
</td>
<td>
<input type="text" name="txt2">
</td>
<td>
<input type="text" name="totaltxt2">
</td>
</tr>
<tr>
<td>
Fianls
</td>
<td>
<input type="text" name="txt3">
</td>
<td>
<input type="text" name="totaltxt3">
</td>
</tr>
<tr>
<td>
Attendance
</td>
<td>
<input type="text" name="txt4">
</td>
<tr>
<td colspan="2">
<input type="submit" value="Submit">
</td>
</tr>
</table>

</div>

 




<%--Operation --%>
<%! int a=30; %>
<%! int mid=30; %>
<%! int finals=35; %>
<%! int att=5; %>
<%! int div=100; %>
<% 	String sassign=(String)request.getParameter("txt1"); 
	String smid=(String)request.getParameter("txt2");
	String sfinals=(String)request.getParameter("txt3");
	String tsassign=(String)request.getParameter("totaltxt1"); 
	String tsmid=(String)request.getParameter("totaltxt2");
	String tsfinals=(String)request.getParameter("totaltxt3");
	String satt=(String)request.getParameter("txt4");
	
if(sassign!=null && smid != null && sfinals != null && satt !=null && !sassign.isEmpty() && !smid.isEmpty() && !sfinals.isEmpty() & !satt.isEmpty() && tsassign!=null && tsmid != null && tsfinals != null && !tsassign.isEmpty() && !tsmid.isEmpty() && !tsfinals.isEmpty()){
 double getass= Double.parseDouble(sassign);
 double getmid=Double.parseDouble(smid);
 double getfinals= Double.parseDouble(sfinals);
 
 double tgetass= Double.parseDouble(tsassign);
 double tgetmid=Double.parseDouble(tsmid);
 double tgetfinals= Double.parseDouble(tsfinals);
 
 double getatt=Double.parseDouble(satt);
 
 double ans1=(getass/tgetass)*(100*0.3);
 
 double ans2=(getmid/tgetmid)*(100*0.3);
 
 double ans3=(getfinals/tgetfinals)*(100*0.35);

 double ans4=(getatt/100)*(div*0.05);
 
 double total=ans1+ans2+ans3+ans4;
 
 out.println("Total Marks For this Quater "+total+" and ");
 if(total>92){
	 out.println("Grade A");
 }
 else if(total>=91 && total<=92){
	 out.println("Grade A-");
 }
 else if(total>=88 && total<=90){
	 out.println("Grade B+");
 }
 else if(total>=84 && total<=87){
	 out.println("Grade B");
 }
 else if(total>=81 && total<=83){
	 out.println("Grade B-");
 }
 else if(total>=78 && total<=80){
	 out.println("Grade C+");
 }
 else if(total>=74 && total<=77){
	 out.println("Grade C");
 }
 else if(total>=71 && total<=73){
	 out.println("Grade C-");
 }
 else if(total>=68 && total<=70){
	 out.println("Grade D+");
 }
 else if(total>=64 && total<=67){
	 out.println("Grade D");
 }
 else if(total>=60 && total<=63){
	 out.println("Grade D-");
 }
 else if(total<60){
	 out.println("Grade f");
 }
}
else if((sassign==null || sassign.isEmpty()) && (smid==null || smid.isEmpty()) && (sfinals==null || sfinals.isEmpty()) && (satt==null || satt.isEmpty()) && (tsassign==null || tsassign.isEmpty()) && (tsmid==null || tsmid.isEmpty()) && (tsfinals==null || tsfinals.isEmpty()) ){
	out.println("<br>Please Enter all the fields");
}
else{
	out.println("All the fields are required");
}


 %>


</form>
</body>
</html>