<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Category | Online Book Store</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container d-flex justify-content-center align-items-center min-vh-100">
        <div class="card shadow p-4" style="width: 100%; max-width: 600px;">
            <h3 class="text-center mb-4">Add Book Category</h3>
            <form action="categoryServlet" method="post">
                <div class="mb-3">
                    <label for="cId" class="form-label">Category ID</label>
                    <input type="text" id="cId" name="cat_id" class="form-control" placeholder="Category Id" required>
                </div>
                <div class="mb-3">
                    <label for="cName" class="form-label">Category Title</label>
                    <input type="text" id="cName" name="cat_title" class="form-control" placeholder="Title" required>
                </div>
                <div class="mb-3">
                    <label for="dis" class="form-label">Description</label>
                    <textarea rows="4" name="cat_discription" id="dis" class="form-control" placeholder="Description" required></textarea>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-success">Submit</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS Bundle (optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
