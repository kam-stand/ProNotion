package com.example.springboot.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.task.model.Task;
import com.example.springboot.task.services.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.user.model.User;
import java.util.List;

@RestController
@RequestMapping(path = "task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping(path = "/getAll")
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @PostMapping(path = "/newTask")
    public Task newTask(@RequestBody Task task) {
        if (task.getBody() == null || task.getOwned_by() == null || task.getDueDate() == null) {
            return null;
        } else {
            return taskService.save(task);
        }

    }

    @GetMapping(path = "/getById")
    public Task getTaskById(@RequestParam("id") Long id) {
        for (Task task : taskService.findAll()) {
            if (task.getTask_Id() == id) {
                return task;
            }
        }
        return null;
    }

    @GetMapping(path = "/getAssignedTo")
    public List<User> getAssignedTo(@RequestParam long id) {
        for (Task task : taskService.findAll()) {
            if (task.getTask_Id() == id) {
                return task.getAssigned_to();
            }
        }
        return null;
    }

}