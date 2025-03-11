//package com.example.aip_4_new.servlets;
//
//import com.example.aip_4_new.dao.EmployeeDAO;
//import com.example.aip_4_new.entity.Employee;
//import com.example.aip_4_new.entity.Address;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/addEmployee")
//public class AddEmployeesServlet extends HttpServlet {
//
//    private final EmployeeDAO employeeDAO = new EmployeeDAO();
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String department = request.getParameter("department");
//        double salary = Double.parseDouble(request.getParameter("salary"));
//
//        String street = request.getParameter("street");
//        String city = request.getParameter("city");
//        String state = request.getParameter("state");
//        String zip = request.getParameter("zip");
//
//        Address address = new Address(street, city, state, zip);
//        Employee employee = new Employee(name, department, salary, address);
//
//        employeeDAO.addEmployee(employee);
//        response.sendRedirect("listEmployees");
//    }
//}
package com.example.aip_4_new.servlets;

import com.example.aip_4_new.dao.EmployeeDAO;
import com.example.aip_4_new.entity.Address;
import com.example.aip_4_new.entity.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addEmployee")
public class AddEmployeesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String department = request.getParameter("department");  // Get department from form
        String salaryStr = request.getParameter("salary");

        if (name == null || name.trim().isEmpty() || department == null || department.trim().isEmpty() ||
                salaryStr == null || salaryStr.trim().isEmpty()) {
            request.setAttribute("error", "All fields are required!");
            request.getRequestDispatcher("add_employee.jsp").forward(request, response);
            return;
        }

        double salary;
        try {
            salary = Double.parseDouble(salaryStr.trim());
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid salary format!");
            request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
            return;
        }

        // Get address fields from form
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        Address address = new Address(street, city, state, zip); // Create Address object

        // ✅ Correct constructor: name, department, salary, address
        Employee employee = new Employee(name.trim(), department.trim(), salary, address);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(employee); // Save Employee (Address is inside Employee)

        response.sendRedirect("index.jsp");
    }
}


