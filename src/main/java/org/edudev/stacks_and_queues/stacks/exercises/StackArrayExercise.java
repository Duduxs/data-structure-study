package org.edudev.stacks_and_queues.stacks.exercises;

import org.edudev.stacks_and_queues.stacks.StackArray;

public class StackArrayExercise {

    public void main() {
        final var stack = new StackArray(10);
        System.out.println(STR."Lista está vazia? \{stack.isEmpty()}");
        stack.push("Maria");
        stack.push("John");
        stack.push("Alice");
        System.out.println(STR."Lista está vazia? \{stack.isEmpty()}");

        while (!stack.isEmpty()) {
            // LIFO (Last in First Out) O primeiro a entrar é o último a sair
            // (1) Alice -> (2) John -> (3) Maria
            System.out.println(stack.pop());
        }
    }
}
