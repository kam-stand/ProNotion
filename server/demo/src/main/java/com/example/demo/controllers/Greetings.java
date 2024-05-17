package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Greetings {
    @GetMapping("/")
    public String greetings() {
        return ("Hello, World!");
    }
}