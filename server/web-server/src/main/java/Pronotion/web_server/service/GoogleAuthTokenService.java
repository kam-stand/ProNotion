package Pronotion.web_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class GoogleAuthTokenService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveOrUpdate(String email, String userName, String accessToken, String refreshToken) {
        String checkQuery = "SELECT COUNT(*) FROM Google_Auth_Tokens WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(checkQuery, Integer.class, email);

        if (count != null && count > 0) {
            String updateQuery = """
                UPDATE Google_Auth_Tokens 
                SET user_name = ?, access_token = ?, refresh_token = ?, updated_at = CURRENT_TIMESTAMP 
                WHERE email = ?
            """;
            jdbcTemplate.update(updateQuery, userName, accessToken, refreshToken, email);
        } else {
            String insertQuery = """
                INSERT INTO Google_Auth_Tokens (email, user_name, access_token, refresh_token) 
                VALUES (?, ?, ?, ?)
            """;
            jdbcTemplate.update(insertQuery, email, userName, accessToken, refreshToken);
        }
    }

    public String getAccessToken(String email) {
        String checkQuery = "SELECT access_token FROM Google_Auth_Tokens WHERE email = ?";
        return jdbcTemplate.queryForObject(checkQuery, String.class, email);
    }


}
