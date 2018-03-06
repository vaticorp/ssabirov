package ru.job4j.ownset;

import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for SimpleSet.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 06.03.2018.
 */
public class SimpleSetTest {
    @Test
    public void whenAddTwoValueAndCheck() {
        SimpleSet<Integer> testSet = new SimpleSet<>();
        testSet.add(3);
        testSet.add(3);
        testSet.add(3);
        testSet.add(3);
        assertThat(testSet.size(), is(1));
    }

    @Test
    public void whenAddTwoValueAndCheckIterator() {
        SimpleSet<Integer> testSet = new SimpleSet<>();
        testSet.add(3);
        testSet.add(4);
        testSet.add(5);
        Iterator<Integer> testIterator = testSet.iterator();
        testIterator.next();
        assertThat(testIterator.next(), is(4));
    }
}