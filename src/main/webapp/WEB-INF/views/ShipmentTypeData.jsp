<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UOM Data Page</title>
</head>
<body>

	<%@include file="UserMenu.jsp"%>
	<div class="container">

		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO SHIPMENT DATA PAGE</h2>
			</div>
			<!-- card header end -->
			<div class="card-body ">
				<c:choose>
					<c:when test="${empty list }">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>
						<table class="table table-bordered table-hover">
							<tr class="thead-dark">
								<th>ID</th>
								<th>MODE</th>
								<th>CODE</th>
								<!-- <th>ENABLE?</th>
									 <th>GRADE</th>
									 <th>NOTE</th> -->
								<th colspan="7">OPERATIONS</th>
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
									<td><a href="delete?sid=${st.sid}"><img
											src="../resources/images/Delete.png" height="30" width="30" /></a></td>
									<td><a href="viewOne?sid=${st.sid}"><img
											src="../resources/images/viewall.png" height="20" width="30" /></a></td>

									<td><a href="editOne?sid=${st.sid}"><img
											src="../resources/images/Edit.png" height="30" width="30" /></a></td>

									<td><a href="exportExcelOne?sid=${st.sid}"><img
											src="../resources/images/excel.png" height="30" width="30" /></a></td>
									<td><a href="exportPdfOne?sid=${st.sid}"><img
											src="../resources/images/pdf.png" height="30" width="30" /></a></td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<c:if test="${message != null}">
				<div class="card-footer bg-success text-white">${message}</div>
			</c:if>
		</div>
	</div>
</body>
</html>