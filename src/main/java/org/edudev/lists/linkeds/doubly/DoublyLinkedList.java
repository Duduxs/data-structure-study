package org.edudev.lists.linkeds.doubly;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList<T> {

    private NodeDoubly<T> head;
    private NodeDoubly<T> tail;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public void addAtEnd(final T element) {
        var node = new NodeDoubly(element);

        if (isEmpty()) {
            setHead(node);
            setTail(node);
            setSize(getSize() + 1);
            return;
        }

        node.setPrev(getTail());
        getTail().setNext(node);
        setTail(node);
        setSize(getSize() + 1);
    }

    public void addAtStart(final T element) {
        var node = new NodeDoubly<>(element);

        if(isEmpty()) {
            setHead(node);
            setTail(node);
            setSize(getSize() + 1);
            return;
        }

        node.setNext(getHead());
        head.setPrev(node);
        setHead(node);
        setSize(getSize() + 1);
    }

    public List<T> toList() {
        var current = getHead();

        List<T> data = new ArrayList<>();

        while (current != null) {
            data.add(current.getValue());
            current = current.getNext();
        }

        return data;
    }

    public void show() {
        System.out.println("=======");
        toList().forEach(System.out::println);
        System.out.println("=======");
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public NodeDoubly<T> getHead() {
        return head;
    }

    public void setHead(NodeDoubly<T> head) {
        this.head = head;
    }

    public NodeDoubly<T> getTail() {
        return tail;
    }

    public void setTail(NodeDoubly<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
