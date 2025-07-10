package Pronotion.web_server.dto;
import java.sql.Timestamp;

public class TaskDto {

    String name;
    String description;
    long userId;
    Timestamp dueDate;
    String status;

    public TaskDto() {

    }
    public TaskDto(String name, String description, long userId, Timestamp dueDate, String status) {
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.dueDate = dueDate;
        this.status = status;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus(){return status;}

    public void setStatus(String status)
    {
        this.status = status;
    }
}
