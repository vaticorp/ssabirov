package ru.job4j.template.user;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.User;

/**
 * This class represents crud for user-repository
 * @author Svyatoslav Sabirov.
 * @since 15.06.2018
 * @version 10.
 */
public interface UserCrud extends CrudRepository<User, Integer> {
}
