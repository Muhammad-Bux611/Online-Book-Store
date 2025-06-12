<%@page import="BookStore.entity.OrderEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Order | Online Book Store</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%
    OrderEntity order = (OrderEntity) session.getAttribute("order");
%>

<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-warning text-dark text-center">
            <h3>Update Your Order</h3>
        </div>
        <div class="card-body">
            <form action="OrderServlet" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="Bid" value="<%= order.getBook().getId() %>">

                <div class="mb-3">
                    <label class="form-label">Order ID</label>
                    <input type="number" class="form-control" name="id" value="<%= order.getId() %>" readonly>
                </div>

                <div class="mb-3">
                    <label class="form-label">User Email</label>
                    <input type="text" class="form-control" name="email" value="<%= order.getUser().getEmail() %>" readonly>
                </div>

                <div class="mb-3">
                    <label class="form-label">Book Title</label>
                    <input type="text" class="form-control" value="<%= order.getBook().getTitle() %>" readonly>
                </div>

                <div class="mb-3">
                    <label class="form-label">Price of One Book</label>
                    <input type="number" class="form-control" name="price" value="<%= order.getBook().getPrice() %>" readonly>
                </div>

                <div class="mb-3">
                    <label class="form-label">Quantity</label>
                    <input type="number" class="form-control" name="quantity" value="<%= order.getQuantity() %>" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Total Price</label>
                    <input type="number" class="form-control" value="<%= order.getTotalPrice() %>" readonly>
                </div>

                <div class="mb-3">
                    <label class="form-label">Shipping Address</label>
                    <textarea class="form-control" rows="4" name="address" required><%= order.getAddress() %></textarea>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Update Order</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap 5 JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
