package org.edudev.maps.challenges.orm;

import java.util.Objects;

public final class Employee {

    private final Long id;
    private final String name;
    private final Double salary;

    private final Department department;

    public Employee(final String[] csv, final Department department) {
        this(Long.parseLong(csv[2]), csv[3], Double.parseDouble(csv[4]), department);
    }

    public Employee(final Long id, final String name, final Double salary, final Department department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.department.addEmployee(this);
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return STR."\{id}: \{name}, $ \{salary}";
    }
}
