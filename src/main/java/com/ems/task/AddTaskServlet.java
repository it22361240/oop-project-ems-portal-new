package com.ems.task;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AddTaskServlet", urlPatterns = {"/AddTaskServlet"})
public class AddTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve data from the JSP form
            String taskName = request.getParameter("taskName");
            int userId = 1;
            int qCount = Integer.parseInt(request.getParameter("qCount"));

            // Create a Task object and insert it into the Task table
            Task task = new Task();
            task.setTaskName(taskName);
            task.setUserId(userId);
            task.setCount(qCount);

            TaskDAO taskDAO = new TaskDAO(); // Initialize TaskDAO with a database connection
            taskDAO.insertTask(task);
            
            int taskId = task.getTaskId();

            // Loop to retrieve and insert Marks data from the JSP form
            for (int i = 0; i < qCount; i++) {
                String question = request.getParameter("question" + (i + 1));
                int cAnswer = Integer.parseInt(request.getParameter("cAnswer" + (i + 1)));
                int marks = Integer.parseInt(request.getParameter("mark" + (i + 1)));
                
                Question questionC = new Question();
                questionC.setQuestion(question, cAnswer, marks, taskId);

                QuestionDAO questionDAO = new QuestionDAO(); // Initialize MarksDAO with a database connection
                questionDAO.insertQuestion(questionC);
                
                //int questionId = questionC.getQuestionId();

                // Set answers
                List<String> answersList = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                	answersList.add(request.getParameter("ans" + (j + 1)));
                }
                questionC.setAnswers(answersList);
                List<String> retrievedAnswers = questionC.getAnswers();
                for (String answer : retrievedAnswers) {
                    System.out.println(answer);
                }
            }

            // Set a success attribute for your JSP to display the success modal
            request.setAttribute("success", true);

            // Forward the request to your JSP page
            RequestDispatcher dispatcher = request.getRequestDispatcher("./viewMCQ.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(); // Handle database exceptions appropriately
        }
    }
}
