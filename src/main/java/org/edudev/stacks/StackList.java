package org.edudev.stacks;

import java.util.ArrayList;
import java.util.List;

public final class StackList<T> {

    private List<T> stack = new ArrayList<>();

    public void push(final T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        final var element = stack.get(stack.size() - 1);
        stack.remove(element);
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public int count() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void clear() {
        stack.clear();
    }
}
