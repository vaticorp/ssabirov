package ru.job4j.sorting.heapsort;

import ru.job4j.sorting.insertion.Sorting;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * This class represents class for heap-sorting.
 * @author Svyatoslav Sabirov.
 * @since 16.09.2018
 * @version 7.
 */
public class Pyramidal<T> implements Sorting<T>, Comparator<T> {

    private final T[] array;

    public Pyramidal(T[] array) {
        this.array = array;
    }

    @Override
    public int compare(T o1, T o2) {
        return ((Comparable<? super T>) o1).compareTo(o2);
    }

    @Override
    public void sort() {
        for (int i = (this.array.length / 2) - 1; i >= 0; i--)
            sortDown(i, this.array.length - 1);
        for (int i = this.array.length - 1; i >= 1; i--) {
            T temp = this.array[0];
            this.array[0] = this.array[i];
            this.array[i] = temp;
            sortDown(0, i - 1);
        }
    }

    void sortDown(int root, int bottom) {
        int maxChild;
        boolean done = false;
        while ((root * 2 <= bottom) && (!done)) {
            if (root * 2 == bottom)
                maxChild = root * 2;
            else if (compare(this.array[root * 2], this.array[root * 2 + 1]) > 0)
                maxChild = root * 2;
            else
                maxChild = root * 2 + 1;
            if (compare(this.array[root], this.array[maxChild]) < 0) {
                T temp = this.array[root];
                this.array[root] = this.array[maxChild];
                this.array[maxChild] = temp;
                root = maxChild;
            } else {
                done = true;
            }
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
