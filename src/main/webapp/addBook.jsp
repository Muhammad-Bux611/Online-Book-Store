<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book | Online Book Store</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white text-center">
            <h3>Add New Book</h3>
        </div>
        <div class="card-body">
            <form action="bookServlet" method="post">
                <input type="hidden" name="action" value="add">
                
                <div class="mb-3">
                    <label for="bId" class="form-label">Book ID</label>
                    <input type="text" class="form-control" id="bId" name="id" placeholder="Enter Book ID" required>
                </div>

                <div class="mb-3">
                    <label for="bName" class="form-label">Book Title</label>
                    <input type="text" class="form-control" id="bName" name="title" placeholder="Enter Book Title" required>
                </div>

                <div class="mb-3">
                    <label for="bWriter" class="form-label">Author Name</label>
                    <input type="text" class="form-control" id="bWriter" name="author" placeholder="Enter Author Name" required>
                </div>

                <div class="mb-3">
                    <label for="rs" class="form-label">Price</label>
                    <input type="number" class="form-control" id="rs" name="price" placeholder="Enter Book Price" required>
                </div>

                <div class="mb-3">
                    <label for="dis" class="form-label">Description</label>
                    <textarea class="form-control" id="dis" name="discription" rows="4" placeholder="Enter Book Description" required></textarea>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success">Add Book</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
