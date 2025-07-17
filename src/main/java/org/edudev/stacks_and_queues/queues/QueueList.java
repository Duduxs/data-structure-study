package org.edudev.stacks_and_queues.queues;

import java.util.ArrayList;
import java.util.List;

public final class QueueList<T> {

    private final List<T> queue = new ArrayList<>();

    public void add(final T item) {
        queue.add(item);
    }

    public T remove() {
        return queue.removeFirst();
    }

    public T peek() {
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int count() {
        return queue.size();
    }
}
