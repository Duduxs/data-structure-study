package org.edudev.lists.linkeds;

import org.edudev.lists.Node;

public class Main {

    void main() {
        var a = new Node<>("A");
        var b = new Node<>("B");
        var c = new Node<>("C");

        // A -> B -> C
        a.setNext(b);
        b.setNext(c);

        System.out.println(a.getValue());
        System.out.println(a.getNext().getValue());
        System.out.println(a.getNext().getNext().getValue());
    }
}
