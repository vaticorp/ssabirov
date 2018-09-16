package ru.job4j.sorting.insertion;

/**
 * This class represents Simple interface for sorting.
 * @author Svyatoslav Sabirov.
 * @since 16.09.2018
 * @version 7.
 */
public interface Sorting<T> {
    void sort();
    void print();
    T value(int index);
}
