package org.edudev.stacks.exercises;

import java.util.ArrayDeque;
import java.util.Deque;

public final class RemoveDuplicates {

    public void main() {
        System.out.println(removeDuplicates("abbaca")); //ca
        System.out.println(removeDuplicates("azxxzy"));//ay
    }

    public String removeDuplicates(final String s) {
        Deque<Character> stack = new ArrayDeque<>();
        final var sb = new StringBuilder();
        for (var i = 0; i < s.length(); i++) {
            final var element = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != element) {
                stack.push(element);
            } else {
                stack.pop();
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }
}
