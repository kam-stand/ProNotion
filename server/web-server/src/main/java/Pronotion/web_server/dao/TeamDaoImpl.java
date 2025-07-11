package Pronotion.web_server.dao;

import Pronotion.web_server.model.Team;
import Pronotion.web_server.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class TeamDaoImpl implements TeamDao {

    private final JdbcTemplate jdbcTemplate;

    public TeamDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for Team
    private final RowMapper<Team> teamRowMapper = (rs, rowNum) -> new Team(
            rs.getString("name")
    );

    // RowMapper for User
    private final RowMapper<User> userRowMapper = (rs, rowNum) -> new User(
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("password")
    );

    @Override
    public List<Team> getTeams() {
        String sql = "SELECT * FROM Teams";
        return jdbcTemplate.query(sql, teamRowMapper);
    }

    @Override
    public Team getTeamById(int id) {
        String sql = "SELECT * FROM Teams WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, teamRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean addTeam(Team team) {
        String sql = "INSERT INTO Teams (name) VALUES (?)";
        return jdbcTemplate.update(sql, team.getName()) > 0;
    }

    @Override
    public boolean updateTeam(Team team) {
        String sql = "UPDATE Teams SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, team.getName(), team.getId()) > 0;
    }

    @Override
    public boolean deleteTeam(int id) {
        String sql = "DELETE FROM Teams WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public List<User> getUsersByTeamId(int teamId) {
        String sql = """
            SELECT u.* FROM Users u
            JOIN Team_Members tm ON u.id = tm.user_id
            WHERE tm.team_id = ?
        """;
        return jdbcTemplate.query(sql, new Object[]{teamId}, userRowMapper);
    }

    // Optional: Add user to team
    public boolean addUserToTeam(int teamId, int userId) {
        String sql = "INSERT INTO Team_Members (team_id, user_id) VALUES (?, ?)";
        try {
            return jdbcTemplate.update(sql, teamId, userId) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    // Optional: Remove user from team
    public boolean removeUserFromTeam(int teamId, int userId) {
        String sql = "DELETE FROM Team_Members WHERE team_id = ? AND user_id = ?";
        return jdbcTemplate.update(sql, teamId, userId) > 0;
    }

    // Optional: Get all teams for a specific user
    public List<Team> getTeamsByUserId(int userId) {
        String sql = """
            SELECT t.* FROM Teams t
            JOIN Team_Members tm ON t.id = tm.team_id
            WHERE tm.user_id = ?
        """;
        return jdbcTemplate.query(sql, new Object[]{userId}, teamRowMapper);
    }
}
