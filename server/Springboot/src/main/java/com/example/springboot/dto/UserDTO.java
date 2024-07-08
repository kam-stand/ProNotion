package com.example.springboot.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    public UserDTO() {

    }

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private List<Long> task_id = new ArrayList<>();


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public List<Long> getTask_id() {
        return task_id;
    }
    public void setTask_id(List<Long> task_id) {
        this.task_id = task_id;
    }
}
