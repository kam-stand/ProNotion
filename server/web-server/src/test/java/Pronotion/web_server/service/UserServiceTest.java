package Pronotion.web_server.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    // You can use a mock or a dummy for UserDaoImpl if needed
    private final UserService userService = new UserService(null);

    @Test
    void validEmail_shouldReturnTrueForValidEmails() {
        assertTrue(userService.validEmail("user@example.com"));
        assertTrue(userService.validEmail("hello.world@domain.co"));
    }

    @Test
    void validEmail_shouldReturnFalseForInvalidEmails() {
        assertFalse(userService.validEmail("userexample.com"));
        assertFalse(userService.validEmail("user@com"));
        assertFalse(userService.validEmail("user.com"));
        assertFalse(userService.validEmail(""));
    }

    @Test
    void validPassword_shouldReturnTrueForValidPasswords() {
        assertTrue(userService.validPassword("Password123!"));
        assertTrue(userService.validPassword("A1b2c3d4e5f6*"));
    }

    @Test
    void validPassword_shouldReturnFalseForInvalidPasswords() {
        assertFalse(userService.validPassword("short1!A")); // too short
        assertFalse(userService.validPassword("nouppercase123!")); // no uppercase
        assertFalse(userService.validPassword("NoSpecialChar123")); // no special char
        assertFalse(userService.validPassword("NoNumber!AAAAAA")); // no number
        assertFalse(userService.validPassword(null)); // null
    }
}
