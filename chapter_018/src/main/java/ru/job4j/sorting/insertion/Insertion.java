package ru.job4j.sorting.insertion;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * This class represents class for Insertion Sorting.
 * @author Svyatoslav Sabirov.
 * @since 16.09.2018
 * @version 7.
 */
public class Insertion<T> implements Sorting<T>, Comparator<T> {

    private final T[] array;

    public Insertion(T[] array) {
        this.array = array;
    }

    @Override
    public T value(int index) {
        return this.array[index];
    }

    @Override
    public int compare(T o1, T o2) {
        return ((Comparable<? super T>) o1).compareTo(o2);
    }

    @Override
    public void sort() {
        for (int i = 1; i < this.array.length; i++) {
            T value = this.array[i];
            int j = i;
            for (; j >= 1 && compare(value, this.array[j-1]) < 0; j--) {
                this.array[j] = this.array[j-1];
            }
            this.array[j] = value;
        }
    }

    @Override
    public void print() {
        Stream.of(array).forEach(s -> System.out.println(s));
    }
}
