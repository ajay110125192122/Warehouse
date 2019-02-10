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
	<h2>WELCOME TO USERDATA VIEW PAGE!!</h2>
	<table border="1">
		<tr>
			<td bgcolor="skyblue">UID</td>
			<td bgcolor="skyblue">${list.userid}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">UNAME</td>
			<td bgcolor="skyblue">${list.userName}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">U-MAIL</td>
			<td bgcolor="skyblue">${list.userMail}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">CONTACT</td>
			<td bgcolor="skyblue">${list.mobile}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">ROLE</td>
			<td bgcolor="skyblue">${list.roles}</td>
		</tr>
	</table>
	<br>
	<a href="all"><img src="../resources/images/viewall.png"
		height="60" width="120"></a>
</body>
</html>