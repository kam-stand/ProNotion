
package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class post_method {
    @PostMapping("post")
    public String PostMapping(@RequestBody String name, String email) {
        // creating an object of entity class
        entity entity = new entity(name, email);
        return ("POST request received" + entity.getName() + " " + entity.getEmail());
    }

}