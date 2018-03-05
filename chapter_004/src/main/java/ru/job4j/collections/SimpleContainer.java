package ru.job4j.collections;

/**
 * This class represents SimpleContainer.
 * @author Svyatoslav Sabirov.
 * @since 05.03.2018
 * @version 7.
 */
public interface SimpleContainer<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
}
