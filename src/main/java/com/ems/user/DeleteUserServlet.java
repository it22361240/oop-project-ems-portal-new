package com.ems.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ems.db.DatabaseConnection;

@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/DeleteUserServlet"})
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String userId;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests (e.g., to retrieve user information)
        // ...
    	 this.userId = request.getParameter("userId");
         System.out.println(this.userId);
         this.doDelete(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            // Establish a database connection
            Connection conn = DatabaseConnection.getConnection();

            // Perform user account deletion
            PreparedStatement deleteUser = conn.prepareStatement("DELETE FROM user_details WHERE id = ?");
            deleteUser.setInt(1, Integer.parseInt(this.userId));
            //deleteUser.setInt(1, 4);
            int count = deleteUser.executeUpdate();

            if (count > 0) {
                // User account deletion was successful
                // You can return a success response code (e.g., 200)
                response.setStatus(HttpServletResponse.SC_OK);
                System.out.println("success");
                String s = "delete success";
                response.sendRedirect("./views/users/accountDeleted.jsp?status=" + s);
            } else {
                // User account deletion was unsuccessful
                // You can return an error response code (e.g., 400 or 500)
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                System.out.println("fail");
                String s = "fail to delete";
                response.sendRedirect("./views/users/accountDeleted.jsp?status=" + s);
            }

            // Close the database connection
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception");
        }
    }
}
