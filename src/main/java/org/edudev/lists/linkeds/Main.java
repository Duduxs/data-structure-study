package org.edudev.lists.linkeds;

public class Main {

    void main() {
        var firstList = new LinkedList<Integer>();

        firstList.addAtEnd(20);
        firstList.addAtEnd(9);
        firstList.addAtEnd(86);
        firstList.addAtEnd(-2);
        firstList.addAtEnd(16);

        print(firstList);

        var secondList = new LinkedList<Integer>();
        secondList.addAtEnd(24);
        print(secondList);
    }

    void print(LinkedList list) {
        var currentHead = list.getHead();

        System.out.print("Elements: [ ");
        while (currentHead != null) {
            System.out.print(STR."\{currentHead.getValue()} ");
            currentHead = currentHead.getNext();
        }
        System.out.print("]");
        System.out.println(STR."\nSize: \{list.getSize()}\n");

    }
}
