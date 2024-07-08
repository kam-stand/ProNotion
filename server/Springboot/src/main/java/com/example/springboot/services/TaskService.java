

package com.example.springboot.services;

import com.example.springboot.dto.TaskDTO;
import com.example.springboot.model.Tags;
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

    @Autowired
    private TagsService tagsService;


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);

    }

    public Task assignTaskToUser(Long taskID, List<Long> userIds) {
        Task task = getTaskById(taskID);
        List<User> users = new ArrayList<>();
        for (Long userId : userIds) {
            User user = userService.getUserById(userId);
            users.add(user);
        }
        task.setAssigned_to(users);
        return taskRepository.save(task);

    }

    public Task postTask(TaskDTO taskDTO){
        Task task = new Task();
        User user = userService.getUserById(taskDTO.getUserID());
        task.setOwner(user);
        task.setDescription(taskDTO.getDescription());
        task.setTitle(taskDTO.getTitle());
        // convert the long userIDs to actual user objects
        List<User> users  = new ArrayList<>();
        for(Long id : taskDTO.getAssigned_to()){
            users.add(userService.getUserById(id));
        }
        List<Tags> tags = new ArrayList<>();
        for(String tag : taskDTO.getTags()){
            Tags tagObj = new Tags();
            tagObj.setTag_name(tag);
            tagsService.createTags(tagObj);
            tags.add(tagObj);
        }
        task.setTags(tags);
        task.setAssigned_to(users);
        taskRepository.save(task);
        return task;

    }



}