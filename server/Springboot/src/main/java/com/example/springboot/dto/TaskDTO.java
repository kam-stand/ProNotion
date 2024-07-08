package com.example.springboot.dto;

import java.util.List;

public class TaskDTO {
    public TaskDTO (){

    }

    private String title;
    private String description;
    private Long userID;
    private String status;

    private List<String> tags;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Long> getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(List<Long> assigned_to) {
        this.assigned_to = assigned_to;
    }

    private List<Long> assigned_to;

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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
