package ru.job4j.collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class represents LinkedListContainer
 * @author Svyatoslav Sabirov.
 * @since 05.03.2018
 * @version 7.
 */
public class LinkedListContainer<E> implements SimpleContainer<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount;

    public class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;

        public Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<E>(value, null, this.last);
        if (this.last == null) {
            this.first = newNode;
        } else {
            this.last.next = newNode;
            newNode.prev = this.last;
        }
        this.last = newNode;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Индес находится за границей размера коллекции");
        }
        Node<E> currentNode = this.first;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            index--;
            if (index == 0) {
                break;
            }
        }
        return currentNode.value;
    }

    @Override
    public Iterator<E> iterator() {

        int expectedModCount = this.modCount;

        return new Iterator<E>() {

            private Node<E> innerIterator;

            @Override
            public boolean hasNext() {
                return (innerIterator == null && first != null) || (innerIterator != null && !innerIterator.equals(last));
            }

            public void checkArrayChanges() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Произошла рассинхронизация итератора и контейнера коллекции!");
                }
            }

            @Override
            public E next() {
                checkArrayChanges();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.innerIterator = this.innerIterator == null ? first : innerIterator.next;
                return this.innerIterator.value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}