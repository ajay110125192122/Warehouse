<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to ShipmentTypeRegister page!!</h2>
	<form action="insert" method="post">
		<pre>
	Shipment Mode : <select name="shipmentMode">
					<option value="">--select-- </option>
					<option value="AIR">air </option>
					<option value="TRUCK">Truck </option>
					<option value="TRAIN">Train </option>
					<option value="SHIP">Ship </option>
					</select>
	Shipment Code : <input type="text" name="shipmentCode" />
	Enable Shipment : <select name="enbleShipment">
	
					<option value="YES">yes</option>	
					<option value="NO">no</option>
					</select>
	shipment Grade : <input type="radio" name="shipmentGrade" value="A">A
					<input type="radio" name="shipmentGrade" value="B">B
					<input type="radio" name="shipmentGrade" value="C">C
	Description : <textarea name="sdece"></textarea>
	 <input type="submit" value="CreateShipment" />
	
	</pre>
	</form>
	${message }


	<br></br>
	<a href="all">VIEW ALL RECORDS</a>
</body>
</html>