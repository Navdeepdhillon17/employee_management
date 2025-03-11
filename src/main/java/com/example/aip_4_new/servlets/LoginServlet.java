package com.example.aip_4_new.servlets;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "password".equals(password)) { // Dummy authentication
            HttpSession session = request.getSession(); // Create session
            session.setAttribute("user", username); // Store user in session
            response.sendRedirect("index.jsp"); // Redirect to index page after login
        } else {
            response.sendRedirect("login.jsp?error=1"); // Redirect back with error
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp"); // Redirect to login page if accessed via GET
    }
}
