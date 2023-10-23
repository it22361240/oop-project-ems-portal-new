package com.ems.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import com.ems.db.DatabaseConnection;

@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/UpdateUserServlet"})
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(userId);
        System.out.println(name);

        try {
            Connection conn = DatabaseConnection.getConnection();
            java.sql.PreparedStatement ps = conn.prepareStatement("UPDATE user_details SET Name=?, email=?, phone=?, username=?, password=? WHERE id=?;");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, Integer.parseInt(phone));
            ps.setString(4, username);
            ps.setString(5, password);
            ps.setInt(6, Integer.parseInt(userId));

            int count = ps.executeUpdate();

            conn.close();

            if (count > 0) {
                response.sendRedirect("./views/home.jsp?userId=" + userId);
                System.out.println("success");
            } else {
                response.sendRedirect("./views/home.jsp?userId=" + userId);
                System.out.println("fail");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error update");
        }
    }
}