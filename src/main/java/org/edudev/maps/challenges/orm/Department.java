package org.edudev.maps.challenges.orm;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class Department implements Comparable<Department> {

    private final Long id;
    private final String name;

    private final Set<Employee> employees = new LinkedHashSet<>();

    public Department(final String[] csv) {
        id = Long.parseLong(csv[0]);
        name = csv[1];
    }

    public void addEmployee(final Employee employee) {
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int compareTo(final Department o) {
        return name.compareTo(o.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return STR."""
        \{name}:
        \{employees.stream()
                .map(employee -> STR."\t\{employee}\n")
                .collect(Collectors.joining())}
        """.trim();
    }
}
