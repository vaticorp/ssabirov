package ru.job4j.sorting.quicksort;


import org.apache.commons.lang.ArrayUtils;
import ru.job4j.sorting.insertion.Sorting;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;


/**
 * This class represents class for quick sort.
 * @author Svyatoslav Sabirov.
 * @since 17.09.2018
 * @version 10.
 */
public class Quick<T> implements Sorting<T>,Comparator<T> {

    private T[] array;

    public Quick(T[] array) {
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
        T value = subArray[middle];
        T[] leftArray = (T[]) Stream.of(subArray).filter(s -> compare(s, value) < 0).toArray();
        T[] rightArray = (T[]) Stream.of(subArray).filter(s -> compare(s, value) > 0).toArray();
        T[] firstArray = (T[]) ArrayUtils.add(divMerge(leftArray), value);
        return (T[]) ArrayUtils.addAll(firstArray, divMerge(rightArray));
    }

    @Override
    public void print() {
        Stream.of(array).forEach(s -> System.out.println(s));
    }

    @Override
    public T value(int index) {
        return this.array[index];
    }

    public static void main(String[] args) {
        Integer[] array = {1,9,8,3,2,6,4};
        Sorting<Integer> quick = new Quick<Integer>(array);
        quick.sort();
        quick.print();
    }
}
