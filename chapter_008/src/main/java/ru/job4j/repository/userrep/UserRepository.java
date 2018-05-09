package ru.job4j.repository.userrep;

import ru.job4j.models.User;
import ru.job4j.repository.Repository;

/**
 * This class represents repository for User.
 * @author Svyatoslav Sabirov.
 * @since 07.05.2018
 * @version 7.
 */
public interface UserRepository<T> extends Repository<User> {
    public void add(User user);
    public User find(T value);
}
