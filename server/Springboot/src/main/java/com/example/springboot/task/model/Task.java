package com.example.springboot.task.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.example.springboot.user.model.User;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long task_Id;

    private String body;
    private String[] tags;
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owned_by;

    @ManyToMany
    @JoinTable(name = "task_assigned_users", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> assigned_to;

    public Task() {
    }

    public Task(String body, String[] tags, User owned_by, List<User> assigned_to, Date dueDate) {
        this.body = body;
        this.tags = tags;
        this.owned_by = owned_by;
        this.assigned_to = assigned_to;
        this.dueDate = dueDate;
    }

    public Task(String body, User owned_by, Date dueDate) {
        this.body = body;
        this.owned_by = owned_by;
        this.dueDate = dueDate;
    }

    // Getters and setters

    public long getTask_Id() {
        return task_Id;
    }

    public void setTask_Id(long task_Id) {
        this.task_Id = task_Id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public User getOwned_by() {
        return owned_by;
    }

    public void setOwned_by(User owned_by) {
        this.owned_by = owned_by;
    }

    public List<User> getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(List<User> assigned_to) {
        this.assigned_to = assigned_to;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task [body=" + body + ", dueDate=" + dueDate + ", owned_by=" + owned_by + ", tags=" + tags
                + ", task_Id=" + task_Id + "]";
    }
}
