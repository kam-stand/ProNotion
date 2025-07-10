package Pronotion.web_server.controller;

import Pronotion.web_server.dto.TaskDto;
import Pronotion.web_server.model.Task;
import Pronotion.web_server.service.TaskService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    public final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("api/task")
    public ResponseEntity<?> getTasksByUserId(@RequestParam long userId) {
        List<Task> tasks = taskService.getTask(userId);

        if (tasks == null || tasks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tasks);
    }

    @PostMapping("api/task")
    public ResponseEntity<?> addTask(@RequestBody TaskDto taskDto) {
        Task task = new Task(
                taskDto.getName(),
                taskDto.getDescription(),
                taskDto.getUserId(),
                taskDto.getDueDate(),
                taskDto.getStatus());
        taskService.addTask(task);
        return ResponseEntity.ok().build();
    }
@PutMapping("api/task/{id}")
public ResponseEntity<?> updateTask(@PathVariable long id, @RequestBody TaskDto taskDto) {
    Task task = new Task();
    task.setId(id);
    task.setName(taskDto.getName());
    task.setDescription(taskDto.getDescription());
    task.setUser_id(taskDto.getUserId());
    task.setDue_date(taskDto.getDueDate());
    task.setStatus(taskDto.getStatus());

    boolean updated = taskService.updateTask(id, task);
    if (!updated) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }
    return ResponseEntity.ok("Task updated");
}


    @GetMapping("api/task/delete")
    public ResponseEntity<?> deleteTask(@RequestParam long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
