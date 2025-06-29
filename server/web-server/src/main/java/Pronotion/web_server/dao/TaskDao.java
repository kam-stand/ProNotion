package Pronotion.web_server.dao;

import Pronotion.web_server.model.Task;

import java.util.List;

public interface TaskDao {


    public Task findTaskById(int id);

    public void insertTask(Task task);

    public void updateTask(Task task);

    public void deleteTask(int id);

    public List<Task> getTasks();



}
