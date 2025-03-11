package com.example.aip_4_new.servlets;

import com.example.aip_4_new.dao.EmployeeDAO;
import com.example.aip_4_new.entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listEmployees")
public class ListEmployeesServlet extends HttpServlet {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeDAO.getAllEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("listEmployees.jsp").forward(request, response);
    }
}
