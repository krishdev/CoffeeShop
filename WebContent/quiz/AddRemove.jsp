	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Remove Questions</title>
</head>
<body>

<div id="header" style="background-color:GreenYellow; color: Red; text-align:center;">

<h1>Instructions</h1>
	<p>Click the "Delete" button to Remove a Question.</p>
		<h1>Add/Remove Questions</h1>
</div>


		<c:forEach items="${entries}" var="entry">
	${ entry.question}
	${ entry.answer}
	<form action="Admin" method="post">	
	<input type="hidden" name="qId" value="${entry.id}">
	<input type="submit" value="Delete" />
	</form>
	<br>
	<br>
	</c:forEach>

	
<div id="header" style="background-color:GreenYellow; color: Red; text-align:center;">
<h1>Add New Question</h1>
<p>Type in a Question and Select its correct Answer and Click the "ADD" button to Add the desired Question.</p>
</div>
	
<form action="Add" method="get">	
	<p><b>Question:</b> <input type="text" name="question" size="65" />
	<p><b>Answer: </b><select>
  <option>True</option>
  <option>False</option>
  </select>
	<p>
	<br>
<center><input type="submit" value="ADD" /> </center>
</form>


</body>
</html>