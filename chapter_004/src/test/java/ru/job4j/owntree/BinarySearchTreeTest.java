package ru.job4j.owntree;

import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for BinarySearchTree.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 11.03.2018.
 */
public class BinarySearchTreeTest {
    @Test
    public void whenCreateSimpleBST() {
        BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>(50);
        testBST.add(43);
        testBST.add(53);
        testBST.add(63);
        testBST.add(33);
        testBST.add(48);
        assertThat(testBST.getRoot().getLeftChild().getLeftChild().getValue(), is(33));
    }

    @Test
    public void whenCreateSimpleBSTAndCheckIterator() {
        BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>(50);
        testBST.add(43);
        testBST.add(53);
        testBST.add(63);
        testBST.add(33);
        testBST.add(48);
        testBST.add(22);
        testBST.add(35);
        Iterator<Integer> testIterator = testBST.iterator();
        testIterator.next();
        testIterator.next();
        assertThat(testIterator.next(), is(35));
    }
}