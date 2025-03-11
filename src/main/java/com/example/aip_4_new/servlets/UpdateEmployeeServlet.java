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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            String name = request.getParameter("name");
            String department = request.getParameter("department");
            String salaryStr = request.getParameter("salary");

            // ✅ Check if salary is null/empty before parsing
            double salary = 0.0;
            if (salaryStr != null && !salaryStr.trim().isEmpty()) {
                salary = Double.parseDouble(salaryStr);
            }

            // ✅ Get address fields properly
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");

            EmployeeDAO employeeDAO = new EmployeeDAO();
            Employee employee = employeeDAO.getEmployee(id);

            if (employee != null) {
                employee.setName(name);
                employee.setDepartment(department);
                employee.setSalary(salary);

                // ✅ Ensure Address is updated properly
                Address address = employee.getAddress();
                if (address == null) {
                    address = new Address();
                }
                address.setStreet(street);
                address.setCity(city);
                address.setState(state);
                address.setZip(zip);

                employee.setAddress(address);
                employeeDAO.updateEmployee(employee);
            }

            // ✅ Redirect back to index.jsp after updating
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to error page in case of an exception
        }
    }
}
