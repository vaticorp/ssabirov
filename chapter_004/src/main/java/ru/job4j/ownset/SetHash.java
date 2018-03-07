package ru.job4j.ownset;

/**
 * This class represents
 * @author Svyatoslav Sabirov.
 * @since 07.03.2018
 * @version 7.
 */
public class SetHash<E> {

    private HashTableOverride<E> hashTable = new HashTableOverride<E>();

    public boolean add(E value) {
        return this.hashTable.add(value);
    }

    public boolean contains(E value) {
        return this.hashTable.contains(value);
    }

    public boolean remove(E value) {
        return this.hashTable.remove(value);
    }
}
