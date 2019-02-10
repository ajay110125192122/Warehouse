<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WH_USER_TYPE DATA PAGE</title>
</head>
<body>

	<%@include file="UserMenu.jsp"%>
	<div class="container">

		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO WH_USER_TYPE DATA PAGE</h2>
			</div>
			<!-- card header end -->
			<div class="card-body">
				<c:choose>
					<c:when test="${empty list }">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>
						<a href="exportToExcelAll"><img
							src="../resources/images/exportall.png" height="30" width="30" /></a>
						<a href="exportToPdfAll"><img
							src="../resources/images/pdf.png" height="30" width="30" /></a>
						<table class="table table-bordered table-hover">
							<tr class="thead-dark">
								<th>wh_uid</th>
								<th>wh_type</th>
								<!-- <th>wh_code</th>
								<th>wh_user_for</th>
								<th>wh_mail</th>
								<th>contact</th> -->
								<th>id_type</th>
								<th>others</th>
								<th>idNumber</th>
								<th colspan="7" align="center">OPERATIONS</th>
							</tr>
							<c:forEach items="${list}" var="wt">
								<tr>
									<td><c:out value="${wt.uid}"></c:out></td>
									<td><c:out value="${wt.userType}"></c:out></td>
									<%-- <td><c:out value="${wt.userCode}"></c:out></td>
									<td><c:out value="${wt.userFor}"></c:out></td>
									<td><c:out value="${wt.userMail}"></c:out></td>
									<td><c:out value="${wt.userContact}"></c:out></td> --%>
									<td><c:out value="${wt.userIdType}"></c:out></td>
									<td><c:out value="${wt.otherType}"></c:out></td>
									<td><c:out value="${wt.idNumber}"></c:out></td>

									<td><a href="deleteOne?id=${wt.uid}"> <img
											src="../resources/images/Delete.png" height="30" width="30" />
									</a></td>
									<td><a href="viewOne?id=${wt.uid}"> <img
											src="../resources/images/viewall.png" height="30" width="30" />
									</a></td>
									<td><a href="editOne?id=${wt.uid}"> <img
											src="../resources/images/Edit.png" height="30" width="30" />
									</a> <img src="../resources/images/Edit.png" height="30" width="30"></td>
									<td><a href="exportExcelOne?id=${wt.uid}"> <img
											src="../resources/images/excel.png" height="30" width="30" />
									</a></td>
									<td><a href="exportPdfOne?id=${wt.uid}"> <img
											src="../resources/images/pdf.png" height="30" width="30" />
									</a></td>
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
	</div>
</body>
</html>