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
			<td bgcolor="pink">ID</td>
			<td bgcolor="pink">${od.oid}</td>
		</tr>
		<tr>
			<td bgcolor="pink"></td>
			<td bgcolor="pink">${od.orderMode}</td>
		</tr>
		<tr>
			<td bgcolor="pink">OMODE</td>
			<td bgcolor="pink">${od.orderCode}</td>
		</tr>
		<tr>
			<td bgcolor="pink">OCODE</td>
			<td bgcolor="pink">${od.orderCode}</td>
		</tr>
		<tr>
			<td bgcolor="pink">ETYPE</td>
			<td bgcolor="pink">${od.exeType}</td>
		</tr>
		<tr>
			<td bgcolor="pink">O_ACCEPT</td>
			<td bgcolor="pink">${od.orderAccept}</td>
		</tr>
		<tr>
			<td bgcolor="pink">NOTE</td>
			<td bgcolor="pink">${od.sDsc}</td>
		</tr>
	</table>
	<a href="all"><img src="../resources/images/viewall.png" height="50" width="150"/> </a>
</body>
</html>