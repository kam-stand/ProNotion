package Pronotion.web_server.dao;

import Pronotion.web_server.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    Optional<User> findUser(long id);
    Optional<List<User>> findListUsers(List<Long> ids);

}
