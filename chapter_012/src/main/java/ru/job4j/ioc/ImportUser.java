package ru.job4j.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class represents class for start application;
 * @author Svyatoslav Sabirov.
 * @since 06.06.2018
 * @version 7.
 */
@Component
public class ImportUser {

    private final Storage storage;

    @Autowired
    public ImportUser(final Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        this.storage.add(user);
    }
}
