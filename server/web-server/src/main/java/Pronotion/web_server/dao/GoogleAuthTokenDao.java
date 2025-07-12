package Pronotion.web_server.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GoogleAuthTokenDao {


    private final JdbcTemplate jdbcTemplate;

    public GoogleAuthTokenDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveOrUpdate(String email, String userName, String accessToken, String refreshToken) {
        // Check if token already exists
        String checkQuery = "SELECT COUNT(*) FROM Google_Auth_Tokens WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(checkQuery, Integer.class, email);

        if (count != null && count > 0) {
            // Update
            String updateQuery = """
                UPDATE Google_Auth_Tokens 
                SET user_name = ?, access_token = ?, refresh_token = ?, updated_at = CURRENT_TIMESTAMP 
                WHERE email = ?
            """;
            jdbcTemplate.update(updateQuery, userName, accessToken, refreshToken, email);
        } else {
            // Insert
            String insertQuery = """
                INSERT INTO Google_Auth_Tokens (email, user_name, access_token, refresh_token) 
                VALUES (?, ?, ?, ?)
            """;
            jdbcTemplate.update(insertQuery, email, userName, accessToken, refreshToken);
        }
    }
}
