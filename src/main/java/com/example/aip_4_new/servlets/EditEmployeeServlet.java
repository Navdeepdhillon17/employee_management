package com.example.aip_4_new.servlets;

import com.example.aip_4_new.dao.EmployeeDAO;
import com.example.aip_4_new.entity.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/editEmployee")
public class EditEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.getEmployee((long) id);

        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee.jsp");
        dispatcher.forward(request, response);  // ✅ Forward to edit page
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String department = request.getParameter("department");
            double salary = Double.parseDouble(request.getParameter("salary"));

            EmployeeDAO employeeDAO = new EmployeeDAO();
            Employee employee = employeeDAO.getEmployee((long) id);

            if (employee != null) {
                employee.setName(name);
                employee.setDepartment(department);
                employee.setSalary(salary);

                employeeDAO.updateEmployee(employee);
                System.out.println("✅ Employee updated successfully!"); // Debug message

                // Debugging the redirection
                System.out.println("🔄 Redirecting to: " + request.getContextPath() + "/index.jsp");

                response.sendRedirect(request.getContextPath() + "/index.jsp");
                return;
            } else {
                System.out.println("❌ Employee not found! Redirecting to edit page.");
                request.setAttribute("error", "Employee not found!");
                request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error occurred, forwarding to edit page.");
            request.setAttribute("error", "Invalid input or server error!");
            request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
        }
    }

}




