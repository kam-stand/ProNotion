package Pronotion.web_server.model;

import java.sql.Timestamp;

public class Task {

    long id;
    String name;
    String description;
    long user_id;
    private Timestamp due_date;

    public enum Status {
        Incomplete, Completed, InProgress
    }

    public Status status;

    public Task() {

    }

    public Task(long id, String name, String description, long user_id, Timestamp due_date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user_id = user_id;
        this.due_date = due_date;
        this.status = Status.Incomplete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public Timestamp getDue_date() {
        return due_date;
    }

    public void setDue_date(Timestamp due_date) {
        this.due_date = due_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String status) {
        switch (status.toLowerCase()) {
            case "incomplete":
                this.status = Status.Incomplete;
                break;
            case "completed":
                this.status = Status.Completed;
                break;
            case "inprogress":
                this.status = Status.InProgress;
                break;
            default:
                throw new IllegalArgumentException("Invalid status: " + status);
        }
    }
}
