package ru.job4j.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.models.User;

/**
 * This class represents class for crud-operation.
 * @author Svyatoslav Sabirov.
 * @since 09.07.2018
 * @version 10.
 */
public interface UserCrud extends CrudRepository<User, Integer> {
    @Query("select usr from User usr where usr.accountID =:login")
    User findByAccountID(@Param("login") String login);

    @Query("select usr from User usr where usr.accountID =:login and usr.password =:password")
    User findByLoginPassword(@Param("login") String login, @Param("password") String password);
}
