<%@ page import="com.example.aip_4_new.dao.EmployeeDAO" %>
<%@ page import="com.example.aip_4_new.entity.Employee" %>
<%@ page import="com.example.aip_4_new.entity.Address" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
    <h2>Employee List</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>City</th>
            <th>State</th>
            <th>Zip Code</th>
            <th>Actions</th>
        </tr>

        <%
            EmployeeDAO employeeDAO = new EmployeeDAO();
            List<Employee> employees = employeeDAO.getAllEmployees();

            for (Employee emp : employees) {
                Address addr = emp.getAddress();
        %>
        <tr>
            <td><%= emp.getId() %></td>
            <td><%= emp.getName() %></td>
            <td><%= emp.getDepartment() %></td>
            <td><%= (addr != null) ? addr.getCity() : "N/A" %></td>
            <td><%= (addr != null) ? addr.getState() : "N/A" %></td>
            <td><%= (addr != null) ? addr.getZip() : "N/A" %></td>
            <td>
                <form action="deleteEmployee" method="post" onsubmit="return confirm('Are you sure you want to delete this employee?');">
                    <input type="hidden" name="id" value="<%= emp.getId() %>">
                    <button type="submit">Delete</button>
                </form>
<%--                <a href="editEmployee?id=<%= emp.getId() %>">--%>
<%--                    <button>Edit</button>--%>
<%--                </a>--%>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <div class="center">
        <a href="addEmployee.jsp">Add Employees</a>
    </div>
</div>
</body>
</html>
