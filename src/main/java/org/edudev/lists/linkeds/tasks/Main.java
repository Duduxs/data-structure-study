package org.edudev.lists.linkeds.tasks;

import static org.edudev.lists.linkeds.tasks.TaskStatus.COMPLETED;

public class Main {

    public static void main(String[] args) {
        var task1 = new Task(1, "Daily with a team", "meeting");
        var task2 = new Task(2, "Implementing some feature", "job", COMPLETED);
        var taskList1 = new TaskList();
        taskList1.add(task1);
        taskList1.add(task2, 0);

        taskList1.getTasks().print();
    }
}