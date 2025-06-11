package Pronotion.web_server.dao;

import Pronotion.web_server.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    void createUser(User user);

    void updateUser(long id, User user);

    void deleteUser(long id);

    Optional<User> findUser(long id);

}
