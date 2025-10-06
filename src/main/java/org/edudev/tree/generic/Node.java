package org.edudev.tree.generic;

import java.util.ArrayList;
import java.util.List;

final class Node<T> implements Position<T> {

    private Node<T> parent;
    private T element;
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

    @Override
    public T element() {
        return element;
    }

    public void setElement(final T element) {
        this.element = element;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(final Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void addChild(final Node<T> child) {
        children.add(child);
        child.parent = this;
    }

    public void removeChild(final Node<T> child) {
        children.remove(child);
        child.parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }
}
