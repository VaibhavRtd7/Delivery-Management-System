<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery Management System</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f8f8f8;
}

form {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    background-color: #ffffff;
    box-shadow: 0px 0px 5px 0px rgba(0,0,0,0.2);
}

label {
    display: block;
    margin-bottom: 10px;
    font-weight: bold;
}

select, textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    box-sizing: border-box;
}

input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: #ffffff;
    font-weight: bold;
    border: none;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>
<jsp:include page="header.jsp" />
	<form action="<%=request.getContextPath()%>/customer/update/order" method="post">
	  <h2>Order Form</h2>
	  <input type="hidden" name= "order_id" value=${order.id}> 
	  <label for="pickup_add">Pickup Address:</label>
	  <textarea name="pickup_add" id="pickup_add" rows="3" cols="30">${order.pickup_address.getSubString(1, order.pickup_address.length())}</textarea><br>
	  <label for="dest_add">Destination Address:</label>
	  <textarea name="dest_add" id="dest_add" rows="3" cols="30">${order.destination_address.getSubString(1, order.destination_address.length())}</textarea><br>
	  <label for="category">Select a category:</label>
	  <select name="category" id="category">
	    <c:forEach var="category" items="${categories}">
	      <option value="${category.id}">${category.product_type}</option>
	    </c:forEach>
	  </select><br><br>
	  <input type="submit" value="Submit">
	</form>
</body>
</html>
