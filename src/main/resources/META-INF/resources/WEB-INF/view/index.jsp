<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Delivery Management System</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+oe4K5BY3Aq6YJQnBwv7hFefjQz6zP0Fq8hOP+8ElvRyt4cD5DVKmhTm1rFtxBKh" crossorigin="anonymous">
  <!-- Custom styles for this template -->
  <style>
    /* Custom styles */
    body {
      background-color: #f8f9fa;
      font-family: Arial, sans-serif;
    }
    .hero-section {
      padding: 3rem 0;
      background-color: #007bff;
      color: white;
      text-align: center;
    }
    .feature-section {
      padding: 4rem 0;
      background-color: #f8f9fa;
    }
    .feature-box {
      background-color: white;
      border-radius: 10px;
      padding: 2rem;
      margin-bottom: 20px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      text-align: center;
    }
    .feature-box h3 {
      color: #007bff;
    }
    .footer {
      background-color: #343a40;
      color: white;
      padding: 2rem 0;
      text-align: center;
    }
  </style>
</head>
<body>

<!-- Navigation Bar -->
<jsp:include page="header.jsp" />

<!-- Hero Section -->
<section class="hero-section">
  <div class="container">
    <h1 class="display-4">Delivery Management System</h1>
    <p class="lead">Efficient and Reliable Delivery Solutions</p>
  </div>
</section>

<!-- Features Section -->
<section class="feature-section">
  <div class="container">
    <div class="row">
      <div class="col-md-4">
        <div class="feature-box">
          <h3>Real-time Tracking</h3>
          <p>Track deliveries in real-time to ensure timely arrivals.</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="feature-box">
          <h3>Route Optimization</h3>
          <p>Optimize delivery routes to minimize time and cost.</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="feature-box">
          <h3>Customer Notifications</h3>
          <p>Automatically notify customers about delivery status.</p>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Additional Sections -->
<section class="container-fluid bg-light py-5">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <h2>Why Choose Us?</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed gravida neque nec tortor finibus, sit amet volutpat dui sodales. Phasellus ultricies malesuada velit, at tempus mi volutpat ac.</p>
      </div>
      <div class="col-md-6">
        <h2>Our Vision</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed gravida neque nec tortor finibus, sit amet volutpat dui sodales. Phasellus ultricies malesuada velit, at tempus mi volutpat ac.</p>
      </div>
    </div>
  </div>
</section>

<!-- Call to Action Section -->
<section class="container-fluid bg-primary text-white py-5 mt-5">
  <div class="container">
    <h2 class="text-center mb-4">Get Started Today</h2>
    <p class="text-center">Contact us now to streamline your delivery operations!</p>
    <div class="text-center">
      <a href="#" class="btn btn-light btn-lg">Contact Us</a>
    </div>
  </div>
</section>

<!-- Footer Section -->
<footer class="footer">
  <div class="container">
    <p>&copy; 2024 Delivery Management System. All rights reserved.</p>
  </div>
</footer>

<!-- Bootstrap Bundle JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</body>
</html>
