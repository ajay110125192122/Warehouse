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
	<h2>Welcome to DataViewPage!!</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>MODE</th>
			<th>CODE</th>
			<!-- <th>ENABLE?</th>
			<th>GRADE</th>
			<th>NOTE</th> -->
			<th>OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="st">
			<tr>
				<td><c:out value="${st.sid}"></c:out></td>
				<td><c:out value="${st.shipmentMode}"></c:out></td>
				<td><c:out value="${st.shipmentCode}"></c:out></td>
				<%-- <td><c:out value="${st.enbleShipment}"></c:out></td>
				<td><c:out value="${st.shipmentGrade}"></c:out></td>
				<td><c:out value="${st.sdec}"></c:out></td>
				 --%>
				<td><a href="delete?sid=${st.sid}">DELETE</a></td>
				<td><a href="viewOne?sid=${st.sid}">VIEW_ONE</a></td>
			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>