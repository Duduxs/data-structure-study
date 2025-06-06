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

        list.show();
        System.out.println(STR."Tamanho da lista: \{list.getSize()}");
        System.out.println();

        list.addAtStart(100);

        list.show();
        System.out.println(STR."Tamanho da lista: \{list.getSize()}");

    }
}
