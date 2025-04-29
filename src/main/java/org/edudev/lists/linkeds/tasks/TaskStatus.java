package org.edudev.lists.linkeds.tasks;

public enum TaskStatus {
    PENDING("Pending"),
    COMPLETED("Completed");

    private final String status;

    TaskStatus(String status) {
        this.status = status;
    }
}