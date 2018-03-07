package ru.job4j.ownset;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for ListCompare.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 07.03.2018.
 */
public class SetHashTest {
    @Test
    public void whenAddValueAndCheck() {
        SetHash<String> testSet = new SetHash<String>();
        testSet.add("Petr");
        assertThat(testSet.contains("Petr"), is(true));
    }
    @Test
    public void whenAddValueAndRemove() {
        SetHash<String> testSet = new SetHash<String>();
        testSet.add("Petr");
        testSet.remove("Petr");
        assertThat(testSet.contains("Petr"), is(false));
    }
}