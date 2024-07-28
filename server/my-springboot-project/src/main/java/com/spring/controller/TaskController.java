package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.TaskDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<?> PostTask(@RequestBody List<TaskDto> taskDto) {
        try {
            for (TaskDto task : taskDto) {
                taskService.createTask(task);
            }
            return ResponseEntity.ok("Task created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating task");
        }

    }

    // assigning tasks to users
    @PostMapping("/assign")
    public ResponseEntity<?> assignTask(@RequestBody List<TaskDto> taskDtos, @RequestParam long userId) {
        try {
            for (TaskDto taskDto : taskDtos) {
                taskService.addTask(taskDto, userId);
            }
            return ResponseEntity.ok("Tasks assigned successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error assigning tasks");
        }
    }

}
