package ru.job4j.sorting.merge;

import ru.job4j.sorting.insertion.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * This class represents array-sort.
 * @author Svyatoslav Sabirov.
 * @since 16.09.2018
 * @version 9.
 */
public class Merge<T> implements Sorting<T>, Comparator<T> {

    private T[] array;

    public Merge(T[] array) {
        this.array = array;
    }

    @Override
    public int compare(T o1, T o2) {
        return ((Comparable<? super T>) o1).compareTo(o2);
    }

    @Override
    public void sort() {
        this.array = divMerge(this.array);
    }

    private T[] divMerge(T[] subArray) {
        int len = subArray.length;
        if (len < 2) return subArray;
        int middle = len / 2;
        return merge(divMerge(Arrays.copyOfRange(subArray, 0, middle)),
                divMerge(Arrays.copyOfRange(subArray, middle, len)));
    }

    private T[] merge(T[] firstPart, T[] secondPart) {
        int lenFirst = firstPart.length, lenSecond = secondPart.length;
        int firstValue = 0, secondValue = 0, len = lenFirst + lenSecond;
        T[] result = (T[]) new Object[len];
        for (int i = 0; i < len; i++) {
            if (secondValue < lenSecond && firstValue < lenFirst) {
                if (compare(firstPart[firstValue], secondPart[secondValue]) > 0) {
                    result[i] = secondPart[secondValue++];
                }
                else result[i] = firstPart[firstValue++];
            } else if (secondValue < lenSecond) {
                result[i] = secondPart[secondValue++];
            } else {
                result[i] = firstPart[firstValue++];
            }
        }
        return result;
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
