package org.edudev.stacks_and_queues.stacks;

public final class StackArray {

    private int size;
    private int top = -1;
    private String[] stack;

    public StackArray(final int size) {
        this.size = size;
        this.stack = new String[size];
    }

    public void push(final String item) {
        if(isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = item;
    }

    public String pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    public String peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public int count() {
        return top + 1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

}
