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
	<h2>Welcome to OrderMethod Data View Page!!</h2>
	<table border="1">
		<tr>
			<td bgcolor="pink">wh_uid</td>
			<td bgcolor="pink">${wt.uid}</td>
		</tr>
		<tr>
			<td bgcolor="pink">wh_type</td>
			<td bgcolor="pink">${wt.userType}</td>
		</tr>
		<tr>
			<td bgcolor="pink">wh_code</td>
			<td bgcolor="pink">${wt.userCode}</td>
		</tr>
		<tr>
			<td bgcolor="pink">wh_user_for</td>
			<td bgcolor="pink">${wt.userFor}</td>
		</tr>
		<tr>
			<td bgcolor="pink">wh_mail</td>
			<td bgcolor="pink">${wt.userMail}</td>
		</tr>
		<tr>
			<td bgcolor="pink">contact</td>
			<td bgcolor="pink">${wt.userContact}</td>
		</tr>
		<tr>
			<td bgcolor="pink">id_type</td>
			<td bgcolor="pink">${wt.userIdType}</td>
		</tr>
		<tr>
			<td bgcolor="pink">others</td>
			<td bgcolor="pink">${wt.otherType}</td>
		</tr>
		<tr>
			<td bgcolor="pink">id_number</td>
			<td bgcolor="pink">${wt.idNumber}</td>
		</tr>
	</table>
	<a href="all"><img  src="../resources/images/viewall.png" height="35" width="40"/> </a>
</body>
</html>