package org.edudev.stacks_and_queues.stacks.exercises;

import org.edudev.stacks_and_queues.stacks.StackList;

public class StackListExercise {

    public void main() {
        final var stack = new StackList<String>();
        System.out.println(STR."Pilha está vazia? \{stack.isEmpty()}");
        System.out.println(STR."Tamanho da pilha: \{stack.count()}");
        stack.push("Maria");
        stack.push("John");
        stack.push("Alice");
        System.out.println(STR."Pilha está vazia? \{stack.isEmpty()}");
        System.out.println(STR."Tamanho da pilha: \{stack.count()}");;
        System.out.println(STR."Topo da pilha: \{stack.peek()}");

        stack.push("Bob");
        System.out.println(STR."Tamanho da pilha: \{stack.count()}");
        System.out.println(STR."Topo da pilha: \{stack.peek()}");

//        stack.clear();
//        System.out.println(STR."Pilha está vazia? \{stack.isEmpty()}");
//        System.out.println(STR."Tamanho da pilha: \{stack.count()}");

        System.out.println();
        while (!stack.isEmpty()) {
            // LIFO (Last in First Out) O primeiro a entrar é o último a sair
            // (1) Bob -> (2) Alice -> (3) John -> (4) Maria
            System.out.println(stack.pop());
        }

        //stack.pop(); //Vai lançar um erro, pois a pilha está vazia
        //stack.peek(); //Vai lançar um erro, pois a pilha está vazia
    }

    }
