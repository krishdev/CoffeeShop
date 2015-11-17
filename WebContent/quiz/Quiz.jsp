<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TRIVIA CHALLENGE</title>
</head>
<body>

<div id="header" style="background-color:GreenYellow; color: Red; text-align:center;">
<h1 style="margin-bottom:0;"><i> TRIVIA GAME CHALLENGE </i></h1></div>



<div id="menu" style="background-color:Linen;height:600px;width:305px;float:right;">

	<h2>Instructions</h2>
	<p>Five trivia questions will be selected at random from a database
		of questions. You must answer each question before moving on to the
		next. Upon completion, your score and ranking will be displayed.</p>
	<p>Good Luck!!</p>


<h3>Progress: ${count*20} % </h3>
	<p></p>
	
</div>


<c:if test="${count1!=5}">

<center>	<h1>Question:</h1> </center>

	<form name="input" action="Quiz" method="post">

		${questionName} 
		<br></br> 
		<input type="radio" name="answer"value="True" />
		True
		<br /> 
		<input type="radio" name="answer"value="False" />
		False<br/> 
		<br></br> 
		<input type="hidden" name="qId" value="${qId}">
		<input type="hidden" name="point" value="${point}">
		<c:out value="${point}"></c:out>
		<input type="submit" value="SUBMIT">
	

	</form>
	</c:if>
	
	
<c:if test="${count1==5}">	
	<c:if test="${total==0}">
	You Have Scored ${total}/5. >> Terrible.
	<a href="Quiz">Play Again</a>
	<h3>Progress: 100</h3>
	</c:if>
	
	<c:if test="${total==1}">
	You Have Scored ${total}/5. >> POOR.
	<br><a href="Quiz">Play Again</a>
	<h3>Progress: 100</h3>
	</c:if>
	
	<c:if test="${total==2}">
	You Have Scored ${total}/5. >> BELOW AVERAGE.
	<br><a href="Quiz">Play Again</a>
	<h3>Progress: 100</h3>
	</c:if>
	
	<c:if test="${total==3}">
	You Have Scored ${total}/5. >> AVERAGE.
	<br><a href="Quiz">Play Again</a>
	<h3>Progress: 100</h3>
	</c:if>
	
	<c:if test="${total==4}">
	You Have Scored ${total}/5. >> ABOVE AVERAGE.
	<br><a href="Quiz">Play Again</a>
	<h3>Progress: 100</h3>
	</c:if>
	
	<c:if test="${total==5}">
	You Have Scored ${total}/5. >> AWESOME.
	<br><a href="Quiz">PLAY AGAIN</a>
	<h3>Progress: 100</h3>
	</c:if>
</c:if>	
	
</body>
</html>