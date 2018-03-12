package ru.job4j.collections;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for ListCompare.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 12.03.2018.
 */

public class NodeTest {
    @Test
    public void shouldReturnTrue() {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n3);

        assertThat(n1.hasCycle(n1), is(true));
    }
}