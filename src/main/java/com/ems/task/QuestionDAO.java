package com.ems.task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ems.db.DatabaseConnection;

public class QuestionDAO {
    private Connection connection = DatabaseConnection.getConnection();

    public void insertQuestion(Question question) throws SQLException {
        String queryQuestion = "INSERT INTO Question (question, cAnswer, taskId, marks) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(queryQuestion, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.setInt(2, question.getCAnswer());
            preparedStatement.setInt(3, question.getTaskId());
            preparedStatement.setInt(4, question.getMarks());
            preparedStatement.executeUpdate();
            
            ResultSet generatedKey = preparedStatement.getGeneratedKeys();
            if (generatedKey.next()) {
            	int lastQId = generatedKey.getInt(1);
            	question.setQuestionId(lastQId);
            }
        }
        
        catch (SQLException e) {
        	System.out.println("Error inserting to questions");
        }
    }
}
