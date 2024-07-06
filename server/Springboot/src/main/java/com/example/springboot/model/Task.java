package com.example.springboot.model;
import com.example.springboot.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;


import java.util.Date;

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

    @Column
    @Enumerated(EnumType.STRING)
    @Value("notStarted")
    private Status status;


    @Column
    @CreationTimestamp
    private Date createDate;

    @Column
    @UpdateTimestamp
    private Date dueDate;

    @Column
    private String owner;





}
