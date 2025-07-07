package Pronotion.web_server.dao;

import Pronotion.web_server.model.Task;
import Pronotion.web_server.model.User;

import java.util.List;
import java.util.Optional;

public interface TaskDao {


    public Optional<Task> findTaskById(int id);

    public void insertTask(Task task);

    public void updateTask(Task task);

    public void deleteTask(int id);

    public List<Task> getTasks(long userId);

    public List<User> getUsersByTaskId(int id);



}
