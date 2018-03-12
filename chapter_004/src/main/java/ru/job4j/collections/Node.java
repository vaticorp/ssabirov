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

    public Node(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasCycle(Node<T> first) {
        boolean result = false;
        Node<T> currentNode = first;
        StringBuilder hashBuilder = new StringBuilder(String.valueOf(first.hashCode()));
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            String currentHash = String.valueOf(currentNode.hashCode());
            if (hashBuilder.indexOf(currentHash) != -1) {
                result = true;
                break;
            }
            hashBuilder.append(currentHash);
        }
        return result;
    }
}
