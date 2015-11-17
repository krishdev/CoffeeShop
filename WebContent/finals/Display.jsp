<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<form action="Display" method="get">
<div>
<a href="Adminadd">Go To Add Media</a>

<h3>CD Table</h3>
<input type="text" name="MediaName1"/>
<input type="hidden" name="TypeMedia1" value="CD"/>
<input type="submit" value="Search1" name="CDSearch"/>
<table>
<tr>
<th>
Name
</th>
<th>
Date Added
</th>
<th>
Borrower
</th>
<th>
Date Borrowed
</th>
</tr>
<c:forEach items="${ cdsearch }" var="cds">
	<tr>
				<td>
				<p>${ cds.getMedianame() }</p>
				</td>
				<td>
				<p>${cds.getDateadded() }</p>
				</td>
				<td>
				
				<c:if test="${! empty cds.getBorower()}">	
				<p>${cds.getBorower() }</p>
				<a href="Display?Loan=${cds.getId() }">Return</a>
				
				</c:if>
				
				<c:if test="${empty cds.getBorower()}">	
				
				<a href="Lend?id=${cds.getId() }">Lend</a>
				
				</c:if>
				
				</td>
				</tr>
				</c:forEach>
				
</table>
</div>
<div>


<h3>DVD Table</h3>
<input type="text" name="MediaName2"/>
<input type="hidden" name="TypeMedia2" value="DVD"/>
<input type="submit" value="Search2" name="DVDSearch"/>
<table>
<tr>
<th>
Name
</th>
<th>
Date Added
</th>
<th>
Borrower
</th>
<th>
Date Borrowed
</th>
</tr>
<c:forEach items="${ DVDsearch }" var="cds">
	<tr>
				<td>
				<p>${ cds.getMedianame() }</p>
				</td>
				<td>
				<p>${cds.getDateadded() }</p>
				</td>
				<td>
				
				<c:if test="${! empty cds.getBorower()}">	
				<p>${cds.getBorower() }</p>
				<a href="Display?Loan=${cds.getId() }">Return</a>
				
				</c:if>
				
				<c:if test="${empty cds.getBorower()}">	
				
				<a href="Lend?id=${cds.getId() }">Lend</a>
				
				</c:if>
				
				</td>
				</tr>
				</c:forEach>
				
</table>
</div>
<div>

<h3>Blu-Ray Table</h3>
<input type="text" name="MediaName3"/>
<input type="hidden" name="TypeMedia3" value="Blu-Ray"/>
<input type="submit" value="Search3" name="BluSearch"/>

<table>
<tr>
<th>
Name
</th>
<th>
Date Added
</th>
<th>
Borrower
</th>
<th>
Date Borrowed
</th>
</tr>
<c:forEach items="${ Blusearch }" var="cds">
	<tr>
				<td>
				<p>${ cds.getMedianame() }</p>
				</td>
				<td>
				<p>${cds.getDateadded() }</p>
				</td>
				<td>
				
				<c:if test="${! empty cds.getBorower()}">	
				<p>${cds.getBorower() }</p>
				<a href="Display?Loan=${cds.getId() }">Return</a>
				
				</c:if>
				
				<c:if test="${empty cds.getBorower()}">	
				
				<a href="Lend?id=${cds.getId() }">Lend</a>
				
				</c:if>
				
				</td>
				</tr>
				</c:forEach>
				
</table>
</div>
</form>
</body>
</html>