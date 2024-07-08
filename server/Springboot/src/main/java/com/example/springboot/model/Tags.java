package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tags")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tag_id;

    @Column(nullable = true, length=200, unique=true, updatable=true)
    private String tag_name;

    public Tags(){

    }

    public Tags(String tag_name) {
        this.tag_name = tag_name;
    }
    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
    public String getTag_name() {
        return tag_name;
    }
    public Long getTag_id() {
        return tag_id;
    }
    public void setTag_id(Long tag_id) {
        this.tag_id = tag_id;
    }

}
