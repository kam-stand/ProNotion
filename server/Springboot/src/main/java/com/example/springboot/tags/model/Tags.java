package com.example.springboot.tags.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import com.example.springboot.task.model.Task;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tag_id;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String tag_name;

    @ManyToMany(mappedBy = "tags")
    private List<Task> tasks;

    public Tags() {
    }

    public Tags(String tag_name, List<Task> tasks) {
        this.tag_name = tag_name;
        this.tasks = tasks;
    }

    // getters and setters
    public long getTag_id() {
        return tag_id;
    }

    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Tags [tag_id=" + tag_id + ", tag_name=" + tag_name + ", tasks=" + tasks + "]";
    }

}