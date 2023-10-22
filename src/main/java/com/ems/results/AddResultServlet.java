package com.ems.results;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ems.db.DatabaseConnection;

@WebServlet(name = "AddResultServlet", urlPatterns = {"/AddResultServlet"})
public class AddResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentID = request.getParameter("studentID");
        String studentName = request.getParameter("studentName");
        String subject = request.getParameter("subject");
        int marks = Integer.parseInt(request.getParameter("marks"));

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        try {
        	// Establish a database connection

            // Insert the result into the database
            String sql = "INSERT INTO results (student_id, student_name, subject, marks) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);
            stmt.setString(2, studentName);
            stmt.setString(3, subject);
            stmt.setInt(4, marks);
            stmt.executeUpdate();

            // Redirect to the results page after adding the result
            response.sendRedirect("./views/results/results.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


