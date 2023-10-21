package com.ems.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ems.db.DatabaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddTaskServlet", urlPatterns = {"/AddTaskServlet"})
public class AddTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskName = request.getParameter("taskName");
        String question1 = request.getParameter("question1");
        int marks1 = Integer.parseInt(request.getParameter("marks1"));
        String question2 = request.getParameter("question2");
        int marks2 = Integer.parseInt(request.getParameter("marks2"));
        
        try {
            // Establish a database connection
            Connection conn = DatabaseConnection.getConnection();
            
            // Insert the task data into the database
            String insertTaskQuery = "INSERT INTO Task (task_name) VALUES (?)";
            PreparedStatement taskStmt = conn.prepareStatement(insertTaskQuery);
            taskStmt.setString(1, taskName);
            taskStmt.executeUpdate();
            
            // Insert the question and marks data into the database
            String insertMarksQuery = "INSERT INTO Marks (question, marks) VALUES (?, ?)";
            PreparedStatement marksStmt = conn.prepareStatement(insertMarksQuery);
            marksStmt.setString(1, question1);
            marksStmt.setInt(2, marks1);
            marksStmt.executeUpdate();
            
            marksStmt.setString(1, question2);
            marksStmt.setInt(2, marks2);
            marksStmt.executeUpdate();
            
            // Close the database connection
            DatabaseConnection.closeConnection(conn);
            
            // Redirect to a success page
            response.sendRedirect("./views/tasks/addtask.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the database error
            response.sendRedirect("./views/tasks/addtask.jsp");
        }
    }
}
