package org.edudev.lists.linkeds.tasks;

import static org.edudev.lists.linkeds.tasks.TaskStatus.COMPLETED;

public class Main {

    public static void main(String[] args) {
        var task1 = new Task(1, "Daily with a team", "meeting");
        var task2 = new Task(2, "Implementing some feature", "job", COMPLETED);

        System.out.println(task1);
        System.out.println(task2);
    }
}