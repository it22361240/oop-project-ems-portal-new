package com.ems.essay;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import com.ems.db.DatabaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "AddImageServlet", urlPatterns = {"/AddImageServlet"})
public class AddImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddImageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Default doGet method implementation
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Handle image upload in the doPost method
		
		System.out.println("In do post method of Add Image servlet.");
		Part file = request.getPart("image");
		
		String imageFileName = file.getSubmittedFileName();  // Get the selected image file name
		System.out.println("Selected Image File Name : " + imageFileName);
		
		// Define the upload path where we will save the uploaded image
		String uploadPath = "oop-project-ems-portal-new/src/main/webapp/views/Image/UploadedImages/" + imageFileName;
		System.out.println("Upload Path : " + uploadPath);
		
		// Uploading the selected image into the specified folder
		try {
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();
			
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			
		} catch (Exception e) {
			// Handle exceptions related to file upload
			e.printStackTrace();
		}
		
		// Establish a database connection and insert image information
		
		Connection conn = DatabaseConnection.getConnection();
		
		try {
			PreparedStatement stmt;
			String query = "INSERT INTO Images(imageFileName) VALUES(?)";
			

//CREATE TABLE Images (
//    id INT AUTO_INCREMENT PRIMARY KEY,
//    imageFileName VARCHAR(255) NOT NULL
//);
			
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, imageFileName);
			int rowsAffected = stmt.executeUpdate(); // Number of rows affected by the insert query
			
			conn.close();
			if (rowsAffected > 0) {
				System.out.println("Image added into the database successfully.");
			} else {
				System.out.println("Failed to upload the image or update the database.");
			}
			
		} catch (Exception e) {
			// Handle exceptions related to database connection and query execution
			System.out.println(e);
		}
	}
}