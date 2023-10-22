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

@WebServlet(name = "DeleteResultServlet", urlPatterns = {"/DeleteResultServlet"})
public class DeleteResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentID = request.getParameter("studentID");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
        	// Establish a database connection
            conn = DatabaseConnection.getConnection();

            // Delete the result from the database
            String sql = "DELETE FROM results WHERE student_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);
            stmt.executeUpdate();

            // Redirect to the results page after deleting the result
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
