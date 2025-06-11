package Pronotion.web_server.service;

import Pronotion.web_server.dao.UserDaoImpl;
import Pronotion.web_server.model.User;
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

    void addUser(String name, String email, String password) {
        if (validEmail(email) && validPassword(password) && checkUserExists(email)) {
            userDao.createUser(new User(name, email, password));
        }
    }

    boolean checkUserExists(String email) {
        return userDao.existsUser(email);
    }

    boolean validEmail(String email) {
        if (email.contains("@") && email.contains(("."))) {return true;}
        return false;
    }

    boolean validPassword(String password) {
        if (password == null || password.length() < 12) {
            return false;
        }

        boolean hasSpecial = password.matches(".*[!@\\$\\*].*");
        boolean hasDigit = password.matches(".*\\d.*");

        return hasSpecial && hasDigit;
    }
}
