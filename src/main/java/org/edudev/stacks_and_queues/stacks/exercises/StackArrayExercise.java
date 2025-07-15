package org.edudev.stacks_and_queues.stacks.exercises;

import org.edudev.stacks_and_queues.stacks.StackArray;

public class StackArrayExercise {

    public void main() {
        final var stack = new StackArray(4);
        System.out.println(STR."Pilha está vazia? \{stack.isEmpty()}");
        System.out.println(STR."Tamanho da pilha: \{stack.count()}");
        System.out.println(STR."Pilha está cheia? \{stack.isFull()}");
        stack.push("Maria");
        stack.push("John");
        stack.push("Alice");
        System.out.println(STR."Pilha está vazia? \{stack.isEmpty()}");
        System.out.println(STR."Tamanho da pilha: \{stack.count()}");
        System.out.println(STR."Pilha está cheia? \{stack.isFull()}");
        System.out.println(STR."Topo da pilha: \{stack.peek()}");

        stack.push("Bob");
        System.out.println(STR."Tamanho da pilha: \{stack.count()}");
        System.out.println(STR."Pilha está cheia? \{stack.isFull()}");
        System.out.println(STR."Topo da pilha: \{stack.peek()}");

        //stack.push("Charlie ERROR");

        System.out.println();
        while (!stack.isEmpty()) {
            // LIFO (Last in First Out) O primeiro a entrar é o último a sair
            // (1) Alice -> (2) John -> (3) Maria
            System.out.println(stack.pop());
        }

        //stack.pop(); //Vai lançar um erro, pois a pilha está vazia
        //stack.peek(); //Vai lançar um erro, pois a pilha está vazia
    }
}
