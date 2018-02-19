package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test-class for PriorityQueue.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 19.02.2018
 */
public class UserConvertTest {
    @Test
    public void whenListConvertToMap() {
        List<User> list = new ArrayList<User>();
        Collections.addAll(list, new User(1, "Petr", "Bryansk"), new User(2, "Svyatoslav", "St Peterburg"));
        UserConvert testUser = new UserConvert();
        HashMap<Integer, User> testMap = testUser.process(list);
        assertThat(true, is(testMap.containsKey(1)));
    }
}
