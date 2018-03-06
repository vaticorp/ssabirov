package ru.job4j.collections;

/**
 * This class represents SimpleStack.
 * @author Svyatoslav Sabirov.
 * @since 06.03.2018
 * @version 7.
 */
public class SimpleStack<T> implements SimpleSequence<T> {

    private LinkedListContainer<T> linkedContainer = new LinkedListContainer<T>();

    @Override
    public T poll() {
        T returnObject = this.linkedContainer.getLast(0);
        this.linkedContainer.removeLast();
        return returnObject;
    }

    @Override
    public void push(T value) {
        this.linkedContainer.add(value);
    }
}
