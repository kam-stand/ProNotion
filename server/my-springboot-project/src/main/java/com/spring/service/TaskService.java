package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.TaskDto;
import com.spring.model.Task;
import com.spring.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskDto createTask(TaskDto taskDto) {
        Task task = new Task(taskDto.getTitle(), taskDto.getDescription(), taskDto.getDueDate(), taskDto.getStatus());
        taskRepository.save(task);
        return taskDto;
    }

}
