<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home | Online Book Store</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container text-center mt-5">
        <div class="card shadow p-4">
            <h2 class="mb-4">Welcome to the Online Book Store</h2>
            <div class="d-grid gap-3">
                <a href="categories.jsp" class="btn btn-success btn-lg">Add Book</a>
                <a href="bookServlet?action=view" class="btn btn-primary btn-lg">View Books</a>
                <a href="OrderServlet?action=viewAllOrder" class="btn btn-warning btn-lg">View All Orders</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
