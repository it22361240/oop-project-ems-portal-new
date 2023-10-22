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

@WebServlet(name = "UpdateNoticeServlet", urlPatterns = {"/UpdateNoticeServlet"})
public class UpdateNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // Database connection
        Connection conn = DatabaseConnection.getConnection();
        
        // SQL Update Statement
        String query = "UPDATE notices SET title = ?, content = ? WHERE id = ?";
        PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
			
			// Close PreparedStatement and Connection
			pstmt.close(); 
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Redirect to a page showing all notices
        response.sendRedirect("./views/notices/notices.jsp");
    }
}


