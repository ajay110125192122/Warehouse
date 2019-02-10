
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
			<td bgcolor="skyblue">ID</td>
			<td bgcolor="skyblue">${st.sid}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">MODE</td>
			<td bgcolor="skyblue">${st.shipmentMode}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">CODE</td>
			<td bgcolor="skyblue">${st.shipmentCode}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">ENABLE</td>
			<td bgcolor="skyblue">${st.enbleShipment}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">GRADE</td>
			<td bgcolor="skyblue">${st.shipmentGrade}</td>
		</tr>
		<tr>
			<td bgcolor="skyblue">NOTE</td>
			<td bgcolor="skyblue">${st.sdec}</td>
		</tr>
	</table>
	<br>
	<br />
	
	<a href="all"><img src="../resources/images/viewall.png"
		height="50" width="100" /></a>

</body>
</html>