package org.edudev.lists.linkeds.doubly;

public class Main {

    void main() {
        var list = new DoublyLinkedList<Integer>();

        list.addAtEnd(20);
        list.addAtEnd(9);
        list.addAtEnd(86);
        list.addAtEnd(-2);
        list.addAtEnd(16);
        list.addAtEnd(23);

        System.out.println(list.getHead().getValue());
        System.out.println(list.getTail().getValue());

    }
}
