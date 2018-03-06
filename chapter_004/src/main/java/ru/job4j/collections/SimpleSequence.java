package ru.job4j.collections;

/**
 * This class represents SimpleSequence.
 * @author Svyatoslav Sabirov.
 * @since 06.03.2018
 * @version 7.
 */
public interface SimpleSequence<T> {
    T poll();
    void push(T value);
}
