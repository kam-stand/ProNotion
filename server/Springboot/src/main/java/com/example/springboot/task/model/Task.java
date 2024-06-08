// creating the task model: body, owned_by, dueDate,

package com.example.springboot.task.model;
import com.example.springboot.user.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long task_Id;
    private String Title;
    private String Description;
    private String Body;
    private Date CreateDate;
    private Date dueDate;
//    private User createdBy;
//    private String [] tags;
//    public List<User> assignees;

    public Task(){
        // empty constructor
    }

    Task(String title, String body, Date dueDate, User createdBy, String[] tags){
        this.Title = title;
        this.Description = body;
        this.dueDate = dueDate;


    }


}