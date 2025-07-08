package org.edudev.lists.linkeds.doubly;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList<T> {

    private NodeDoubly<T> head;
    private NodeDoubly<T> tail;
    private int size;

    public T getBy(final int index) {
        var node = getNodeBy(index);
        return node != null ? node.getValue() : null;
    }

    public NodeDoubly<T> getNodeBy(final int index) {
        if (index < 0 || index >= getSize())
            return null;

        var current = getHead();
// 1 Opção for(var i = 0 ; i < index && current != null ; i++, current = current.getNext()) { }

        for (var i = 0; i < index && current != null; i++) {
            current = current.getNext();
        }

        return current;
    }

    public int indexOf(final T element) {
        var current = getHead();
        var index = 0;

        while (current != null) {

            if (current.getValue().equals(element))
                return index;

            current = current.getNext();
            index++;
        }

        return -1;
    }

    public boolean contains(final T element) {
        return indexOf(element) != -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addAtStart(final T element) {
        var node = new NodeDoubly<>(element);

        if (isEmpty()) {
            setHead(node);
            setTail(node);
            setSize(1);
            return;
        }

        node.setNext(getHead());
        head.setPrev(node);
        setHead(node);
        setSize(getSize() + 1);
    }

    public void addAtPosition(final int index, final T element) {
        final var currentElement = getNodeBy(index - 1);

        if (index == 0) {
            addAtStart(element);
            return;
        }

        if (currentElement == null) {
            addAtEnd(element);
            return;
        }

        final var node = new NodeDoubly<>(element);

        node.setNext(currentElement.getNext());
        node.setPrev(currentElement.getPrev());
        currentElement.setNext(node);
        currentElement.setPrev(node);

        setSize(getSize() + 1);
    }

    public void addAtEnd(final T element) {
        var node = new NodeDoubly(element);

        if (isEmpty()) {
            setHead(node);
            setTail(node);
            setSize(1);
            return;
        }

        node.setPrev(getTail());
        getTail().setNext(node);
        setTail(node);
        setSize(getSize() + 1);
    }

    public boolean remove(final T element) {
        final var index = indexOf(element);

        if (index != -1) {
            removeAtPosition(index);
            return true;
        }

        return false;
    }

    public NodeDoubly<T> removeAtStart() {
        final var head = getHead();

        if (head == null || head.getValue() == null) {
            setHead(null);
            setTail(null);
            setSize(0);
            return null;
        }
        final var headNext = head.getNext();
        headNext.setPrev(null);
        setHead(headNext);
        setSize(getSize() - 1);
        return head;
    }

    public NodeDoubly<T> removeAtPosition(final int index) {
        final var currentElement = getNodeBy(index);

        if (index == 0)
            return removeAtStart();
        else if (index == getSize() - 1)
            return removeAtEnd();
        else if (currentElement == null)
            return null;

        final var previous = currentElement.getPrev();
        final var next = currentElement.getNext();

        previous.setNext(next);
        next.setPrev(previous);
        setSize(getSize() - 1);
        return currentElement;
    }

    public NodeDoubly<T> removeAtEnd() {
        final var tail = getTail();

        if (tail == null || tail.getPrev() == null) {
            setHead(null);
            setTail(null);
            setSize(0);
            return null;
        }

        final var tailPrev = tail.getPrev();
        tailPrev.setNext(null);
        setTail(tailPrev);
        setSize(getSize() - 1);
        return tail;
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
