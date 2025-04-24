package org.edudev.lists.linkeds;

import org.edudev.lists.Node;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

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
