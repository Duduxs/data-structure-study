package org.edudev.maps.challenges.orm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Eduardo J
 * JDK 22.0.1 (Zulu) + Gradle 8.13 with preview features enabled.
 */

public class DatabaseWithoutORM {

    void main() {
        System.out.println();

        convertRecords(new String[]{
                "57,Vendas,8032,Meire Silva,8000.0,57",
                "32,Estoque,4368,Dom Dias,7000.0,32",
                "57,Vendas,3298,Pedro Neto,8500.0,57",
                "57,Vendas,8639,Carol Souza,9000.0,57",
                "18,Marketing,6421,Davi Souto,7500.0,18",
                "32,Estoque,7523,Lara Matos,8000.0,32",
                "18,Marketing,2732,Bob Costa,6500.0,18"
        }).forEach(System.out::println);

        System.out.println();

        convertRecords(new String[]{
                "57,Vendas,8032,Meire Silva,8000.0,57",
                "18,Marketing,6421,Davi Souto,7500.0,18",
                "18,Marketing,2732,Bob Costa,6500.0,18"
        }).forEach(System.out::println);

    }

    static List<Department> convertRecords(String[] records) {
        final Map<Department, List<Employee>> departmentPerEmployees = new TreeMap<>();

        for (final var record : records) {
            final var csvSplit = record.split(",");
            final var department = new Department(csvSplit);
            final var employee = new Employee(csvSplit);

            if (departmentPerEmployees.containsKey(department)) {
                final var employees = departmentPerEmployees.get(department);
                final var departmentToModify = employees.getFirst().getDepartment();

                departmentToModify.addEmployee(employee);
                employees.add(employee);
                continue;
            }

            department.addEmployee(employee);
            departmentPerEmployees.put(department, new ArrayList<>(List.of(employee)));
        }

        return departmentPerEmployees.keySet().stream().toList();
    }
}
