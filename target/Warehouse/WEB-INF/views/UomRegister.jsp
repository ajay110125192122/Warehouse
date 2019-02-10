<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to UOM register page!!</h2>
	<form action="insert" method="post">

		<pre>
 	Uom Type	: <select name="uomType">
 					<option value="">--select--</option>
 					<option value="PACKING">PACKING</option>
 					<option value="NO_PACKING">NO_PACKING</option>
 					<option value="NA">NA</option> 
 				   </select>
	Uom Model   : 	 <input type="text" name="uomModel" />
	Description :	 <textarea name="uomDsc"></textarea>


				<input type="submit" value="Create UOM">
</pre>


<a href="all">VIEW ALL RECORDS</a><br>

${message}

	</form>
</body>
</html>