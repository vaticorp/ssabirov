package ru.job4j.ownset;

import ru.job4j.collections.ArrayContainer;
import ru.job4j.collections.LinkedListContainer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class represents SimpleLinkedSet.
 * @author Svyatoslav Sabirov.
 * @since 07.03.2018
 * @version 7.
 */
public class SimpleLinkedSet<E> implements Iterable<E> {

    private LinkedListContainer<E> innerContainer = new LinkedListContainer<E>();

    @Override
    public Iterator<E> iterator() {
        return innerContainer.iterator();
    }

    public void add(E value) {
        if (!this.innerContainer.contains(value)) {
            this.innerContainer.add(value);
        }
    }

    public int size() {
        return this.innerContainer.getSize();
    }
}
