
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<h2>Edit Employee</h2>

<%@ page import="com.example.aip_4_new.dao.EmployeeDAO" %>
<%@ page import="com.example.aip_4_new.entity.Employee" %>
<%@ page import="com.example.aip_4_new.entity.Address" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Long id = Long.parseLong(request.getParameter("id"));
    EmployeeDAO employeeDAO = new EmployeeDAO();
    Employee emp = employeeDAO.getEmployee(id);
    Address addr = emp.getAddress();
%>

<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<h2>Edit Employee</h2>

<form action="updateEmployee" method="post">
    <input type="hidden" name="id" value="<%= emp.getId() %>">

    Name: <input type="text" name="name" value="<%= emp.getName() %>" required><br>
    Department: <input type="text" name="department" value="<%= emp.getDepartment() %>" required><br>
    Salary: <input type="text" name="salary" value="<%= emp.getSalary() %>" required><br>

    Street: <input type="text" name="street" value="<%= (addr != null) ? addr.getStreet() : "" %>"><br>
    City: <input type="text" name="city" value="<%= (addr != null) ? addr.getCity() : "" %>"><br>
    State: <input type="text" name="state" value="<%= (addr != null) ? addr.getState() : "" %>"><br>
    Zip: <input type="text" name="zip" value="<%= (addr != null) ? addr.getZip() : "" %>"><br>

    <button type="submit">Update Employee</button>
</form>


<a href="index.jsp">Cancel</a>
</body>
</html>
