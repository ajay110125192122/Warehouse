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
	<h2>Welcome to OVERMETHOD Register page!!</h2>
	<form action="insert" method="post">
		<pre>
Order Mode 		: <input type="radio" name="orderMode" value="SALE" />Sale
			  <input type="radio" name="orderMode" value="PURCHASE" />Purchase
Order Code	   	:<input type="text" name="orderCode" />
					
Execute Type             :<select name="exeType">
				  <option value="">--select--</option>
			 	   <option value="FIFO">FIFO</option>
			 	   <option value="LIFO">LIFO</option>
			 	   <option value="FCFO">FCFO</option>
			 	   <option value="FEFO">FEFO</option>
				   </select>
Order Accept             :<input type="checkbox" name="orderAccept"
				value="Multi-model" />MULTI_MODEL
		          <input type="checkbox" name="orderAccept"
				value="Accept Return" />ACCEPT RETURN
	                   <input type="checkbox" name="orderAccept"
				value="Servivce Extend" />SERVICEE EXTEND
Description              :<textarea name="orderDsc"></textarea>
			<br>
<br>                <input type="submit" value="CreateOrderMethod" />
</pre>
	</form>
		<br> ${message} <br> <a href="all">viewall Records</a>
	
</body>
</html>