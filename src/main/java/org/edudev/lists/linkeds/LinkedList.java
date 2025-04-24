package org.edudev.lists.linkeds;

import org.edudev.lists.Node;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public void addAtStart(final T element) {
        var node = new Node<>(element);

        if (isEmpty()) {
            setHead(node);
            return;
        }

        var aux = getHead();
        setHead(node);
        node.setNext(aux);

        /**
         * Também poderia ser dessa forma
         * node.setNext(getHead());
         * setHead(node);
         */
    }

    public void addAtEnd(final T element) {
        final var node = new Node<>(element);

        var current = head;

        if (current == null) {
            setHead(node);
            return;
        }

        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(node);
        setSize(size + 1);
    }

    public void print() {
        var currentHead = getHead();

        System.out.print("Elements: [ ");
        while (currentHead != null) {
            System.out.print(STR."\{currentHead.getValue()} ");
            currentHead = currentHead.getNext();
        }
        System.out.print("]");

        System.out.println(STR."\nSize: \{getSize()}\n");
    }

    public boolean isEmpty() {
        return getHead() == null;
    }

    public void clear() {
        setHead(null);
        setSize(0);
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
        setSize(size += 1);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
