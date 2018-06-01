package ru.job4j.hibernate;

import org.junit.Test;
import ru.job4j.models.User;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * This class represents UserRunner-test
 * @author Svyatoslav Sabirov.
 * @since 01.06.2018
 * @version 9.
 */
public class UserRunnerTest {

    @Test
    public void testAdd() {
        User body = new User();
        body.setId(1);
        UserRunner.INSTANCE.addEntry(body);
        assertThat(1, is(UserRunner.INSTANCE.getEntryById(1).getId()));
    }

    @Test
    public void testGetAll() {
        User first = new User();
        UserRunner.INSTANCE.addEntry(first);
        User second = new User();
        UserRunner.INSTANCE.addEntry(second);
        assertThat(2, is(UserRunner.INSTANCE.getAllEntry().size()));
    }

    @Test
    public void testGetByLoginPassword() {
        User body = new User();
        body.setId(1);
        body.setLogin("papa");
        body.setPassword("carlo");
        UserRunner.INSTANCE.addEntry(body);
        assertThat(1, is(UserRunner.INSTANCE.getUserId("papa", "carlo")));
    }
}