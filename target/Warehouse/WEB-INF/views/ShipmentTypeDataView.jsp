
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to ShipmentViewPage</h2>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>${st.sid}</td>
		</tr>
		<tr>
			<td>MODE</td>
			<td>${st.shipmentMode}</td>
		</tr>
		<tr>
			<td>CODE</td>
			<td>${st.shipmentCode}</td>
		</tr>
		<tr>
			<td>ENABLE</td>
			<td>${st.enbleShipment}</td>
		</tr>
		<tr>
			<td>GRADE</td>
			<td>${st.shipmentGrade}</td>
		</tr>
		<tr>
			<td>NOTE</td>
			<td>${st.sdec}</td>
		</tr>
	</table>
</body>
</html>