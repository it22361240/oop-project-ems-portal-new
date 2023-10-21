package com.ems.essay;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ems.db.DatabaseConnection;

//@WebServlet("/AddImageServlet")
@WebServlet(name = "AddImageServlet", urlPatterns = {"/AddImageServlet"})
@MultipartConfig
public class AddImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "/project/src/main/webapp/views/Image/UploadedPhotos"; // Update with your directory path

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Part filePart = request.getPart("file");
            String fileName = getSubmittedFileName(filePart);

            if (fileName != null && !fileName.isEmpty()) {
                try (InputStream fileContent = filePart.getInputStream();
                	Connection conn = DatabaseConnection.getConnection();
                     PreparedStatement stmt = conn.prepareStatement("INSERT INTO images (image_data) VALUES (?)")) {

                    stmt.setBinaryStream(1, fileContent);

                    stmt.executeUpdate();
                    // Close the database connection
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.sendRedirect("error.jsp"); // Handle database error
                    return;
                }

                response.sendRedirect("success.jsp"); // Redirect to success page
            } else {
                response.sendRedirect("error.jsp"); // Handle cases where no file was submitted
            }
            
        } catch (IOException | ServletException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Handle other exceptions
        }
    }

    private String getSubmittedFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}