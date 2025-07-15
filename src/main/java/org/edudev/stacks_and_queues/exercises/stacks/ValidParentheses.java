package org.edudev.stacks_and_queues.exercises.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public final class ValidParentheses {

    public void main() {
        System.out.println(isValid("()")); // true
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
        System.out.println(isValid("([])")); // true
        System.out.println(isValid("[")); // false
        System.out.println("------------------");
        System.out.println(isValid2("()")); // true
        System.out.println(isValid2("()[]{}")); // true
        System.out.println(isValid2("(]")); // false
        System.out.println(isValid2("([])")); // true
        System.out.println(isValid2("[")); // false

    }

    public boolean isValid(final String s) {
        final Deque<Character> elements = new ArrayDeque<>();

        for (var i = 0; i < s.length(); i++) {

            final var currentChar = s.charAt(i);

            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                elements.push(currentChar);
                continue;
            }

            final var removedElement = elements.pollFirst();
            if (removedElement == null) return false;

            if ((removedElement == '(' && currentChar == ')') || (removedElement == '{' && currentChar == '}') || (removedElement == '[' && currentChar == ']')) {
                continue;
            }

            return false;
        }

        return elements.isEmpty();

    }

    public boolean isValid2(final String s) {
        final Deque<Character> elements = new ArrayDeque<>();

        for (var i = 0; i < s.length(); i++) {

            final var currentChar = s.charAt(i);

            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                elements.push(currentChar);
                continue;
            }

            if (elements.isEmpty() || (currentChar == ')' && elements.poll() != '(') ||
                (currentChar == '}' && elements.poll() != '{') ||
                (currentChar == ']' && elements.poll() != '[')
            ) return false;

        }

        return elements.isEmpty();

    }


}
