<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to UOM DATA page!!</h2>
	<table border="1">
		<tr>
			<th>UID</th>
			<th>UTYPE</th>
			<!-- <th>UMODEL</th>
				<th>UDSC</th>
				 -->
			<th>OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="uo">
			<tr>
				<td><c:out value="${uo.id}"></c:out></td>
				<td><c:out value="${uo.uomType}"></c:out></td>
				<%-- <td><c:out value="${uo.uomModel}"></c:out></td>
				<td><c:out value="${uo.uomDsc}"></c:out></td>
				 --%>
				<td><a href="delete?id=${uo.id}">DELETE</a></td>
				<td><a href="viewOne?id=${uo.id}">ViewOne</a></td>
			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>