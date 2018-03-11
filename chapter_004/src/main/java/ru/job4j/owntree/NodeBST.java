package ru.job4j.owntree;

import java.util.Comparator;

/**
 * This class represents NodeBST.
 * @author Svyatoslav Sabirov.
 * @since 11.03.2018
 * @version 7.
 */
public class NodeBST<T extends Comparable<T>> implements Comparable<T> {

    private NodeBST<T> leftChild;
    private NodeBST<T> rightChild;
    private NodeBST<T> parent;
    private T value;

    public NodeBST(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public NodeBST<T> getParent() {
        return parent;
    }

    public void setParent(NodeBST<T> parent) {

        this.parent = parent;
    }

    public NodeBST<T> getLeftChild() {
        return leftChild;
    }

    public NodeBST<T> getRightChild() {
        return rightChild;
    }

    public void setLeftChild(NodeBST<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(NodeBST<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(T o) {
        return this.value.compareTo(o);
    }
}
