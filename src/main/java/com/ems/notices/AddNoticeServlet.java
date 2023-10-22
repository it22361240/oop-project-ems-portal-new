package com.ems.notices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ems.db.DatabaseConnection;

@WebServlet(name = "AddNoticeServlet", urlPatterns = {"/AddNoticeServlet"})
public class AddNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        try {
        	// Establish a database connection
            Connection conn = DatabaseConnection.getConnection();

            String insertQuery = "INSERT INTO notices (title, content) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.executeUpdate();
            conn.close();

            response.sendRedirect("./views/notices/notices.jsp"); // Redirect to a page showing all notices.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
