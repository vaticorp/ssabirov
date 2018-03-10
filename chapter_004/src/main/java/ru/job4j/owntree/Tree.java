package ru.job4j.owntree;

import java.util.*;

/**
 * This class represents Tree.
 * @author Svyatoslav Sabirov.
 * @since 09.03.2018
 * @version 7.
 */
public class Tree<T extends Comparable<T>> implements SimpleTree<T> {

    private Node<T> root;

    public Tree(T value) {
        this.root = new Node<T>(value);
    }

    @Override
    public boolean add(T parent, T child) {
        Optional<Node<T>> optionalNode = findBy(parent);
        if (!optionalNode.isPresent()) {
            throw new NoSuchNodeException("В дереве отсутствует родитель с таким значением!");
        }
        Node<T> nodeParent = optionalNode.get();
        optionalNode = findBy(child);
        Node<T> nodeChild = optionalNode.isPresent() ? optionalNode.get() : new Node<T>(child);
        nodeParent.add(nodeChild);
        return true;
    }

    @Override
    public Optional<Node<T>> findBy(T value) {
        Optional<Node<T>> rsl = Optional.empty();
        Queue<Node<T>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<T> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<T> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public boolean isBinary() {
        boolean result = true;
        Queue<Node<T>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            List<Node<T>> childs = data.poll().leaves();
            if (childs.size() > 2) {
                result = false;
                break;
            }
            for (Node<T> child : childs) {
                data.offer(child);
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private Queue<Node<T>> nodeQueue = fillQueue(root);

            public Queue<Node<T>> fillQueue(Node<T> node) {
                Queue<Node<T>> currentQueue = new LinkedList<>();
                addNodeToQueue(node, currentQueue);
                return currentQueue;
            }

            public void addNodeToQueue(Node<T> node, Queue<Node<T>> currentQueue) {
                currentQueue.offer(node);
                for (Node<T> currentNode : node.leaves()) {
                    addNodeToQueue(currentNode, currentQueue);
                }
            }

            @Override
            public boolean hasNext() {
                return nodeQueue.size() > 0;
            }

            @Override
            public T next() {
                Node<T> resultNode = nodeQueue.poll();
                return resultNode.getValue();
            }
        };
    }
}
