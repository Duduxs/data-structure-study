package org.edudev.tree.generic;

import java.util.ArrayList;
import java.util.List;

public final class Node<T> implements Position<T> {

    private final Node<T> parent;
    private final T element;
    private final List<Node<T>> children = new ArrayList<>();

    private Node() {
        this.parent = null;
        this.element = null;
    }

    public Node(final T element) {
        this(element, null);
    }

    public Node(final T element, final Node<T> parent) {
        this.element = element;
        this.parent = parent;
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    @Override
    public T element() {
        return element;
    }
}
