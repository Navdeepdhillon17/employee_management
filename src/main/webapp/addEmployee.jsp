<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Add Employee</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Add Employee</h2>--%>
<%--<form action="addEmployee" method="post">--%>
<%--    Name: <label>--%>
<%--    <input type="text" name="name" required>--%>
<%--</label><br>--%>
<%--    Department: <label>--%>
<%--    <input type="text" name="department" required>--%>
<%--</label><br>--%>
<%--    Salary: <label>--%>
<%--    <input type="text" name="salary" required>--%>
<%--</label><br>--%>
<%--    Street: <label>--%>
<%--    <input type="text" name="street" required>--%>
<%--</label><br>--%>
<%--    City: <label>--%>
<%--    <input type="text" name="city" required>--%>
<%--</label><br>--%>
<%--    State: <label>--%>
<%--    <input type="text" name="state" required>--%>
<%--</label><br>--%>
<%--    Zip: <label>--%>
<%--    <input type="text" name="zip" required>--%>
<%--</label><br>--%>
<%--    <input type="submit" value="Add Employee">--%>
<%--</form>--%>

<%--&lt;%&ndash; Display error message if present &ndash;%&gt;--%>
<%--<c:if test="${not empty error}">--%>
<%--    <p style="color:red">${error}</p>--%>
<%--</c:if>--%>
<%--</body>--%>
<%--</html>--%>
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
