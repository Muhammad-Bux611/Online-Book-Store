<%@ page import="BookStore.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard | Online Book Store</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container d-flex justify-content-center align-items-center min-vh-100">
        <div class="card shadow p-4 text-center" style="width: 100%; max-width: 500px;">
            <%
                User user = (User) session.getAttribute("user");
                String userEmail = user.getEmail();
                String role = request.getParameter("role");
            %>
            <h3 class="mb-4">Welcome, <%= user.getEmail() %>!</h3>
            <div class="d-grid gap-3">
                <a href="bookServlet?action=view&role=<%= role %>" class="btn btn-primary btn-lg">Add More to Cart</a>
                <a href="viewAllOrders?userEmail=<%= userEmail %>&action=view" class="btn btn-success btn-lg">View All Orders</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS Bundle (Optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
