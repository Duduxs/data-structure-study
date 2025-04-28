package org.edudev.lists.linkeds;

public class Main {

    void main() {
        var firstList = new LinkedList<Integer>();

        // 0 -> 20 -> 9 -> 86 -> -2 -> 16 -> NULL
        firstList.addAtEnd(20);
        firstList.addAtEnd(9);
        firstList.addAtEnd(86);
        firstList.addAtEnd(-2);
        firstList.addAtEnd(16);
        firstList.addAtStart(0);


        // 0 -> 20 -> 9 ->  40 -> 86 -> -2 -> 16 -> Null
        firstList.addAtPosition(40, 2);
        firstList.print();
        // 0 -> 20 -> 9 ->  40 -> 86 -> -2 -> 16 -> 90 -> Null
        firstList.addAtPosition(90, 30);
        firstList.print();

        System.out.println(STR."Posição de 40: \{firstList.indexOf(40)}");
        System.out.println(STR."Posição de 37: \{firstList.indexOf(37)}");

        var node = firstList.getNodeBy(1);
        System.out.println(node.getValue());
        System.out.println(firstList.getElementBy(0));
        System.out.println(firstList.getElementBy(5));
        System.out.println(firstList.getElementBy(6));
        System.out.println(firstList.getElementBy(-5));
        System.out.println();

        var secondList = new LinkedList<Integer>();
        secondList.addAtEnd(24);
        secondList.print();
        System.out.println(STR."\n Segundo lista está vazia? \{secondList.isEmpty()}");
        secondList.clear();
        System.out.println(STR."\n Segundo lista está vazia? \{secondList.isEmpty()}");

        var thirdList = new LinkedList<Integer>();
        System.out.println(STR."\n Terceira lista está vazia? \{thirdList.isEmpty()}");
        thirdList.addAtStart(10);
        thirdList.print();

        var fourthList = new LinkedList<Integer>();
        fourthList.addAtPosition(4, 0);
        fourthList.print();
    }
}
