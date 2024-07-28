package com.spring.dto;

import java.util.Date;

import com.spring.enums.Status;

public class TaskDto {

    private String title;

    private String description;

    private boolean completed = false;

    private Date dueDate;

    private Status status;

    public TaskDto() {
    }

    public TaskDto(String title, String description, Date dueDate, Status status) {

        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;

    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

}