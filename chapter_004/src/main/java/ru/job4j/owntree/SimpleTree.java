package ru.job4j.owntree;

/**
 * This class represents SimpleTree.
 * @author Svyatoslav Sabirov.
 * @since 09.03.2018
 * @version 7.
 */
import java.util.Optional;

public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return
     */
    boolean add(E parent, E child);
    Optional<Node<E>> findBy(E value);
}