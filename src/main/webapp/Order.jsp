<%@ page import="BookStore.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Place Order | Online Book Store</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%
    User user = (User) session.getAttribute("user");
    String bookId = request.getParameter("id");
    String price = request.getParameter("price");
%>

<div class="container d-flex justify-content-center align-items-center min-vh-100">
    <div class="card shadow p-4" style="width: 100%; max-width: 600px;">
        <h3 class="mb-4 text-center">Place Your Order</h3>
        <form action="OrderServlet" method="post">
            <input type="hidden" name="action" value="placeOrder">

            <div class="mb-3">
                <label for="orderId" class="form-label">Order ID</label>
                <input type="number" class="form-control" id="orderId" name="id" placeholder="Order ID" required>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">User Email</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= user.getEmail() %>" readonly>
            </div>

            <div class="mb-3">
                <label for="price" class="form-label">Price of One Book</label>
                <input type="number" class="form-control" id="price" name="price" value="<%= price %>" readonly>
            </div>

            <div class="mb-3">
                <label for="bookId" class="form-label">Book ID</label>
                <input type="number" class="form-control" id="bookId" name="Bid" value="<%= bookId %>" readonly>
            </div>

            <div class="mb-3">
                <label for="quantity" class="form-label">Quantity</label>
                <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Quantity" required>
            </div>

            <div class="mb-3">
                <label for="address" class="form-label">Shipping Address</label>
                <textarea class="form-control" id="address" name="address" rows="4" placeholder="Home No, Street, City, Country" required></textarea>
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Order Now</button>
            </div>
        </form>
    </div>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
