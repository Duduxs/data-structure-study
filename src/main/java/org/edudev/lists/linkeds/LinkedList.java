package org.edudev.lists.linkeds;

import org.edudev.lists.Node;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

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

    public void addAtPosition(final T element, final int index) {
        var node = new Node<>(element);
        var previousNode = getNodeBy(index - 1);

        if (previousNode == null) {
            addAtEnd(node.getValue());
            return;
        }

        var aux = previousNode.getNext();
        previousNode.setNext(node);
        node.setNext(aux);
        setSize(getSize() + 1);
    }

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

    public T removeAtPosition(final int index) {
        if (isEmpty() || getElementBy(index) == null) {
            return null;
        }

        T item;
        Node<T> aux;

        if (index == 0) {
            item = getHead().getValue();
            this.head = this.head.getNext();
            setSize(size - 1);
            return item;
        }

        if (index == getSize() - 1) {
            item = getElementBy(index);
            aux = getNodeBy(index - 1);
            aux.setNext(null);
            setSize(size - 1);
            return item;
        }

        aux = getNodeBy(index - 1);
        item = aux.getValue();
        aux.setNext(aux.getNext().getNext());
        setSize(size - 1);

        return item;


    /* Também poderia ser da forma abaixo
    if (index == 0) {
            var current = getHead();
            var next = current.getNext();
            this.head = next;
            setSize(size - 1);
            return current;
        }

        var current = getNodeBy(index);
        var previous = getNodeBy(index - 1);

        if (current == null) return null;

        var next = current.getNext();
        previous.setNext(next);
        setSize(size - 1);

        return current;*/
    }

    public boolean isEmpty() {
        return getHead() == null;
    }

    public void clear() {
        setHead(null);
        setSize(0);
    }

    public int indexOf(final T element) {
        var current = getHead();
        var i = 0;

        while (current != null) {
            if (element == current.getValue()) return i;
            i++;
            current = current.getNext();
        }

        return -1;
    }

    public boolean contains(final T element) {
        return indexOf(element) != -1;
    }

    public T getElementBy(final int index) {
        var node = getNodeBy(index);
        return node != null ? node.getValue() : null;
    }

    public Node<T> getNodeBy(final int index) {
        if (index < 0 || index > getSize()) return null;

        var current = getHead();
        var i = 0;

        while (i != index) {
            current = current.getNext();
            i++;
        }

        return current;

        /*
        Também poderia ser da forma abaixo
        if (isEmpty() || index < 0 || index > getSize()) return null;

        Node<T> current;
        var j = 0;

        for (current = getHead(); current != null; current = current.getNext(), j++) {
            if (j == index) break;
        }

        return current
        ;*/
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
