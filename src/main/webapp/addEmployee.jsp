
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
    <h2>Add Employee</h2>
    <form action="addEmployee" method="post">
        <label>Name:</label>
        <input type="text" name="name" required>

        <label>Department:</label>
        <input type="text" name="department" required>

        <label>Salary:</label>
        <input type="text" name="salary" required>

        <label>Street:</label>
        <input type="text" name="street" required>

        <label>City:</label>
        <input type="text" name="city" required>

        <label>State:</label>
        <input type="text" name="state" required>

        <label>Zip:</label>
        <input type="text" name="zip" required>

        <input type="submit" value="Add Employee">
    </form>

    <%-- Display error message if present --%>
    <c:if test="${not empty error}">
        <p style="color:red">${error}</p>
    </c:if>
</div>
</body>
</html>
