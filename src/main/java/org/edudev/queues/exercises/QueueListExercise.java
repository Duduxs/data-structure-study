package org.edudev.queues.exercises;

import org.edudev.queues.QueueList;

public class QueueListExercise {

    public void main() {
        final var queue = new QueueList<String>();

        System.out.println(STR."Is the queue empty? \{queue.isEmpty()}");
        System.out.println(STR."Queue size: \{queue.count()}");

        queue.add("Maria");
        queue.add("Joao");
        queue.add("Ana");

        System.out.println(STR."Is the queue empty? \{queue.isEmpty()}");
        System.out.println(STR."Queue size: \{queue.count()}");

        while(!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

        System.out.println(STR."Is the queue empty? \{queue.isEmpty()}");
        System.out.println(STR."Queue size: \{queue.count()}");

        queue.add("Roberto");
        System.out.println(STR."Novo registro: \{queue.peek()}");
        System.out.println(STR."Is the queue empty? \{queue.isEmpty()}");
        System.out.println(STR."Queue size: \{queue.count()}");
    }
}
