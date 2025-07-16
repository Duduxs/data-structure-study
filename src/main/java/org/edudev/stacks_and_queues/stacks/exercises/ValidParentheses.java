package org.edudev.stacks_and_queues.stacks.exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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
        System.out.println("------------------");
        System.out.println(isValid3("()")); // true
        System.out.println(isValid3("()[]{}")); // true
        System.out.println(isValid3("(]")); // false
        System.out.println(isValid3("([])")); // true
        System.out.println(isValid3("[")); // false
        System.out.println("------------------");
        System.out.println(isValid4("()")); // true
        System.out.println(isValid4("()[]{}")); // true
        System.out.println(isValid4("(]")); // false
        System.out.println(isValid4("([])")); // true
        System.out.println(isValid4("[")); // false
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

            if (elements.isEmpty() || (currentChar == ')' && elements.pop() != '(') ||
                (currentChar == '}' && elements.pop() != '{') ||
                (currentChar == ']' && elements.pop() != '[')
            ) return false;

        }

        return elements.isEmpty();

    }

    public boolean isValid3(final String s) {
        Stack<Character> parentheses = new Stack<>();

        for (var i = 0; i < s.length(); i++) {
            var element = s.charAt(i);

            if (element == '(' || element == '{' || element == '[') {
                parentheses.push(s.charAt(i));
            }

            if (parentheses.isEmpty()) {
                return false;
            }

            if (element == ')') {
                if (parentheses.peek().equals('(')) parentheses.pop();
                else return false;
            }
            if (element == '}') {
                if (parentheses.peek().equals('{')) parentheses.pop();
                else return false;
            }
            if (element == ']') {
                if (parentheses.peek().equals('[')) parentheses.pop();
                else return false;
            }

        }

        return parentheses.isEmpty();
    }

    public boolean isValid4(final String s) {
        Stack<Character> elements = new Stack<>();

        for (var i = 0; i < s.length(); i++) {
            var element = s.charAt(i);

            switch (s.charAt(i)) {
                case '(' -> elements.push(')');
                case '{' -> elements.push('}');
                case '[' -> elements.push(']');
                default -> {
                    if (elements.isEmpty() || !elements.pop().equals(element)) return false;
                }
            }
        }

        return elements.isEmpty();
    }


}
