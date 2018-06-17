package ru.job4j.template.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.models.Body;
import ru.job4j.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents service for user.
 * @author Svyatoslav Sabirov.
 * @since 15.06.2018
 * @version 12.
 */
@Service
@Transactional
public class UserService implements UserRepository {
    @Autowired
    private UserCrud userCrud;
    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<User>();
        userCrud.findAll().forEach(current -> list.add(current));
        return list;
    }
    @Override
    public User getUserByID(int id) {
        return userCrud.findById(id).get();
    }
}
