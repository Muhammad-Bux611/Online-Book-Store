<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Store | Login as User</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container d-flex justify-content-center align-items-center min-vh-100">
        <div class="card shadow p-4" style="width: 100%; max-width: 400px;">
            <h3 class="text-center mb-4">User Login</h3>
            <form action="user" method="post">
                <div class="mb-3">
                    <label for="mail" class="form-label">Email address</label>
                    <input type="email" class="form-control" id="mail" name="mail" placeholder="user@gmail.com" required>
                </div>
                <div class="mb-3">
                    <label for="pass" class="form-label">Password</label>
                    <input type="password" class="form-control" id="pass" name="pin" placeholder="8 or more characters" required>
                </div>
                <input type="hidden" name="role" value="user">
                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
            <div class="mt-3 text-center">
                <span>Don't have an account?</span>
                <a href="Registration.jsp">Register here</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS Bundle (Optional for dynamic components) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
