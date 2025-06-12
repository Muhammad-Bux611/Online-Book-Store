<%@page import="java.util.List"%>
<%@page import="BookStore.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View All Books | Online Book Store</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center mb-4">All Available Books</h2>

    <!-- Search Form -->
    <form class="d-flex mb-4" action="bookServlet" method="get">
        <input type="search" name="search" class="form-control me-2" placeholder="Search by Category" required>
        <input type="hidden" name="action" value="searchByCategoryWise">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>

    <!-- Book Table -->
    <table class="table table-bordered table-striped table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Book Title</th>
                <th>Description</th>
                <th>Author</th>
                <th>Price</th>
                <th>Category</th>
                <%
                    String role = (String) session.getAttribute("role");
                    if (role == null) {
                %>
                <th>Operation</th>
                <% } else { %>
                <th>Select Book to Buy</th>
                <% } %>
            </tr>
        </thead>
        <tbody>
        <%
            List<Book> books = (List<Book>) session.getAttribute("books");
            if (books != null && !books.isEmpty()) {
                for (Book book : books) {
        %>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getDiscription() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getPrice() %></td>
                <td><%= book.getCategory().getTitle() %></td>
                <td>
                <% if (role == null) { %>
                    <a href="updateHibernate?id=<%= book.getId() %>&category=<%= book.getCategory().getId() %>" class="btn btn-sm btn-warning me-1">Update</a>
                    <a href="bookServlet?action=delete&id=<%= book.getId() %>" class="btn btn-sm btn-danger">Delete</a>
                <% } else { %>
                    <a href="Order.jsp?id=<%= book.getId() %>&price=<%= book.getPrice() %>" class="btn btn-sm btn-success">Add to Cart</a>
                <% } %>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="7" class="text-center">No books available.</td>
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
