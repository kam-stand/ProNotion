package Pronotion.web_server.dao;

import Pronotion.web_server.model.Task;
import Pronotion.web_server.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class TaskDaoImpl implements TaskDao {

    private final JdbcTemplate jdbcTemplate;

    public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Optional<Task> findTaskById(int id) {
        String sql = "SELECT * FROM Tasks WHERE id = ?";
        try {
            Task task = jdbcTemplate.queryForObject(
                    sql,
                    new Object[]{id},
                    (rs, rowNum) -> {
                        Task t = new Task();
                        t.setId(rs.getLong("id"));
                        t.setName(rs.getString("name"));
                        t.setDescription(rs.getString("description"));
                        t.setUser_id(rs.getLong("user_id"));
                        t.setDue_date(rs.getTimestamp("due_date"));
                        t.setStatus(rs.getString("status"));
                        return t;
                    }
            );
            return Optional.of(task);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }

    @Override
    public void insertTask(Task task) {
        String sql = "INSERT into Tasks (name, description, user_id, due_date, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                task.getName(), task.getDescription(), task.getUser_id(), task.getDue_date(), task.getStatus()
        );
    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void deleteTask(int id) {

    }

    @Override
    public List<Task> getTasks(long userId) {
        return List.of();
    }

    @Override
    public List<User> getUsersByTaskId(int id) {
        return List.of();
    }
}
