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
        Node<T> rabbit = first;
        Node<T> turtle = first;
        while (true) {
            turtle = turtle.next;
            if (rabbit.next != null) {
                rabbit = rabbit.next.next;
            } else {
                break;
            }
            if (rabbit == null || turtle == null) {
                break;
            }
            if (rabbit == turtle) {
                result = true;
                break;
            }
        }
        return result;
    }
}
