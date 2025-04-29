package org.edudev.lists.linkeds.tasks;

import org.edudev.lists.linkeds.LinkedList;

public class TaskList {

    private LinkedList tasks = new LinkedList<Task>();

    public LinkedList getTasks() {
        return tasks;
    }
}
