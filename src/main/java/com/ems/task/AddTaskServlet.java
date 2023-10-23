package com.ems.task;

import java.io.IOException;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ems.db.DatabaseConnection;

//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddTaskServlet", urlPatterns = {"/AddTaskServlet"})
public class AddTaskServlet extends HttpServlet {
	
	// Method for get values from JSP
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	// Input values assign to the variables
    	String taskName = request.getParameter("taskName");
    	boolean status = false;

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Establish a database connection
        	TaskDAO taskDAO = new TaskDAO(conn);
        	
        	Task task = new Task();
        	task.setTaskName(taskName);
        	
        	int taskId = taskDAO.insertTask(task);
        	
        	if (taskId > 0) {
        		// Data insertion successful
        		//response.sendRedirect("./views/tasks/mcq/viewMCQ.jsp");
        		status = true;
        	}
        	else {
        		// Data insertion Unsuccessful
        		//response.sendRedirect("error.jsp");
        		status = false;
        	}
        }
        catch (SQLException e) {
        	e.printStackTrace();
        	System.out.println("Error in insertion");
        	status = false;
        }
        
        request.setAttribute("success", status);
    }
}
