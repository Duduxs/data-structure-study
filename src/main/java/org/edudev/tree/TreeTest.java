package org.edudev.tree;

import org.edudev.tree.generic.GenericTree;
import org.edudev.tree.generic.Position;

public class TreeTest {

    void main() {
        final var tree = new GenericTree<>();
        final var root = tree.add("Livro azul", null);

        final var introduction = tree.add("Introdução", root);
        final var cap1 = tree.add("Capítulo 1", root);
        final var cap2 = tree.add("Capítulo 2", root);

        tree.add("Para quem é este livro", introduction);
        tree.add("Agradecimentos", introduction);

        print(tree);
    }

    static <T> void print(final GenericTree<T> tree) {
        if(tree.isEmpty()) return;
        System.out.println("=== Árvore ===");
        printRecursive(tree, tree.getRoot(), 0);
        System.out.println("=== Árvore ===");
    }

    private static <T> void printRecursive(final GenericTree<T> tree, final Position<T> position, final int depth) {
        final var spacing = "\t".repeat(depth);
        System.out.println(spacing + position.element());

        final var children = tree.children(position);
        children.forEach(child -> printRecursive(tree, child, depth + 1));
    }
}
