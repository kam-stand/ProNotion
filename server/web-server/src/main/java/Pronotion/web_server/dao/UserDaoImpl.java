package Pronotion.web_server.dao;

import Pronotion.web_server.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {


    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void createUser(User user) {
        String query = "INSERT INTO Users (name, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getPassword());
    }

    @Override
    public void updateUser(long id, User user) {
        String query = "UPDATE Users SET name = ?, email = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getPassword(), id);

    }


    @Override
    public void deleteUser(long id) {
        String query = "DELETE FROM Users WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public Optional<User> findUser(long id) {
        String query = "SELECT * FROM Users WHERE id = ?";

        try {
            User user = jdbcTemplate.queryForObject(
                    query,
                    new Object[]{id},
                    (rs, rowNum) -> new User(
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password")
                    )
            );
            return Optional.of(user); // Wrap the user in Optional
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty(); // No result found

        }

    }


}
