package com.example.aip_4_new.servlets;

import com.example.aip_4_new.dao.EmployeeDAO;
import com.example.aip_4_new.entity.Employee;
import com.example.aip_4_new.entity.Address;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String department = request.getParameter("department");

        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.getEmployee((long) id);

        employee.setName(name);
        employee.setDepartment(department);

        employeeDAO.updateEmployee(employee);
        response.sendRedirect("index.jsp");
    }
}

