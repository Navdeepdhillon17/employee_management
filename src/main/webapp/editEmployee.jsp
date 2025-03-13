<%@ page import="com.example.aip_4_new.entity.Employee" %>
<%
    Employee employee = (Employee) request.getAttribute("employee");
%>
<html>
<head>
    <title>Edit Employee</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h2>Edit Employee</h2>
<form action="updateEmployee" method="post">
    <input type="hidden" name="id" value="<%= employee.getId() %>">
    Name: <label>
    <input type="text" name="name" value="<%= employee.getName() %>">
</label><br>
    Department: <label>
    <input type="text" name="department" value="<%= employee.getDepartment() %>">
</label><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
