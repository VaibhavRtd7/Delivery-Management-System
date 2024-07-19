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
    margin: 0;
}

.container {
    max-width: 800px;
    margin: 0 auto;
    background-color: #ffffff;
    border-radius: 5px;
    box-shadow: 0px 0px 5px 0px rgba(0,0,0,0.2);
    overflow: hidden;
}

table {
    width: 100%;
    border-collapse: collapse;
}

thead {
    background-color: #007bff;
    color: #fff;
}

th, td {
    padding: 10px;
    text-align: left;
}

th {
    font-weight: bold;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

a {
    color: #007bff;
    text-decoration: none;
    transition: color 0.3s ease;
}

a:hover {
    color: #0056b3;
    text-decoration: underline;
}

/* Additional Styling */

.container {
    max-width: 800px;
    margin: 0 auto;
    background-color: #ffffff;
    border-radius: 5px;
    box-shadow: 0px 0px 5px 0px rgba(0,0,0,0.2);
    overflow: hidden;
    font-size: 18px; /* You can adjust the font size here */
}


table {
    margin-top: 20px;
    table-layout: fixed; /* Added fixed table layout for consistent column widths */
}

th, td {
    word-wrap: break-word; /* Added word-wrap to allow long text to wrap within cells */
}

</style>
<!-- Include Font Awesome CSS file -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body>
<jsp:include page="header.jsp" />
<div class="container">
<table>
  <thead>
    <tr>
      <th class="text-center">Order ID</th>
      <th class="text-center">Delivery Person Name</th>
      <th class="text-center">Delivery Person Email</th>
      <th class="text-center">Delivery Person Phone Number</th>
      <th class="text-center">Order Total</th>
    </tr>
  </thead>
  <tbody>
      <tr>
        <td class="text-center">${orders.ref_code}</td>
        <td class="text-center">${deliveryPerson.username}</td>
        <td class="text-center">${deliveryPerson.email}</td>
        <td class="text-center">${deliveryPerson.contact_no}</td>
        <td class="text-center">₹${orders.cost}</td>
      </tr>
  </tbody>
</table>
</div>
</body>
</html>
