package org.edudev.lists.linkeds.tasks;

import java.util.List;
import org.edudev.lists.Node;
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

    public void show() {
        getTasksAsList().forEach(node -> show(node.getValue()));
    }

    public void show(final Task task) {
        if (task == null) {
            System.out.println("Task not found");
            return;
        }
        System.out.println(task);
    }

    public LinkedList getTasks() {
        return tasks;
    }

    public List<Node<Task>> getTasksAsList() {
        return getTasks().toList();
    }

}
