package ru.job4j.collections;

import org.junit.Test;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for LinkedListContainer.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 05.03.2018.
 */
public class LinkedListContainerTest {
    @Test
    public void whenAddToLinkedSixNodes() {
        LinkedListContainer<Integer> testLink = new LinkedListContainer<Integer>();
        testLink.add(4);
        testLink.add(3);
        testLink.add(5);
        testLink.add(7);
        testLink.add(3);
        testLink.add(6);
        assertThat(testLink.get(3), is(7));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddToLinkedTwoNodeAndGetIndex() {
        LinkedListContainer<Integer> testLink = new LinkedListContainer<Integer>();
        testLink.add(4);
        testLink.add(3);
        assertThat(testLink.get(3), is(7));
    }

    @Test
    public void whenAddToLinkedSixNodesAndSyncronize() {
        LinkedListContainer<Integer> testLink = new LinkedListContainer<Integer>();
        testLink.add(4);
        testLink.add(3);
        testLink.add(5);
        Iterator<Integer> linkedIterator = testLink.iterator();
        linkedIterator.next();
        linkedIterator.next();
        assertThat(linkedIterator.next(), is(5));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddToLinkedSixNodesAndDesync() {
        LinkedListContainer<Integer> testLink = new LinkedListContainer<Integer>();
        testLink.add(4);
        testLink.add(3);
        testLink.add(5);
        Iterator<Integer> linkedIterator = testLink.iterator();
        linkedIterator.next();
        testLink.add(5);
        linkedIterator.next();
    }
}