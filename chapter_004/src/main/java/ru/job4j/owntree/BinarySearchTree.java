package ru.job4j.owntree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents BST.
 * @author Svyatoslav Sabirov.
 * @since 11.03.2018
 * @version 7.
 */
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

    private NodeBST<T> root;

    public BinarySearchTree(T value) {
        this.root = new NodeBST<T>(value);
    }

    public NodeBST<T> getRoot() {
        return root;
    }

    public void add(T value) {
        NodeBST<T> insertNode = new NodeBST<T>(value);
        NodeBST<T> currentNode = this.root;
        NodeBST<T> parent;
        while (true) {
            //левый потомок
            parent = currentNode;
            if (value.compareTo(currentNode.getValue()) <= 0) {
                currentNode = currentNode.getLeftChild();
                if (currentNode == null) {
                    parent.setLeftChild(insertNode);
                    insertNode.setParent(parent);
                    break;
                }
            //правый потомок
            } else {
                currentNode = currentNode.getRightChild();
                if (currentNode == null) {
                    parent.setRightChild(insertNode);
                    insertNode.setParent(parent);
                    break;
                }
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            NodeBST<T> nextNode = checkStartPosition();

            public NodeBST<T> checkStartPosition() {
                nextNode = root;
                while (nextNode.getLeftChild() != null) {
                    nextNode = nextNode.getLeftChild();
                }
                return nextNode;
            }

            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NodeBST<T> resultNode = nextNode;
                if (nextNode.getRightChild() != null) {
                    nextNode = nextNode.getRightChild();
                    while (nextNode.getLeftChild() != null) {
                        nextNode = nextNode.getLeftChild();
                    }
                    return resultNode.getValue();
                }
                while (true) {
                    if (nextNode.getParent() == null) {
                        nextNode = null;
                        return resultNode.getValue();
                    }
                    if (nextNode.getParent().getLeftChild() == nextNode) {
                        nextNode = nextNode.getParent();
                        return resultNode.getValue();
                    }
                    nextNode = nextNode.getParent();
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
