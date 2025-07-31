package org.edudev.sets.exercises;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toSet;

final class Alunos {

    void main() {
        System.out.println(studentsCount(List.of(
                List.of(15, 21, 80, 42),
                List.of(21, 80, 47),
                List.of(12, 21, 47, 3)
        ))); // Deve ser 7
        System.out.println(studentsCount2(List.of(
                List.of(15, 21, 80, 42),
                List.of(21, 80, 47),
                List.of(12, 21, 47, 3)
        ))); // Deve ser 7
        System.out.println(studentsCount3(List.of(
                List.of(15, 21, 80, 42),
                List.of(21, 80, 47),
                List.of(12, 21, 47, 3)
        ))); // Deve ser 7
    }

    public static int studentsCount(final List<List<Integer>> courses) {
        final Set<Integer> uniqueStudents = new HashSet<>();

        for (var i = 0; i < courses.size(); i++) {
            for (var j = 0; j < courses.get(i).size(); j++) {
                uniqueStudents.add(courses.get(i).get(j));
            }
        }

        return uniqueStudents.size();
    }

    public static int studentsCount2(final List<List<Integer>> courses) {
        return courses.stream().flatMap(Collection::stream).collect(toSet()).size();
    }

    public static int studentsCount3(final List<List<Integer>> courses) {
        final Set<Integer> uniqueStudents = new HashSet<>();

        for (var i = 0; i < courses.size(); i++) {
            uniqueStudents.addAll(courses.get(i));
        }

        return uniqueStudents.size();
    }
}
