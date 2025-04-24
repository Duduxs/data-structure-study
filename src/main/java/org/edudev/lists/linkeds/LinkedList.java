package org.edudev.lists.linkeds;

import org.edudev.lists.Node;

public class LinkedList<T> {

    private Node<T> head;
    private int size;



    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
