package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is simple test-class for sort
 * @author Svyatoslav Sabirov.
 * @since 19.02.2018.
 * @version $id$.
 */
public class UserTest {
    @Test
    public void whenSortingWithComparatorThen() {
        User people = new User();
        List<User> list = new ArrayList<User>();
        User roman = new User("Roman", 17);
        list.add(new User("Petr", 28));
        list.add(new User("Svyatoslav", 27));
        list.add(roman);
        list.add(new User("Marina", 35));
        assertThat(roman, is(people.sort(list).toArray()[0]));
    }
    @Test
    public void whenSortingWithComparatorNameLength() {
        User people = new User();
        List<User> list = new ArrayList<User>();
        User petr = new User("Petr", 68);
        list.add(new User("Roman", 17));
        list.add(new User("Svyatoslav", 27));
        list.add(petr);
        list.add(new User("Marina", 35));
        assertThat(petr, is(people.sortNameLength(list).toArray()[0]));
    }
    @Test
    public void whenSortingWithComparatorByAllFields() {
        User people = new User();
        List<User> list = new ArrayList<User>();
        User sergey = new User("Сергей", 20);
        list.add(new User("Сергей", 25));
        list.add(sergey);
        list.add(new User("Иван", 30));
        list.add(new User("Иван", 25));
        assertThat(sergey, is(people.sortByAllFields(list).toArray()[2]));
    }
}
