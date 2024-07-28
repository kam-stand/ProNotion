package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.dto.TaskDto;
import com.spring.model.Task;
import com.spring.model.User;
import com.spring.repository.TaskRepository;

import com.spring.repository.UserRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public TaskDto createTask(TaskDto taskDto) {
        Task task = new Task(taskDto.getTitle(), taskDto.getDescription(), taskDto.getDueDate(), taskDto.getStatus());
        taskRepository.save(task);
        return taskDto;
    }

    public TaskDto getTaskById(long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            return new TaskDto(task.getTitle(), task.getDescription(), task.getDueDate(), task.getStatus());
        }
        throw new IllegalArgumentException("Task not found");
    }

    public void addTask(TaskDto taskDto, long userId) {
        Task task = new Task(taskDto.getTitle(), taskDto.getDescription(), taskDto.getDueDate(), taskDto.getStatus());
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            task.setUser(user);
            taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

}
