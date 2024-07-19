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

.container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

form {
    max-width: 300px;
    padding: 20px;
    background-color: #ffffff;
    box-shadow: 0px 0px 5px 0px rgba(0,0,0,0.2);
}

input[type="text"], input[type="email"], input[type="password"] {
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
<div class="container">
    <form action="<%=request.getContextPath()%>/deliveryPerson/addDeliveryPerson" method="post">
        <h2>Delivery Register</h2>
        <c:if test="${not empty errorMessage}">
			    <div class="alert alert-danger">${errorMessage}</div>
		</c:if>
        Enter Name : <input type="text" name="username"><br>
        Enter email : <input type="email" name="email"><br>
        Enter password : <input type="password" name="password"><br>
        Enter contactNumber : <input type="text" name="contact_no"><br>
        <input type="submit">
    </form>
</div>
</body>
</html>
