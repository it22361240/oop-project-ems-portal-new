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

@WebServlet(name = "AddRecorrectionServlet", urlPatterns = {"/AddRecorrectionServlet"})

public class AddRecorrectionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String studentID = req.getParameter("studentID");
		String subject = req.getParameter("subject");
		
		// database connection
		Connection conn = DatabaseConnection.getConnection();
		
		PreparedStatement stmt = null;
		try {
			// Insert the re correction into the database
			String query = "INSERT INTO recorrections (student_id, subject) VALUES (?, ?);";
			
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, studentID);
			stmt.setString(2, subject);
			
			stmt.executeUpdate();
			// Redirect to the re correction page after adding the re correction
			resp.sendRedirect("./views/results/recorrections.jsp");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
}
