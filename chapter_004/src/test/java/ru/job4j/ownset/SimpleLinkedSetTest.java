package ru.job4j.ownset;

import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for SimpleLinkedSet.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 07.03.2018.
 */
public class SimpleLinkedSetTest {
    @Test
    public void whenAddTwoValueAndCheck() {
        SimpleLinkedSet<Integer> testSet = new SimpleLinkedSet<Integer>();
        testSet.add(3);
        testSet.add(3);
        testSet.add(3);
        testSet.add(3);
        assertThat(testSet.size(), is(1));
    }

    @Test
    public void whenAddTwoValueAndCheckIterator() {
        SimpleLinkedSet<Integer> testSet = new SimpleLinkedSet<Integer>();
        testSet.add(3);
        testSet.add(4);
        testSet.add(5);
        Iterator<Integer> testIterator = testSet.iterator();
        testIterator.next();
        assertThat(testIterator.next(), is(4));
    }
}