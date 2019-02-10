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
	<h2>Welcome to UOM register page!!</h2>
	<form:form action="update" method="post" modelAttribute="uom">
		<pre>
Uom ID: <form:input path="id" readonly="true" />
Uom Type    :<form:select path="uomType">
		<form:option value="">-select-</form:option>
		<form:option value="PACKING">Packing</form:option>
		<form:option value="NO-PACKING">No-Packing</form:option>
		<form:option value="NA">-NA-</form:option>
		</form:select>
Uom Model   :<form:input path="uomModel" readonly="true" />	
Description :<form:textarea path="uomDsc" />
	
		<input type="submit" value="UpdateUom" />
		</pre>
	</form:form>
	<br>
	<a href="all">VIEW ALL RECORDS</a>
	<br> ${message}

</body>
</html>