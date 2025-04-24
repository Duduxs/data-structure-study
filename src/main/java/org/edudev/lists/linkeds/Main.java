package org.edudev.lists.linkeds;

public class Main {

    void main() {
        var firstList = new LinkedList<Integer>();

        firstList.addAtEnd(20);
        firstList.addAtEnd(9);
        firstList.addAtEnd(86);
        firstList.addAtEnd(-2);
        firstList.addAtEnd(16);
        firstList.addAtStart(0);

        // 0 -> 20 -> 9 -> 86 -> -2 -> 16 -> NULL

        firstList.print();

        var secondList = new LinkedList<Integer>();
        secondList.addAtEnd(24);
        secondList.print();
        System.out.println(STR."\n Segundo lista está vazia? \{secondList.isEmpty()}");
        secondList.clear();
        System.out.println(STR."\n Segundo lista está vazia? \{secondList.isEmpty()}");

        var thirdList = new LinkedList<Integer>();
        System.out.println(STR."\n Terceira lista está vazia? \{thirdList.isEmpty()}");
        thirdList.addAtEnd(10);
        thirdList.print();
    }
}
