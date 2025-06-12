<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container d-flex justify-content-center align-items-center min-vh-100">
        <div class="card p-4 shadow" style="width: 100%; max-width: 500px;">
            <h3 class="text-center mb-4">User Registration</h3>
            <form action="userServlet" method="post">
                <div class="mb-3">
                    <label for="uid" class="form-label">User ID</label>
                    <input type="number" class="form-control" name="id" id="uid" placeholder="Enter your ID" required>
                </div>
                <div class="mb-3">
                    <label for="uName" class="form-label">Name</label>
                    <input type="text" class="form-control" name="name" id="uName" placeholder="Your Name" required>
                </div>
                <div class="mb-3">
                    <label for="mail" class="form-label">Email</label>
                    <input type="email" class="form-control" name="email" id="mail" placeholder="name@gmail.com" required>
                </div>
                <div class="mb-3">
                    <label for="pin" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" id="pin" placeholder="8 or more characters" required>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-success">Register</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS Bundle (Optional for interactive components) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
