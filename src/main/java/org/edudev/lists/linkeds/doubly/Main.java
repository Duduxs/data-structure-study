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

        System.out.println(STR."Elemento na posição 0: \{list.getNodeBy(0).getValue()}");
        System.out.println(STR."Elemento na posição -1: \{list.getNodeBy(-1)}");
        System.out.println(STR."Elemento na posição 6: \{list.getNodeBy(6).getValue()}");
        System.out.println(STR."Elemento na posição 7: \{list.getNodeBy(7)}");

    }
}
