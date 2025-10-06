package org.edudev.tree.generic;

public final class GenericTree<T> {

    private final Node<T> root;
    private final int size;

    public GenericTree() {
        this.root = null;
        this.size = 0;
    }

    public Position<T> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

//    public Position<T> find(final T element) {
//
//        var currentElement = root.element();
//
//        while(!currentElement.equals(element)) {
//            if(root.get)
//            currentElement = root.getChildren().getFirst().element();
//        }
//
//        return root.element().equals(element) ? root : root.getChildren().stream().filter(child -> child.g)
//    }

    public boolean isRoot(final Position<T> position) {
        return position.equals(root);
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

}
