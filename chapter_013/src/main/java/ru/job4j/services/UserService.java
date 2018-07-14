package ru.job4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.models.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents service fpr user.
 * @author Svyatoslav Sabirov.
 * @since 09.07.2018
 * @version 9.
 */
@Service
@Transactional
public class UserService implements UserRepository {

    @Autowired
    UserCrud userCrud;

    @Override
    public User getUserByID(int id) {
        return userCrud.findById(id).get();
    }

    @Override
    public int addUser(User user) {
        return userCrud.save(user).getId();
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<User>();
        userCrud.findAll().forEach(current -> list.add(current));
        return list;
    }

    public User findByAccountID(String accountID) {
        return userCrud.findByAccountID(accountID);
    }

    public User findByLoginPassword(String login, String password) {
        return userCrud.findByLoginPassword(login, password);
    }
}
