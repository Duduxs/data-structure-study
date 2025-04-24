package org.edudev.lists.linkeds;

import org.edudev.lists.Node;

public class Main {

    void main() {
        var a = new Node<>(20);
        var b = new Node<>(9);
        var c = new Node<>(86);
        var d = new Node<>(-2);
        var e = new Node<>(16);

        // A -> B -> C -> D -> E -> NULL
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);

        var firstList = new LinkedList<Integer>();
        firstList.addAtEnd(e);
        print(firstList);
        System.out.println();

        var newNode = new Node(23);

        var secondList = new LinkedList<Integer>();
        secondList.addAtEnd(a);
        secondList.addAtEnd(newNode);
        print(secondList);
    }

    void print(LinkedList list) {
        var currentHead = list.getHead();

        while (currentHead != null) {
            System.out.print(STR."\{currentHead.getValue()} ");
            currentHead = currentHead.getNext();
        }

    }
}
