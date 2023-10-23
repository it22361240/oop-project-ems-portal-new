package com.ems.task;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    //private String answers[];
    private int cAnswer;
    private int marks;
    private int taskId;
    private int qId;
    private List<String> answers = new ArrayList<>();

    public void setQuestion(String question, int cAnswer, int marks, int taskId) {
    	this.question = question;
    	this.cAnswer = cAnswer;
    	this.marks = marks;
    	this.taskId = taskId;
    }
        
    public int getCAnswer() {
    	return cAnswer;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
    
    public List<String> getAnswers() {
        return answers;
    }
    
    public void addAnswer(String answer) {
        this.answers.add(answer);
    }

    /*public void setAnswer(String[] answers) {
    	if (answers.length == 4) {
    		this.answers = answers;
    	}
    	else {
            throw new IllegalArgumentException("Answers array must contain exactly 4 elements.");
        }
    }
 
    public String[] getAnswer() {
        return answers;
    }  */  

    public int getMarks() {
    	return marks;
    }
    
    public int getTaskId() {
        return taskId;
    }

	public void setQuestionId(int lastQId) {
		this.qId = lastQId;		
	}
	
	public int getQuestionId() {
		return qId;
	}
}
