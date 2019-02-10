<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to ShipmentTypeRegister page!!</h2>
	<form:form action="update" method="post" modelAttribute="shipmentType">
		<pre>
		Shipment ID:<form:input path="sid" readonly="true" />	
Shipment Mode : <form:select path="shipmentMode">
<form:option value="">-select-</form:option>
<form:option value="AIR">Air</form:option>
<form:option value="TRUCK">Truck</form:option>
<form:option value="">Train</form:option>
<form:option value="SHIP">Ship</form:option>
			</form:select>
Shipment Code :<form:input path="shipmentCode" />
Enable Shipment : <form:select path="enbleShipment">
<form:option value="">-select-</form:option>
<form:option value="YES">Yes</form:option>
<form:option value="NO">No</form:option>
			</form:select>
Shipment Grade: <form:radiobutton path="shipmentGrade" value="A"
				disabled="true" />A
		<form:radiobutton path="shipmentGrade" value="B" disabled="true" />B
		<form:radiobutton path="shipmentGrade" value="C" disabled="true" />C
Description :<form:textarea path="sdec" />
		<input type="submit" value="Update Shipment" />
	</pre>
	</form:form>
	<br /> ${message}

</body>
</html>