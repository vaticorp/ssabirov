package ru.job4j.collections;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.lang.reflect.Array;
import java.util.*;

/**
 * This class represents ArrayContainer.
 * @author Svyatoslav Sabirov.
 * @since 05.03.2018
 * @version 10.
 */
@ThreadSafe
public class ArrayContainer<E> implements SimpleContainer<E> {
    @GuardedBy("this")
    private Object[] container;
    @GuardedBy("this")
    private int size;
    private int modCount;

    public ArrayContainer(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Указан неправильный размер массива!");
        }
        this.container = new Object[size];
    }

    /**
     * Конструктор без указания размера.
     */
    public ArrayContainer() {
        this(10);
    }

    public synchronized int getSize() {
        return size;
    }

    public int getLength() {
        return this.container.length;
    }

    @Override
    public synchronized E get(int index) {
        checkIndex(index);
        return (E) this.container[index];
    }

    @Override
    public synchronized void add(E value) {
        checkSize();
        this.modCount++;
        this.container[size++] = value;
    }

    @Override
    public synchronized Iterator<E> iterator() {

        int expectedModCount = this.modCount;

        return new Iterator<E>() {

            private int innerIterator;

            @Override
            public boolean hasNext() {
                return this.innerIterator < size - 1;
            }

            public void checkArrayChanges() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException("Произошла рассинхронизация итератора и контейнера коллекции!");
                }
            }

            @Override
            public E next() {
                synchronized (ArrayContainer.this) {
                    checkArrayChanges();
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return (E) container[innerIterator++];
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public void checkSize() {
        if (size + 1 > container.length) {
            increaseArray();
        }
    }

    public boolean set(int index, E value) {
        checkLength(index);
        if (this.container[index] == null) {
            size++;
        }
        this.container[index] = value;
        this.modCount++;
        return true;
    }

    public void increaseArray() {
        this.modCount++;
        this.container = Arrays.copyOf(this.container, this.container.length * 2);
    }

    public boolean remove(E value) {
        int length =  this.getLength();
        for (int index = 0; index < length; index++) {
            if (this.container[index] != null && ((E) this.container[index]).equals(value)) {
                this.modCount++;
                System.arraycopy(this.container, index + 1, this.container, index, length - index - 1);
                this.container[--size] = null;
                return true;
            }
        }
        return false;
    }

    public synchronized void checkIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Индес находится за границей размера коллекции");
        }
    }

    public void checkLength(int index) {
        if (index >= this.getLength()) {
            throw new IndexOutOfBoundsException("Индес находится за границей размера коллекции");
        }
    }

    public synchronized boolean contains(E value) {
        boolean result = false;
        int length =  this.getLength();
        for (int index = 0; index < length; index++) {
            if (this.container[index] != null && this.container[index].equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int indexOf(E value) {
        int index = -1;
        int length =  this.getLength();
        for (int i = 0; i < length; i++) {
            if (this.container[i] != null && ((E) this.container[i]).equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
