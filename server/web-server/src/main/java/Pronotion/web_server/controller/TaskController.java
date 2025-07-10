package Pronotion.web_server.controller;

import Pronotion.web_server.model.Task;
import Pronotion.web_server.service.TaskService;
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
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return ResponseEntity.ok().build();
    }

    @PostMapping("api/task/{id}")
    public ResponseEntity<?> updateTask(@PathVariable long id, @RequestBody Task task) {
        taskService.updateTask(id, task);
        return ResponseEntity.ok().build();
    }

    @GetMapping("api/task/delete")
    public ResponseEntity<?> deleteTask(@RequestParam long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
