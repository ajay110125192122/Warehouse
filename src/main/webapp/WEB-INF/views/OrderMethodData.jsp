<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Data Page</title>
<%@include file="UserMenu.jsp"%>
</head>
<body>
	<div class="container">

		<div class="card">


			<div class="card-header bg-success text-white">
				<h2>WELCOME TO ORDER_METHTOD DATA!!</h2>
			</div>

			<div class="row bg-primary" align="center">
				<div class="col-6">
					<div class="row col-6" align="center">
						<a href="exportToExcelAll"><img
							src="../resources/images/exportall.png" height="30" width="30" /></a>
					</div>
				</div>
				<div class="col-6">
					<div class="row col-6" align="center">
						<a href="exportToPdfAll"><img
							src="../resources/images/pdf.png" height="30" width="30" /></a>
					</div>
				</div>
			</div>
		</div>
		<div class="card-body">

			<c:choose>
				<c:when test="${empty list }">
					<h4>No Data Found</h4>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-hover">
						<tr class="thead-dark">
							<th>OID</th>
							<th>OMODE</th>
							<th>OCODE</th>
							<th>ETYPE</th>
							<th>O_ACCEPT</th>
							<th>NOTE</th>
							<th colspan="7">OPERATIONS</th>
						</tr>

						<c:forEach items="${list}" var="od">
							<tr>
								<td><c:out value="${od.oid}"></c:out></td>
								<td><c:out value="${od.orderMode}"></c:out></td>
								<td><c:out value="${od.orderCode}"></c:out></td>
								<td><c:out value="${od.exeType}"></c:out></td>
								<td><c:out value="${od.orderAccept}"></c:out></td>
								<td><c:out value="${od.sDsc}"></c:out></td>
								<td><a href="delete?id=${od.oid}"><img
										src="../resources/images/Delete.png" height="30" width="30"></a></td>
								<td><a href="viewOne?id=${od.oid}"><img
										src="../resources/images/viewall.png" height="30" width="30"></a></td>
								<td><a href="editOne?id=${od.oid}"><img
										src="../resources/images/Edit.png" height="30" width="30" />
								</a></td>

								<td><a href="exportExcelOne?id=${od.oid}"><img
										src="../resources/images/excel.png" height="30" width="30" /></a></td>
								<td><a href="exportPdfOne?id=${od.oid}"><img
										src="../resources/images/pdf.png" height="30" width="30" /></a></td>

							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
		<c:if test="${message != null}">
			<div class="card-footer bg-danger text-white">${message}</div>
		</c:if>
	</div>
</body>
</html>
