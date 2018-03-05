package ru.job4j.collections;

import org.junit.Test;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for ArrayContainer.
 * @author Svatoslav Sabirov.
 * @version 13.
 * @since 05.03.2018.
 */
public class ArrayContainerTest {

    @Test
    public void whenArrayIsIncreaseAfterAdd() {
        ArrayContainer<String> testArray = new ArrayContainer<String>(3);
        testArray.add("Petr");
        testArray.add("Olya");
        testArray.add("Oleg");
        testArray.add("Igor");
        assertThat(testArray.getLength(), is(6));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenArrayIsDesyncAfterAdd() {
        ArrayContainer<String> testArray = new ArrayContainer<String>(3);
        testArray.add("Petr");
        testArray.add("Olya");
        testArray.add("Oleg");
        Iterator<String> testIterator = testArray.iterator();
        testIterator.next();
        testArray.add("Igor");
        testIterator.next();
    }
}