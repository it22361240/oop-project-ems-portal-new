package com.ems.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ems.db.DatabaseConnection;

public class TaskDAO {
	private Connection connection;
	
	public TaskDAO(Connection connection) {
		this.connection = connection;
	}
	
	public int insertTask(Task task) {
		String insertQuery = "INSERT INTO Task (taskName) VALUES (?)";
		int generatedTaskId = -1;
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, task.getTaskName());
			preparedStatement.executeUpdate();
			
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				generatedTaskId = generatedKeys.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return generatedTaskId;
	}
}
