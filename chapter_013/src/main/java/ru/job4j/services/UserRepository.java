package ru.job4j.services;

import ru.job4j.models.User;

import java.util.List;

/**
 * This class represents repository for crud.
 * @author Svyatoslav Sabirov.
 * @since 09.07.2018
 * @version 7.
 */
public interface UserRepository {
    User getUserByID(int id);
    int addUser(User user);
    List<User> getAll();
}
