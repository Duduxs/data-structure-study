package org.edudev.lists.linkeds.tasks;

import org.edudev.lists.linkeds.LinkedList;

public class TaskList {

    private LinkedList tasks = new LinkedList<Task>();

    public void add(final Task task) {
        add(task, -1);
    }

    public void add(final Task task, final int index) {
        if (index < 0) {
            getTasks().addAtEnd(task);
            return;
        }

        if (getTasks().getElementBy(index) == null) {
            return;
        }

        getTasks().addAtPosition(task, index);
    }

    public LinkedList getTasks() {
        return tasks;
    }

}
