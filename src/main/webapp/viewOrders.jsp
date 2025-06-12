<%@page import="BookStore.entity.OrderEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order List</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Customer Orders</h2>
        <table class="table table-bordered table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>Order ID</th>
                    <th>Book Title</th>
                    <th>User Name</th>
                    <th>Quantity</th>
                    <th>Order Date</th>
                    <th>Price of Each Book</th>
                    <th>Total Price</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<OrderEntity> orders = (List<OrderEntity>) session.getAttribute("orders");
                if (orders != null) {
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
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="8" class="text-center">No orders found.</td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
