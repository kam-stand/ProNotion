package com.spring.dto;

import com.spring.enums.Priority;

public class Eventdto {
    private String name;
    private Priority priority;

    public Eventdto() {
    }

    public Eventdto(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

}
