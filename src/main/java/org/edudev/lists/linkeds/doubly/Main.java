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
        System.out.println();

        System.out.println(STR."Elemento na posição 0: \{list.getBy(0)}");
        System.out.println(STR."Elemento na posição -1: \{list.getBy(-1)}");
        System.out.println(STR."Elemento na posição 6: \{list.getBy(6)}");
        System.out.println(STR."Elemento na posição 7: \{list.getNodeBy(7)}");
        System.out.println();

        list.addAtPosition(2, 50);
        list.show();
        System.out.println(STR."Tamanho da lista: \{list.getSize()}");
        System.out.println();

        list.addAtPosition(-1, 99);
        list.show();
        System.out.println(STR."Tamanho da lista: \{list.getSize()}");
        System.out.println();

        list.addAtPosition(0, 0);
        list.show();
        System.out.println(STR."Tamanho da lista: \{list.getSize()}");
        System.out.println();

        System.out.println(STR."Índice do elemento 99: \{list.indexOf(99)} e existe? \{list.contains(99)}");
        System.out.println(STR."Índice do elemento 100: \{list.indexOf(100)} e existe? \{list.contains(100)}");
        System.out.println(STR."Índice do elemento 101: \{list.indexOf(101)} e existe? \{list.contains(101)}");
        System.out.println();

        list.removeAtStart();
        list.show();
        System.out.println(STR."Tamanho da lista após remover no começo: \{list.getSize()}");
        System.out.println();

        list.removeAtStart();
        list.show();
        System.out.println(STR."Tamanho da lista após remover no começo: \{list.getSize()}");
        System.out.println();

        list.removeAtEnd();
        list.show();
        System.out.println(STR."Tamanho da lista após remover no final: \{list.getSize()}");
        System.out.println();

        list.removeAtPosition(3);
        list.show();
        System.out.println(STR."Tamanho da lista após remover posição (3): \{list.getSize()}");
        System.out.println();

        list.removeAtPosition(0);
        list.show();
        System.out.println(STR."Tamanho da lista após remover posição (0): \{list.getSize()}");
        System.out.println();

        list.removeAtPosition(4);
        list.show();
        System.out.println(STR."Tamanho da lista após remover posição (4): \{list.getSize()}");
        System.out.println();

        list.removeAtPosition(4);
        list.show();
        System.out.println(STR."Tamanho da lista após remover posição (4): \{list.getSize()}");
        System.out.println();

    }
}
