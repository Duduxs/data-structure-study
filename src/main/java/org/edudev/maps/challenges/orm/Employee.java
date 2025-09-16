package org.edudev.maps.challenges.orm;

import java.util.Objects;

public final class Employee {

    private final Long id;
    private final String name;
    private final Double salary;

    private Department department;

    public Employee(final String[] csv) {
        this(Long.parseLong(csv[2]), csv[3], Double.parseDouble(csv[4]));
    }

    public Employee(final Long id, final String name, final Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(final Department department) {
        this.department = department;
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
