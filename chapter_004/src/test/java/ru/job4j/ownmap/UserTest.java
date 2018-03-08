package ru.job4j.ownmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for User.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 08.03.2018.
 */
public class UserTest {

    @Test
    public void whenCreateTwoUsersAndCheck() {
        User petrIvanov    = new User("Petr", 1, new Calendar(11, 3, 1987));
        User petrArsentiev = new User("Petr", 1, new Calendar(11, 3, 1987));
        Map<User, Object> testMaps = new Hashtable<User, Object>();
        testMaps.put(petrIvanov, new Object());
        testMaps.put(petrArsentiev, new Object());
        System.out.println(testMaps);
     }
}