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

	<h2>Edit employee</h2>

	<form method="Post" action="/CarWorkshop/empEdit">
		<label>ID <input type="text" name="who" value="${param.who }" ></label><br>
		<label> Enter first name <input type="text" name="firstName"
			value="${emp.firstName }">
		</label><br> 
		<label> Enter last name <input type="text"
			name="lastName" value="${emp.lastName }">
		</label><br>
		 <label> Enter address <input type="text"
			name="address" value="${emp.address }">
		</label><br>
		 <label> Enter phonenumber <input type="text"
			name="phoneNumber" value="${emp.phoneNumber }" pattern="[0-9]{9}">
		</label><br>
		 <label> Enter workhour cost <input type="text"
			name="workHourCost" value="${emp.workHourCost }"
			pattern="^[0-9]+\.*[0-9]{0,2}$">
		</label><br>
		 <label> Enter note <textarea rows="5" cols="20"
			name="note">${emp.note }
		</textarea>
		</label><br> <input type="submit" name="sumbit">

	</form>

</body>
</html>