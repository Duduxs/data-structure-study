package org.edudev.queues.exercises;

import java.util.ArrayDeque;
import java.util.Deque;

public final class NumberOfStudentsUnableToEatLunch {

    public void main() {
        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1})); // 0
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1})); // 3
        System.out.println();
        System.out.println(countStudents2(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1})); // 0
        System.out.println(countStudents2(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1})); // 3
        System.out.println();
        System.out.println(countStudents3(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1})); // 0
        System.out.println(countStudents3(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1})); // 3
    }

    public int countStudents(final int[] students, final int[] sandwiches) {
        final Deque<Integer> queueStudents = new ArrayDeque<>();
        final Deque<Integer> queueSandwiches = new ArrayDeque<>();

        for (int i = 0; i < students.length; i++) queueStudents.add(students[i]);
        for (int i = 0; i < sandwiches.length; i++) queueSandwiches.add(sandwiches[i]);

        var studentsWhoSkippedTheSandwich = 0;

        while (studentsWhoSkippedTheSandwich != queueStudents.size()) {
            final var student = queueStudents.poll();
            final var sandwich = queueSandwiches.peek();

            if (queueSandwiches.isEmpty()) break;

            if (student.equals(sandwich)) {
                queueSandwiches.poll();
                studentsWhoSkippedTheSandwich = 0;
                continue;
            }

            queueStudents.add(student);
            studentsWhoSkippedTheSandwich++;
        }

        return queueStudents.size();

    }

    public int countStudents2(final int[] students, final int[] sandwiches) {
        final Deque<Integer> queueStudents = new ArrayDeque<>();

        for (int i = 0; i < students.length; i++) queueStudents.add(students[i]);

        for (var i = 0; i < sandwiches.length; i++) {
            var eat = false;
            var count = queueStudents.size();

            while (!eat && count > 0) {
                final var student = queueStudents.poll();

                if (student.equals(sandwiches[i])) {
                    eat = true;
                } else {
                    queueStudents.add(student);
                    count--;
                }
            }

            if (count == 0)
                return queueStudents.size();

        }

        return 0;
    }

    public int countStudents3(final int[] students, final int[] sandwiches) {
        final Deque<Integer> queueStudents = new ArrayDeque<>();

        for (int i = 0; i < students.length; i++) queueStudents.add(students[i]);

        var studentsWhoSkippedTheSandwich = 0;

        for (var i = 0; studentsWhoSkippedTheSandwich != queueStudents.size(); ) {
            final var student = queueStudents.poll();
            final var sandwich = sandwiches[i];

            if (student.equals(sandwich)) {
                studentsWhoSkippedTheSandwich = 0;
                i++;
            } else if (student == null) {
                break;
            } else {
                queueStudents.add(student);
                studentsWhoSkippedTheSandwich++;
            }
        }

        return queueStudents.size();

    }

}
