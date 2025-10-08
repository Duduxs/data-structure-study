package org.edudev.tree.generic;

import java.util.ArrayList;
import java.util.List;

public final class GenericTree<T> {

    private Node<T> root;
    private int size;

    public Position<T> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }


    //    public List<T> getElements() {
//        return root != null ? root.getChildren().stream().map(Node::element).toList() : List.of();
//    }
    public Position<T> add(final T element, final Position<T> parent) {
        final var nodeParent = (Node<T>) parent;
        final var newNode = new Node<>(element, nodeParent);
        size += 1;

        if (parent == null) {
            root = newNode;
            return root;
        }

        nodeParent.addChild(newNode);
        return newNode;
    }

    public List<Position<T>> children(final Position<T> position) {
        final var node = validate(position);
        return new ArrayList<>(node.getChildren());
    }

//    public Position<T> find(final T element) {
//
//        if (root == null) return null;
//
//        var currentElement = root;
//
//        while (!currentElement.equals(element)) {
//
//                  currentElement = root.getChildren().getFirst().element();
//        }
//
//        return currentElement;
//    }

    public boolean isRoot(final Position<T> position) {
        return position.equals(root);
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    private Node<T> validate(final Position<T> position) {
        if (!(position instanceof Node<T> node)) {
            throw new IllegalArgumentException("Invalid position type.");
        }
        if (node.getParent().equals(node)) {
            throw new IllegalStateException("Position is no longer in the tree.");
        }
        return node;
    }

}
