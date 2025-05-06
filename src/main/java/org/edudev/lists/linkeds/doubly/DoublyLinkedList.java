package org.edudev.lists.linkeds.doubly;

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
