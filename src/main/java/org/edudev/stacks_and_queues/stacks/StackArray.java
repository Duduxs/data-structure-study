package org.edudev.stacks_and_queues.stacks;

public final class StackArray {

    private int size = 100;
    private int top = -1;
    private String[] stack = new String[size];

    public StackArray(final int size) {
        this.size = size;
    }

    public void push(final String item) {
        stack[++top] = item;
    }

    public String pop() {
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

}
