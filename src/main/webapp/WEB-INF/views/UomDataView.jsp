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
			<td bgcolor="skyblue">ID</td>
			<td bgcolor="skyblue">${list.id}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">TYPE</td>
			<td bgcolor="skyblue">${list.uomType}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">MODEL</td>
			<td bgcolor="skyblue">${list.uomModel}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">NOTE</td>
			<td bgcolor="skyblue">${list.uomDsc}</td>
		</tr>
	</table>
	<br>
	<!-- <a href="all"><img src="../resources/images/viewall.png" height="60" width="120"></a> -->
</body>
</html>