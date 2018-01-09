<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
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
					<a href="/CarWorkshop/empOptions?do=2&who=${emp.id }">Delete</a></br>
					<a href="/CarWorkshop/employeePage?do=3">Show orders</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form method="get" action="/CarWorkshop/empAdd">
	<button type="submit" formmethod="get" formaction="/CarWorkshop/empAdd">Add new</button>
	</form>
</body>
</html>