<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

	<h1>List of employees</h1>

	<table>
		<thead>
			<th>First name</th>
			<th>Last name</th>
			<th>Phone number</th>
			<th>$ per hour</th>
			<th>Options</th>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${employees}">
				<tr>
					<td>${emp.firstName }</td>
					<td>${emp.lastName }</td>
					<td>${emp.phoneNumber }</td>
					<td>${emp.workHourCost}</td>
					<td><a href="/CarWorkshop/empOptions?do=1&who=${emp.id }">Edit</a></br>
					<a href="/CarWorkshop/employeePage?do=2">Delete</a></br>
					<a href="/CarWorkshop/employeePage?do=3">Show orders</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>