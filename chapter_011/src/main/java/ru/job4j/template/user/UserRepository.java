package ru.job4j.template.user;

import ru.job4j.models.User;
import java.util.List;

/**
 * This class represents repository for user.
 * @author Svyatoslav Sabirov.
 * @since 15.06.2018
 * @version 7.
 */
public interface UserRepository {
    List<User> getAll();
    User getUserByID(int id);
}
