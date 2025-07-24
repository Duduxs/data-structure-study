package org.edudev.stacks_and_queues.queues.exercises;

import java.util.ArrayDeque;
import java.util.Deque;

public final class NumberOfStudentsUnableToEatLunch {

    public void main() {
        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1})); // 0
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1})); // 3
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

            if(queueSandwiches.isEmpty()) break;

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

}
