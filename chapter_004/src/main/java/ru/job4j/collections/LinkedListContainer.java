package ru.job4j.collections;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

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
@ThreadSafe
public class LinkedListContainer<E> implements SimpleContainer<E> {

    @GuardedBy("this")
    private Node<E> first;
    @GuardedBy("this")
    private Node<E> last;
    @GuardedBy("this")
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

    public synchronized int getSize() {
        return size;
    }

    @Override
    public synchronized void add(E value) {
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

    public synchronized boolean contains(E value) {
        boolean result = false;
        Node<E> currentNode = this.first;
        while (currentNode != null) {
            if (currentNode.value.equals(value)) {
                result = true;
                break;
            }
            currentNode = currentNode.next;
        }
        return result;
    }

    @Override
    public synchronized E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Индес находится за границей размера коллекции");
        }
        Node<E> currentNode = this.first;
        if (index > 0) {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
                index--;
                if (index == 0) {
                    break;
                }
            }
        }
        return currentNode.value;
    }

    public synchronized E getLast(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Индес находится за границей размера коллекции");
        }
        Node<E> currentNode = this.last;
        if (index > 0) {
            while (currentNode.prev != null) {
                currentNode = currentNode.prev;
                index--;
                if (index == 0) {
                    break;
                }
            }
        }
        return currentNode.value;
    }

    public synchronized void removeFirst() {
        Node<E> firstNode = this.first;
        if (firstNode == null) {
            throw new NoSuchElementException();
        }
        Node<E> next = firstNode.next;
        firstNode.value = null;
        firstNode.next = null;
        this.first = next;
        if (next == null) {
            this.last = null;
        } else {
            next.prev = null;
        }
        size--;
        modCount++;
    }

    public synchronized void removeLast() {
        Node<E> lastNode = this.last;
        if (lastNode == null) {
            throw new NoSuchElementException();
        }
        Node<E> previous = lastNode.prev;
        lastNode.value = null;
        lastNode.prev = null;
        this.last = previous;
        if (previous == null) {
            this.first = null;
        } else {
            previous.next = null;
        }
        size--;
        modCount++;
    }

    @Override
    public synchronized Iterator<E> iterator() {

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
                synchronized (LinkedListContainer.this) {
                    checkArrayChanges();
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.innerIterator = this.innerIterator == null ? first : innerIterator.next;
                    return this.innerIterator.value;
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
