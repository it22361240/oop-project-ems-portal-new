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


@WebServlet(name = "DeleteRecorrectionServlet", urlPatterns = {"/DeleteRecorrectionServlet"})
public class DeleteRecorrectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentID = request.getParameter("studentID");
        String subject = request.getParameter("subject");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Connect to the database
            conn = DatabaseConnection.getConnection();
            // Delete the recorrection proposal from the database
            String sql = "DELETE FROM recorrections WHERE student_id = ? AND subject = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);
            stmt.setString(2, subject);
            stmt.executeUpdate();

            // Redirect to the recorrections page after deleting the proposal
            response.sendRedirect("/project/views/results/teacherRecorrection.jsp");
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

