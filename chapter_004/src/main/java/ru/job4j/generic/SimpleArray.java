package ru.job4j.generic;

import java.util.*;
import java.util.function.Consumer;

/**
 * This class represents SimpleArray.
 * @author Svyatoslav Sabirov.
 * @since 03.03.2018
 * @version 7.
 */
public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;
    private int currentIndex = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int innerIterator = 0;

            @Override
            public boolean hasNext() {
                return this.innerIterator <= currentIndex - 1;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[innerIterator++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[this.currentIndex++] = model;
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public T get(int index) {
        return (T) this.objects[index];
    }

    public void delete(int index) {
        if (index < currentIndex - 1) {
            System.arraycopy(this.objects, index + 1, this.objects, index, currentIndex - index - 1);
        }
        this.objects[this.currentIndex--] = null;
    }
}
