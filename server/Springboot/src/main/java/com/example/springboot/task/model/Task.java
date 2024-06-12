package com.example.springboot.task.model;

import jakarta.persistence.*;

import java.net.URL;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.example.springboot.tags.model.Tags;
import com.example.springboot.user.model.User;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long task_Id;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Lob
    private String body;

    @Column(nullable = true, columnDefinition = "DATE")
    private Date dueDate;

    @OneToMany(mappedBy = "tag_id")
    private List<Tags> tags;

    @ManyToOne
    @JoinColumn(name = "user_ID")
    private User owned_by;

    @ManyToMany
    @JoinTable(name = "task_user", joinColumns = @JoinColumn(name = "task_Id"), inverseJoinColumns = @JoinColumn(name = "user_ID"))
    private List<User> assigned_to;

    @Column(nullable = true, columnDefinition = "TEXT")
    @Value("null")
    private URL url;

    public Task() {
    }

    // Constructor
    public Task(String body, List<Tags> tags, User owned_by, List<User> assigned_to, Date dueDate) {
        this.body = body;
        this.tags = tags;
        this.owned_by = owned_by;
        this.assigned_to = assigned_to;
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

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
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
