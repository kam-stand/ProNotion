package Pronotion.web_server.service;

import Pronotion.web_server.dao.UserDaoImpl;
import Pronotion.web_server.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDaoImpl userDao;

    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    /**
     *  1. Use DTO verify the conditions for a valid user Creation:
     *      a. valid email --> contains '@' and a '.'
     *      b. valid password --> at least 12 chars long, contains one special character, at least one Uppercase letter, at least one number
     *      c. Verify email is Unique --> email not already in database
     *      d. Hash the password
     */

    void addUser(UserDto userDto) {

    }


}
