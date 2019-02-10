<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<h2>WELCOME TO ORDER_METHTOD DATA!!</h2>
	<table border="1">
		<tr>
			<th>OID</th>
			<th>OMODE</th>
			<th>OCODE</th>
			<th>ETYPE</th>
			<th>O_ACCEPT</th>
			<th>NOTE</th>
			<th>OPERATIONS</th>
		</tr>

		<c:forEach items="${list}" var="od">
			<tr>
				<td><c:out value="${od.oid}"></c:out></td>
				<td><c:out value="${od.orderMode}"></c:out></td>
				<td><c:out value="${od.orderCode}"></c:out></td>
				<td><c:out value="${od.exeType}"></c:out></td>
				<td><c:out value="${od.orderAccept}"></c:out></td>
				<td><c:out value="${od.orderDsc}"></c:out></td>
				<td><a href="delete?id=${od.oid}"></a></td>
			</tr>
		</c:forEach>

	</table>
	${message}
</body>
</html>