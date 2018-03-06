package ru.job4j.collections;

import java.util.*;

/**
 * This class represents ArrayContainer.
 * @author Svyatoslav Sabirov.
 * @since 05.03.2018
 * @version 10.
 */
public class ArrayContainer<E> implements SimpleContainer<E> {

    private Object[] container;
    private int size;
    private int modCount;

    public ArrayContainer(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Указан неправильный размер массива!");
        }
        this.container = new Object[size];
    }

    public ArrayContainer() {

    }

    public int getSize() {
        return size;
    }

    public int getLength() {
        return this.container.length;
    }

    @Override
    public void add(E value) {
        if (size + 1 > container.length) {
            increaseArray();
        }
        this.modCount++;
        this.container[size++] = value;
    }

    public void increaseArray() {
        this.modCount++;
        this.container = Arrays.copyOf(this.container, this.container.length * 2);
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Индес находится за границей размера коллекции");
        }
        return (E) this.container[index];
    }

    public int indexOf(E value) {
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (((E) this.container[i]).equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Iterator<E> iterator() {

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
                checkArrayChanges();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[innerIterator++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
