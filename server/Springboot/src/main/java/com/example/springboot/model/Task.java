package com.example.springboot.model;
import com.example.springboot.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    @Value("notStarted")
    private Status status = Status.notStarted;

    public List<User> getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(List<User> assigned_to) {
        this.assigned_to = assigned_to;
    }

    @Column
    @CreationTimestamp
    private Date createDate;

    @Column(nullable =true)
    @UpdateTimestamp
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

   @ManyToMany
   @JoinTable(
           name = "user_task",
           joinColumns= @JoinColumn(name = "task_id"),
           inverseJoinColumns = @JoinColumn(name = "user_id")
   )
   private List<User> assigned_to = new ArrayList<>();

   public Task() {

   }


    public Task(String title, String description, Status status, Date createDate, Date dueDate, User owner) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.owner = owner;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    public Long getId() {
        return id;
    }
}
