package org.edudev.stacks_and_queues.stacks.exercises;

import java.util.ArrayDeque;
import java.util.Deque;

public final class IsBalanced {

    void main() {
        System.out.println(isBalanced("(())()"));
        System.out.println(isBalanced("())("));
    }

    public static boolean isBalanced(final String value) {
        final Deque<Character> parentheses = new ArrayDeque<>();

        for (var i = 0; i < value.length(); i++) {

            if (value.charAt(i) == '(') {
                parentheses.push(value.charAt(i));
                continue;
            }

            if (parentheses.pollFirst() == null) return false;
        }

        return true;
    }
}
