package ru.job4j.iter;

import org.junit.Test;
import org.junit.Before;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for ArrayIterator.
 * @author Svatoslav Sabirov.
 * @version 13.
 * @since 01.03.2018.
 */
public class ArrayIteratorTest {

    private Iterator<Integer> it;
    private Iterator<Integer> itJagged;

    @Test
    public void whenArraysContainTwoArray() {
        Iterator<Integer> iter = new ArrayIterator(new int[][]{{1, 2, 3}, {4, 5, 6}});
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        assertThat(iter.next(), is(5));
    }

    @Before
    public void setUp() {
        it = new ArrayIterator(new int[][]{{1, 2, 3}, {4, 5, 6}});
        itJagged = new ArrayIterator(new int[][]{{1}, {3, 4}, {7}});
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocationJagged() {
        assertThat(itJagged.next(), is(1));
        assertThat(itJagged.next(), is(3));
        assertThat(itJagged.next(), is(4));
        assertThat(itJagged.next(), is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrderJagged() {
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(1));
        assertThat(itJagged.next(), is(3));
        assertThat(itJagged.next(), is(4));
        assertThat(itJagged.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocationJagged() {
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(1));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(3));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(4));
        assertThat(itJagged.hasNext(), is(true));
        assertThat(itJagged.next(), is(7));
        assertThat(itJagged.hasNext(), is(false));
    }
}