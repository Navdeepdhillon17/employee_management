<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login - Employee Management System</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(to right, #4facfe, #00f2fe);
            font-family: Arial, sans-serif;
        }

        .login-container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
        }

        .welcome-message {
            font-size: 20px;
            font-weight: bold;
            color: #007bff;
            margin-bottom: 10px;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        p {
            color: red;
            font-size: 14px;
        }

        label {
            display: block;
            text-align: left;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        button {
            width: 100%;
            background: #007bff;
            color: white;
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background: #0056b3;
        }

        .register-link {
            margin-top: 10px;
            font-size: 14px;
        }

        .register-link a {
            color: #007bff;
            text-decoration: none;
        }

        .register-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="login-container">
    <div class="welcome-message">Welcome to Employee Management System</div>
    <h2>Login</h2>
    <% if (request.getParameter("error") != null) { %>
    <p>Invalid username or password!</p>
    <% } %>
    <form action="LoginServlet" method="post">
        <label>Username:</label>
        <input type="text" name="username" required>
        <label>Password:</label>
        <input type="password" name="password" required>
        <button type="submit">Login</button>
    </form>
<%--    <div class="register-link">--%>
<%--        Don't have an account? <a href="register.jsp">Register here</a>--%>
<%--    </div>--%>
</div>
</body>
</html>
