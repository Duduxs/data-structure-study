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

        System.out.println(STR."Elemento na posição 0: \{list.getBy(0)}");
        System.out.println(STR."Elemento na posição -1: \{list.getBy(-1)}");
        System.out.println(STR."Elemento na posição 6: \{list.getBy(6)}");
        System.out.println(STR."Elemento na posição 7: \{list.getNodeBy(7)}");

    }
}
