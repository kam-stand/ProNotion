package com.example.springboot.event.model;

import jakarta.persistence.Entity;
import java.util.Date;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long event_id;

    private String Title;
    private String Description;
    private Date date;

    public Event() {
    }

    public Event(String title, String description, Date time) {
        this.Title = title;
        this.Description = description;
        this.date = time;
    }

    public long getId() {
        return event_id;
    }

    public void setId(long id) {
        this.event_id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getTime() {
        return date;
    }

    public void setTime(Date time) {
        this.date = time;
    }

}