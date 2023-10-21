package com.ems.essay;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ems.db.DatabaseConnection;



@MultipartConfig
@WebServlet(name = "DisplayServlet", urlPatterns = {"/DisplayServlet"})
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("In do post method of Display Image servlet.");
		String imageId = request.getParameter("imageId");
		int id = Integer.parseInt(imageId);
		
		Connection conn = DatabaseConnection.getConnection();
		
		int imgId = 0;
		String imgFileName = null;
		try {
			Statement stmt;
			String query = "Select * from Images;";
			stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			
			while (rs.next()) {
				if(rs.getInt("imageId") == id) {
					imgId = rs.getInt("imageId");
					imgFileName = rs.getString("imageFileName");
				}
			}
			
		} catch (Exception e) {
			// Handle exceptions related to database connection and query execution
			System.out.println(e);
		}
		try {
			
		RequestDispatcher rd;
		request.setAttribute("id", imgId);
		request.setAttribute("img", imgFileName);
		rd = request.getRequestDispatcher ("../displayImages.jsp");
		rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error occur");
			System.out.println(e);
		}
	}

}
