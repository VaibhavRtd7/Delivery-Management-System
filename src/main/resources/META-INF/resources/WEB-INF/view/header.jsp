<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Delivery Management System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse" style="margin-bottom:0; background-color:#C0DBEA;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Delivery Management System</a>
    </div>
    <ul class="nav navbar-nav">
      <li  style="background-color:#C0DBEA;"><a href="/">Home</a></li>
      <c:if test="${not empty customer}">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Order<span class="caret"></span></a>
          <ul class="dropdown-menu">     
            <li><a href="<%=request.getContextPath()%>/customer/orders">Add Order</a></li>          
            <li><a href="<%=request.getContextPath()%>/customer/history">Order History</a></li>
          </ul>
        </li>
        <li><a href="<%=request.getContextPath()%>/category">Add Product Category</a></li>
      </c:if>
    </ul>
    <c:if test="${not empty dp}">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Deliver Order<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath()%>/deliveryPerson/orders">Order List</a></li>
            <li><a href="<%=request.getContextPath()%>/deliveryPerson/history">Order History</a></li>
          </ul>
        </li>
      </ul>
    </c:if>
    
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${empty dp && empty customer}">
	  <li class="dropdown">
	    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Sign Up<span class="caret"></span></a>
	    <ul class="dropdown-menu">
	      <li><a href="<%=request.getContextPath()%>/customer/register"><span class="glyphicon glyphicon-user"></span> Customer Sign Up</a></li>
	      <li><a href="<%=request.getContextPath()%>/deliveryPerson/register"><span class="glyphicon glyphicon-user"></span> Delivery Person Sign Up</a></li>
	    </ul>
	  </li>
	</c:if>
		<c:if test="${empty dp && empty customer}">
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Login<span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="<%=request.getContextPath()%>/customer/login"><span class="glyphicon glyphicon-log-in"></span> Customer Login</a></li>
	          <li><a href="<%=request.getContextPath()%>/deliveryPerson/login"><span class="glyphicon glyphicon-log-in"></span>	Delivery Person Login</a></li>
		        </ul>
	      	</li>
	     </c:if>
      	<c:if test="${not empty customer || not empty dp}">
      	 	<li><a href="<%=request.getContextPath()%>/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
    	</c:if>
    </ul>
  </div>
</nav>
</body>
</html>