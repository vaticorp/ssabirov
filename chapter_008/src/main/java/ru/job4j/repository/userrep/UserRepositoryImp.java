package ru.job4j.repository.userrep;

import ru.job4j.models.User;
import ru.job4j.repository.CommonSpecification;
import ru.job4j.repository.ContextPostgres;

import java.util.List;

/**
 * This class represents UserRepository.
 * @author Svyatoslav Sabirov.
 * @since 09.05.2018
 * @version 12.
 */
public class UserRepositoryImp implements UserRepository {

    private final ContextPostgres context;

    public UserRepositoryImp(ContextPostgres context) {
        this.context = context;
    }

    @Override
    public void add(User user) {
       context.addUser(user);
    }

    @Override
    public User find(Object value) {
        return null;
    }

    @Override
    public List query(CommonSpecification specification) {
        return null;
    }
}
