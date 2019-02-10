<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>WELCOME TO UOMDATA VIEW PAGE!!</h2>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>${list.id}</td>
		</tr>
		<tr>
			<td>TYPE</td>
			<td>${list.uomType}</td>
		</tr>
		<tr>
			<td>MODEL</td>
			<td>${list.uomModel}</td>
		</tr>
		<tr>
			<td>NOTE</td>
			<td>${list.uomDsc}</td>
		</tr>
	</table>
</body>
</html>