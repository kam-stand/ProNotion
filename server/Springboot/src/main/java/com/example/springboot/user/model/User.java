package com.example.springboot.user.model;

import jakarta.persistence.*;

import java.util.Date;

import com.example.springboot.task.model.Task;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.example.springboot.roles.Role;
import com.example.springboot.roles.Membership;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_ID;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = false, nullable = false)
    private String phone;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String teamName;

    @Column(nullable = false)
    @Value("CURRENT_TIMESTAMP")
    private Date created_at;
    @Column(nullable = true)
    private Date updated_at;

    @Value("USER")
    @Column(nullable = true, columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Value("BASIC")
    @Column(nullable = true, columnDefinition = "VARCHAR(50)")
    @Enumerated(EnumType.STRING)
    private Membership membership;

    @OneToMany(mappedBy = "owned_by")
    private List<Task> tasks;

    @ManyToMany(mappedBy = "assigned_to")
    private List<Task> assigned_tasks;

    public User() {
        // No argument constructor
    }

    // constructor
    public User(String username, String password, String email, String phone, String name, String teamName,
            Date created_at, Date updated_at, Role role, Membership membership, List<Task> tasks,
            List<Task> assigned_tasks) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.teamName = teamName;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.role = role;
        this.membership = membership;
        this.tasks = tasks;
        this.assigned_tasks = assigned_tasks;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(long user_ID) {
        this.user_ID = user_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getAssigned_tasks() {
        return assigned_tasks;
    }

    public void setAssigned_tasks(List<Task> assigned_tasks) {
        this.assigned_tasks = assigned_tasks;
    }

}
