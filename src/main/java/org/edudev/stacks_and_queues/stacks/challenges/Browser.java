package org.edudev.stacks_and_queues.stacks.challenges;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Browser {

    private String currentPage;
    private final Deque<String> backStack = new ArrayDeque<>();
    private final Deque<String> forwardStack = new ArrayDeque<>();

    public Browser() { currentPage = "home"; }

    public String getCurrentPage() { return currentPage; }

    public void access(final String page) {
        backStack.push(getCurrentPage());
        forwardStack.clear();
        currentPage = page;
    }

    public void back() {
        if(backStack.isEmpty())
            throw new IllegalStateException("Back error");
        forwardStack.push(currentPage);
        final var previousPage = backStack.pop();
        currentPage = previousPage;
    }

    public void forward() {
        if(forwardStack.isEmpty())
                throw new IllegalStateException("Forward error");
        backStack.push(currentPage);
        final var nextPage = forwardStack.pop();
        currentPage = nextPage;
    }
}
