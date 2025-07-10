package Pronotion.web_server.dao;

import Pronotion.web_server.model.Task;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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
        String sql = "INSERT INTO Tasks (name, description, user_id, due_date, status) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                task.getName(),
                task.getDescription(),
                task.getUser_id(),
                task.getDue_date(),
                task.getStatus()
        );
    }


@Override
public boolean updateTask(long id, Task task) {
    String sql = "UPDATE Tasks SET name = ?, description = ?, user_id = ?, due_date = ?, status = ? WHERE id = ?";
    int rowsAffected = jdbcTemplate.update(
        sql,
        task.getName(),
        task.getDescription(),
        task.getUser_id(),
        task.getDue_date(),
        task.getStatus(),
        id
    );
    return rowsAffected > 0; // true if update succeeded, false if not
}


    @Override
    public void deleteTask(long id) {
        String sql = "DELETE FROM Tasks WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    @Override
    public List<Task> getTasks(long userId) {
        String sql = "SELECT * FROM Tasks WHERE user_id = ?";
        return jdbcTemplate.query(
                sql,
                new Object[]{userId},
                (rs, rowNum) -> {
                    Task task = new Task();
                    task.setId(rs.getLong("id"));
                    task.setName(rs.getString("name"));
                    task.setDescription(rs.getString("description"));
                    task.setUser_id(rs.getLong("user_id"));
                    task.setDue_date(rs.getTimestamp("due_date"));
                    task.setStatus(rs.getString("status"));
                    return task;
                }
        );
    }



}
