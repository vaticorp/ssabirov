package ru.job4j.sorting.selection;

import ru.job4j.sorting.insertion.Sorting;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * This class represents class for selection sorting.
 * @author Svyatoslav Sabirov.
 * @since 16.09.2018
 * @version 7.
 */
public class Selection<T> implements Sorting<T>, Comparator<T> {

    private final T[] array;

    public Selection(T[] array) {
        this.array = array;
    }

    @Override
    public int compare(T o1, T o2) {
        return ((Comparable<? super T>) o1).compareTo(o2);
    }

    @Override
    public void sort() {
        for (int i = 0; i < this.array.length; i++) {
            T value = this.array[i];
            int j = i;
            int minIndex = i;
            for (; j < this.array.length; j++) {
                if (compare(array[minIndex], array[j]) > 0) {
                    minIndex = j;
                }
            }
            this.array[i] = this.array[minIndex];
            this.array[minIndex] = value;
        }
    }

    @Override
    public void print() {
        Stream.of(array).forEach(s -> System.out.println(s));
    }

    @Override
    public T value(int index) {
        return this.array[index];
    }
}
