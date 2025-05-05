package org.edudev.lists.linkeds.tasks;

import java.util.ArrayList;
import java.util.List;
import org.edudev.lists.Node;
import org.edudev.lists.linkeds.LinkedList;
import static org.edudev.lists.linkeds.tasks.TaskStatus.COMPLETED;

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

    public boolean remove(int id) {
        var task = getTaskById(id);
        if (task == null) return false;
        return getTasks().remove(task);
    }

    public Task setTaskToCompleted(final int id) {
        final var task = getTaskById(id);
        if (task == null) return null;

        task.setStatus(COMPLETED);
        return task;
    }

    public Task setTaskDataById(final int id, final Task data) {
        final var task = getTaskById(id);
        if (task == null) return null;
        task.setDescription(data.getDescription());
        task.setStatus(data.getStatus());
        task.setTag(data.getTag());
        return task;
    }

    public List<Task> getTasksByTag(final String tag) {
        var current = getTasks().getHead();
        List<Task> list = new ArrayList<>();

        while (current != null) {
            if (current.getValue() instanceof Task t && t.getTag().equalsIgnoreCase(tag)) {
                list.add(t);
            }
            current = current.getNext();
        }

        return list;
    }

    public Task getTaskById(final int id) {
        var current = getTasks().getHead();

        while (current != null) {
            if (current.getValue() instanceof Task t && t.getId().equals(Integer.valueOf(id))) {
                return t;
            }
            current = current.getNext();
        }

        return null;
    }

    public Task move(final int id, final int targetIndex) {
        if (targetIndex < 0 || targetIndex > getTasks().getSize()) {
            return null;
        }

        final var taskItem = getTaskById(id);
        final var sourceIndex = getTasks().indexOf(taskItem);

        if (taskItem != null && sourceIndex != targetIndex) {
            getTasks().removeAtPosition(sourceIndex);
            getTasks().addAtPosition(taskItem, targetIndex);
            return taskItem;
        }

        return null;
/*
    Também poderia ser dessa forma abaixo
        final var task = getTaskById(id);
        final var sourceIndex = getTasks().indexOf(task);

        if (task == null || sourceIndex == targetIndex) return null;

        getTasks().removeAtPosition(sourceIndex);
        getTasks().addAtPosition(task, targetIndex);

        return task;*/
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
