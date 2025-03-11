package com.example.aip_4_new.servlets;


import com.example.aip_4_new.dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        employeeDAO.deleteEmployee(id);
        response.sendRedirect("index.jsp"); // Redirect back to employee list
    }
}
