<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BookStore.entity.Book" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book | Online Book Store</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%
Book book = (Book) session.getAttribute("book");
if (book == null) {
    response.sendRedirect("Login.jsp");
} else {
    int id = book.getId();
    String title = book.getTitle();
    String author = book.getAuthor();
    String discription = book.getDiscription();
    long price = book.getPrice();
%>

<div class="container mt-5">
    <div class="card shadow p-4 mx-auto" style="max-width: 700px;">
        <h3 class="mb-4 text-center">Update Book Details</h3>
        <form action="bookServlet" method="post">
            <input type="hidden" name="action" value="update">
            
            <input type="hidden" name="category" value="<%= book.getCategory().getId() %>">

            <div class="mb-3">
                <label for="bId" class="form-label">Book ID</label>
                <input type="text" id="bId" name="id" class="form-control" value="<%= id %>" readonly>
            </div>

            <div class="mb-3">
                <label for="bName" class="form-label">Book Title</label>
                <input type="text" id="bName" name="title" class="form-control" value="<%= title %>">
            </div>

            <div class="mb-3">
                <label for="bWriter" class="form-label">Author</label>
                <input type="text" id="bWriter" name="author" class="form-control" value="<%= author %>">
            </div>

            <div class="mb-3">
                <label for="rs" class="form-label">Price</label>
                <input type="number" id="rs" name="price" class="form-control" value="<%= price %>">
            </div>

            <div class="mb-3">
                <label for="dis" class="form-label">Description</label>
                <textarea rows="4" id="dis" name="discription" class="form-control"><%= discription %></textarea>
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Update Book</button>
            </div>
        </form>
    </div>
</div>

<% } %>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
