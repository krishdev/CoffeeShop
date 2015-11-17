<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Adminadd" method="get">	
<a href="Display">Go To Search Media</a>
	<p><b>Meida Title</b> <input type="text" name="title" size="65" />
	<p><b>Media Type: </b><select name="type">
  <option>CD</option>
  <option>DVD</option>
    <option>Blu-Ray</option>
  
  </select>
	<p>
	<br>
<center><input type="submit" value="ADD" /> </center>
</form>

</body>
</html>