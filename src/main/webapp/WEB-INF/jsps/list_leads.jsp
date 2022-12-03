<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list of leads</title>
</head>
<body>
	<h1>All leads</h1>
	<table>
		<tr>
			<th>FistName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
	</table>
	
	<c:forEach var = "lead" items = "${leads}">
		<tr>
			<td>${lead.firstName}</td>
			<td>${lead.lastName}</td>
			<td>${lead.email}</td>
			<td>${lead.mobile}</td>
			<th><a href = "Delete?id=${lead.id}">Delete</a></th>
			<th><a href = "Update?id=${lead.id}">Update</a></th><br/>
		</tr>
	</c:forEach>
</body>
</html>