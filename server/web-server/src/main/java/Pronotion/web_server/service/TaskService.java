package Pronotion.web_server.service;

import Pronotion.web_server.dao.TaskDaoImpl;
import Pronotion.web_server.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskDaoImpl taskDao;
    public TaskService(TaskDaoImpl taskDao) {
        this.taskDao = taskDao;
    }

    public void addTask(Task task) {
        taskDao.insertTask(task);

    }
    public boolean updateTask(long id, Task task) {
       return taskDao.updateTask(id, task);
    }

    public void deleteTask(long id) {
        taskDao.deleteTask(id);
    }

    public List<Task> getTask(long id) {
        List<Task> task = taskDao.getTasks(id);
        return  task;
    }


}
