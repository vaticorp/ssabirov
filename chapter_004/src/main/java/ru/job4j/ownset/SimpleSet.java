package ru.job4j.ownset;

import ru.job4j.collections.ArrayContainer;

import java.util.Iterator;

/**
 * This class represents SimpleSet.
 * @author Svyatoslav Sabirov.
 * @since 06.03.2018
 * @version 11.
 */
public class SimpleSet<E> implements Iterable<E> {

    private ArrayContainer<E> innerContainer = new ArrayContainer<E>(10);

    @Override
    public Iterator<E> iterator() {
        return innerContainer.iterator();
    }

    public void add(E value) {
        if (this.innerContainer.indexOf(value) != -1) {
            return;
        }
        this.innerContainer.add(value);
    }

    public int size() {
        return this.innerContainer.getSize();
    }
}
