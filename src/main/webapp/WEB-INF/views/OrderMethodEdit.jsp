<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to ORDERMETHOD Register page!!</h2>

	<form:form action="update" method="post" modelAttribute="orderMethod">
		<pre>
	Order ID:<form:input path="oid" readonly="true" />
Order Mode :<form:radiobutton path="orderMode" value="SALE" />Sale
	<form:radiobutton path="orderMode" value="PURCHASE" />Purchase
	
	Order Code:<form:input path="orderCode" readonly="true" />
	
	
	Execute Type : <form:select path="exeType">
			<form:option value="">-select-</form:option>
			<form:option value="FIFO">FIFO</form:option>
			<form:option value="LIFO">LIFO</form:option>
			<form:option value="FCFO">FCFO</form:option>
			<form:option value="FEFO">FEFO</form:option>
		</form:select>
	
	Order Accept : <form:checkbox path="orderAccept" value="Multi-Model" />Multi-Model
		<form:checkbox path="orderAccept" value="Accept Return" />Accept Return
		<form:checkbox path="orderAccept" value="Service Extend" />Service Return

	Description :<form:textarea path="sDsc" />
<input type="submit" value="updateOrder" />
</pre>
	</form:form>
</body>
</html>