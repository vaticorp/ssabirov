package fullstack.services;

import fullstack.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents User-class for User.
 * @author Svyatoslav Sabirov.
 * @since 11.09.2018
 * @version 10.
 */
@Service
public class UserService implements UserRepository {

    @Autowired
    UserCrud userCrud;

    public User getUserByLoginPassword(String login, String password) {
        return userCrud.findByLoginPassword(login, password);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        userCrud.findAll().forEach(s -> list.add(s));
        return list;
    }

    @Override
    public User getUserById(long id) {
        return userCrud.findById(id).get();
    }
}
