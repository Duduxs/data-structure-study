package org.edudev.tree;

import org.edudev.tree.generic.GenericTree;

public class TreeTest {

    void main() {
        final var tree = new GenericTree<>();
        final var root = tree.add("Livro azul", null);

        final var introduction = tree.add("Introdução", root);
        final var cap1 = tree.add("Capítulo 1", root);
        final var cap2 = tree.add("Capítulo 2", root);

        System.out.println(cap2.element());
    }
}
