package com.ems.notices;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.ems.db.DatabaseConnection;

@WebServlet(name = "DeleteNoticeServlet", urlPatterns = {"/DeleteNoticeServlet"})
public class DeleteNoticeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        // Database connection
        Connection conn = null ;
       
        PreparedStatement pstmt = null;
        try {
        	conn = DatabaseConnection.getConnection();

            // SQL Delete Statement
            String query = "DELETE FROM notices WHERE id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Redirect to a page showing all notices
        response.sendRedirect("./views/notices/notices.jsp");
    }
}

