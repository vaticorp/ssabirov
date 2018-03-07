package ru.job4j.ownset;

import ru.job4j.collections.ArrayContainer;

import java.util.Hashtable;

/**
 * This class represents HashTableOverride
 * @since 07.03.2018
 * @author Svyatoslav Sabirov.
 * @version 7.
 */
public class HashTableOverride<E> {

    private ArrayContainer<E> innerContainer = new ArrayContainer<E>(10);

    public boolean add(E value) {
        int hash = getHash(value);
        return this.innerContainer.set(hash, value);
    }

    public int getHash(E value) {
        int number = this.innerContainer.getLength();
        int index = (value.hashCode()) % (number == 0 ? 1 : number);
        return index;
    }

    public boolean contains(E value) {
        return this.innerContainer.contains(value);
    }

    public boolean remove(E value) {
        return this.innerContainer.remove(value);
    }

}
