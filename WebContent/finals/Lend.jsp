<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Lend" method="get">
<a href="Display">Go To Search Media</a>
<a href="Adminadd">Go To Add Media</a>

	<p><b>Borrower Name</b> <input type="text" name="name" size="65" />
<input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>

<input type="submit" value="ADD" /> 

</form>
</body>
</html>