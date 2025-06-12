<%@page import="java.util.List"%>
<%@page import="BookStore.entity.OrderEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Orders | Online Book Store</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4 text-center">All Orders</h2>

    <table class="table table-bordered table-striped table-hover">
        <thead class="table-dark">
            <tr>
                <th>Order ID</th>
                <th>Book Title</th>
                <th>User Name</th>
                <th>Quantity</th>
                <th>Order Date</th>
                <th>Price per Book</th>
                <th>Total Amount</th>
                <th>Address</th>
                <th>Operation</th>
            </tr>
        </thead>
        <tbody>
        <%
        List<OrderEntity> orders = (List<OrderEntity>) session.getAttribute("orders");
        if (orders != null && !orders.isEmpty()) {
            for (OrderEntity order : orders) {
        %>
            <tr>
                <td><%= order.getId() %></td>
                <td><%= order.getBook().getTitle() %></td>
                <td><%= order.getUser().getName() %></td>
                <td><%= order.getQuantity() %></td>
                <td><%= order.getOrder_Date() %></td>
                <td><%= order.getBook().getPrice() %></td>
                <td><%= order.getTotalPrice() %></td>
                <td><%= order.getAddress() %></td>
                <td>
                    <a href="updateOrderServlet?Orderid=<%= order.getId() %>" class="btn btn-sm btn-warning me-1">Update</a>
                    <a href="viewAllOrders?action=delete&Orderid=<%= order.getId() %>&userEmail=<%= order.getUser().getEmail() %>" class="btn btn-sm btn-danger">Delete</a>
                </td>
            </tr>
        <%
            }
        } else {
        %>
            <tr>
                <td colspan="9" class="text-center">No orders found.</td>
            </tr>
        <%
        }
        %>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
