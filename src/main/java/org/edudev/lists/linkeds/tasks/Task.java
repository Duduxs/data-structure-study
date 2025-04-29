package org.edudev.lists.linkeds.tasks;

import static org.edudev.lists.linkeds.tasks.TaskStatus.PENDING;

public final class Task {

    private final Integer id;
    private String description;
    private String tag;
    private TaskStatus status;

    public Task() {
        id = null;
        description = null;
        tag = null;
        status = PENDING;
    }

    public Task(final Integer id, final String description, final String tag) {
        this(id, description, tag, PENDING);
    }

    public Task(final Integer id, final String description, final String tag, final TaskStatus status) {
        this.id = id;
        this.description = description;
        this.tag = tag;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(final String tag) {
        this.tag = tag;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(final TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return STR."Task{id=\{id}, description='\{description}\{'\''}, tag='\{tag}\{'\''}, status=\{status}\{'}'}";
    }
}