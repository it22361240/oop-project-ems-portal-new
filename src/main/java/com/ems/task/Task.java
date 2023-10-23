package com.ems.task;

//import java.sql.Timestamp;

public class Task {
    private int taskId;
    private String taskName;
    //private Timestamp expireTime;
    private int userId;
    private int qCount;
    
    // Task Name
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    
    public String getTaskName() {
        return taskName;
    }
    
    // User Id
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getUserId() {
        return userId;
    }

    // Task Id
    public void setTaskId(int taskId) {
    	this.taskId = taskId;
    }
    
    public int getTaskId() {
        return taskId;
    }
    
    // qCount
    public void setCount(int qCount) {
    	this.qCount = qCount;
    }
    
    public int getCount() {
    	return qCount;
    }
    
    /*public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }*/
}
