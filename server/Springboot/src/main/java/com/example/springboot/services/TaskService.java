

package com.example.springboot.services;

import com.example.springboot.model.Task;
import com.example.springboot.model.User;
import com.example.springboot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task createTask(Task task, long id) {
        User user = userService.getUserById(id);
        if(user == null) {
            return null;
        }
        task.setOwner(user);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);

    }

    public Task assignTaskToUser(List<Long> userID, long taskID) {
        Task task = taskRepository.findById(taskID).orElse(null);
        if(task == null){
            return null;
        }
        List<User> assigned_to = new ArrayList<>();
        for(long userId : userID){
            assigned_to.add(userService.getUserById(userId));
        }
        task.setAssigned_to(assigned_to);
        taskRepository.save(task);
        return task;
    }



}