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
	
	<form method="post" action="/CarWorkshop/empAdd">
		<label> Enter first name <input type="text" name="firstName" placeholder="Enter first name here">
		</label><br> 
		<label> Enter last name <input type="text" name="lastName" placeholder="Enter last name here">
		</label><br>
		 <label> Enter address <input type="text" name="address" placeholder="Enter address here">
		</label><br>
		 <label> Enter phonenumber <input type="text" name="phoneNumber"  pattern="[0-9]{9}" placeholder="Enter phone number here (nine digits)">
		</label><br>
		 <label> Enter workhour cost <input type="text" name="workHourCost"
			pattern="^[0-9]+\.*[0-9]{0,2}$" placeholder="Enter work hour cost here (format XX.XX)">
		</label><br>
		 <label> Enter note <textarea rows="5" cols="20"
			name="note" placeholder="Enter note here">
		</textarea>
		</label><br> <input type="submit" name="sumbit">

	</form>

</body>
</html>