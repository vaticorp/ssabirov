package ru.job4j.sorting.binary;

import ru.job4j.sorting.quicksort.Quick;
import java.util.Arrays;
import java.util.Comparator;

/**
 * This class represents simple class for binary-search.
 * @author Svyatoslav Sabirov.
 * @since 17.09.2018
 * @version 7.
 */
public class BinarySearch<T> implements Comparator<T> {

    private T[] array;

    public BinarySearch(T[] array) {
        this.array = array;
    }

    @Override
    public int compare(T o1, T o2) {
        return ((Comparable<? super T>) o1).compareTo(o2);
    }

    public boolean isSort() {
        T[] copy = Arrays.copyOf(this.array, this.array.length);
        Arrays.sort(copy);
        return Arrays.equals(this.array, copy);
    }

    int findIndex(T value) {
        if (!isSort()) {
            Quick quick = new Quick(array);
            quick.sort();
            this.array = (T[]) quick.getArray();
        }
        return binary(0, this.array.length, value);
    }

    int binary(int start,int finish, T value) {
        int result = -1;
        if (start == finish) {
            return value.equals(this.array[start]) ? start : -1;
        }
        int middle = ((finish - start) / 2) + start;
        if (this.array[middle] == value) {
            return middle;
        }
        if (compare(array[middle], value) < 0) {
            result = binary(middle + 1, finish, value);
        } else {
            result = binary(start, middle - 1, value);
        }
        return result;
    }
}
