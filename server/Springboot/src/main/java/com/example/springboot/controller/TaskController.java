package com.example.springboot.controller;
import com.example.springboot.model.Task;
import com.example.springboot.services.TaskService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/getTasks")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(taskService.getAllTasks());
    }

    @PostMapping("/postTask")
    public ResponseEntity<Task> postTask(@RequestBody Task task, @RequestParam long userId) {
        try {
            Task createdTask = taskService.createTask(task, userId);

            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/assignTask")
    public ResponseEntity<Task> assignTask(@RequestParam long taskId, @RequestParam List<Long> userId) {
        Task assignedTask = taskService.assignTaskToUser(userId, taskId);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}