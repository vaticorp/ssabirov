package ru.job4j.collections;

/**
 * This class represents Node.
 * @author Svyatoslav Sabirov.
 * @since 06.03.2018
 * @version 7.
 */
public class Node<T> {

    private T value;
    private Node<T> next;

    public boolean hasCycle(Node<T> first) {
        boolean result = false;
        Node<T> currentNode = first;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if (currentNode.equals(first)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
