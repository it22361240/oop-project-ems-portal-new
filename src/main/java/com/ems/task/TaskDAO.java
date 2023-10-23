package com.ems.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ems.db.DatabaseConnection;

public class TaskDAO {
    private Connection conn = DatabaseConnection.getConnection();

    public void insertTask(Task task) throws SQLException {
        String query = "INSERT INTO Task (task_name, userId, questionCount) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, task.getTaskName());
            preparedStatement.setInt(2, task.getUserId());
            preparedStatement.setInt(3, task.getCount());
            preparedStatement.executeUpdate();

            ResultSet generatedKey = preparedStatement.getGeneratedKeys();
            if (generatedKey.next()) {
                int lastId = generatedKey.getInt(1);
                task.setTaskId(lastId);
            }
        }
        catch (SQLException e) {
        	System.out.println("Error inserting to task");
        }
    }
}
