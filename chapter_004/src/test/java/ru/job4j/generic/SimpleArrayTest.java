package ru.job4j.generic;

import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for SimpleArray.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 03.03.2018.
 */
public class SimpleArrayTest {

    @Test
    public void whenAddToArrayThreeElement() {
        SimpleArray<String> testArray = new SimpleArray(5);
        testArray.add("Slava");
        testArray.add("Petr");
        testArray.add("Corvin");
        assertThat(testArray.get(1), is("Petr"));
    }

    @Test
    public void whenAddToArrayThreeElementAndSet() {
        SimpleArray<String> testArray = new SimpleArray(5);
        testArray.add("Slava");
        testArray.add("Petr");
        testArray.add("Corvin");
        testArray.set(2, "Leks");
        assertThat(testArray.get(2), is("Leks"));
    }

    @Test
    public void whenAddToArrayThreeElementAndDelete() {
        SimpleArray<String> testArray = new SimpleArray(5);
        testArray.add("Slava");
        testArray.add("Petr");
        testArray.add("Corvin");
        testArray.delete(1);
        assertThat(testArray.get(1), is("Corvin"));
    }

    @Test
    public void whenAddToIntegerArrayThreeElement() {
        SimpleArray<Integer> testArray = new SimpleArray(5);
        testArray.add(3);
        testArray.add(6);
        testArray.add(8);
        assertThat(testArray.get(1), is(6));
    }

    @Test
    public void whenAddToIntegerArrayThreeElementAndCheckIteratorHasNext() {
        SimpleArray<Integer> testArray = new SimpleArray(5);
        testArray.add(3);
        testArray.add(6);
        testArray.add(8);
        Iterator<Integer> testIterator = testArray.iterator();
        testIterator.next();
        testIterator.next();
        assertThat(testIterator.hasNext(), is(true));
    }

    @Test
    public void whenAddToIntegerArrayThreeElementAndCheckIteratorNext() {
        SimpleArray<Integer> testArray = new SimpleArray(5);
        testArray.add(3);
        testArray.add(6);
        testArray.add(8);
        Iterator<Integer> testIterator = testArray.iterator();
        testIterator.next();
        testIterator.next();
        assertThat(testIterator.next(), is(8));
    }
}