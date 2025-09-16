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

    /**
     * Complexidade de espaço: O(n) [Big O], Θ(n) [Theta], Ω(n) [Omêga]
     * Isso se dá, pois em função ao tamanho da entrada (records) eu sempre vou ter no máximo
     * N departamento e N empregados devido a forma como o banco relacionam volta os dados.
     * Logo a complexidade é linear.
     *
     * Complexidade de tempo: O(n log n) [Big O], Θ(n log m) [Theta], Ω(n) [Omêga]
     *
     * Em todos os casos eu tenho que levar em consideração que eu sempre varro toda a entrada (records) com o foreach, ou seja N.
     * E também levar em conta que a operação de inserções, busca, remoção em um TreeMap é logarítmica (log n) onde N é o número de chaves (no nosso caso departamentos) distintos.
     *
     * No pior caso eu tenho uma entrada com todos os registros de departamentos diferentes.
     * Logo eu tenho que fazer N inserções na minha estrutura de dados (TreeMap)
     * e consequentemente nas buscas (containsKey) e (get) pela chave eu terei uma complexidade logaritmica
     * que é a padrão do TreeMap que implementa a árvore rubro-negra.
     * Além disso eu sempre varro toda a entrada não importa o tamanho com o foreach, ou seja, N.
     * Então, eu tenho no pior caso uma complexidade N (foreach) * log n (inserções e buscas no TreeMap)
     * que resulta em (n log m) [log linear] onde M é o número de chaves (departamentos) distintos. Nesse pior caso M é exatamente igual a N, pois não temos departamentos iguais, então
     * poderíamos também representar o pior caso como (n log n) [log linear].
     *
     * No caso médio eu tenho alguns departamentos iguais e outros distintos, no caso só contando com as operações de inserção, busca, remoção e etc
     * pela chave no TreeMap eu já teria uma complexidade logaritmica (log m) onde M é o número de chaves (departamentos) distintos. Só que somamos isso com o foreach (N)
     * que varre toda a entrada (records) não importa o tamanho.
     * Logo no caso médio eu tenho N * (log m) => (n log m) [log linear].
     *
     * No melhor caso eu tenho departamentos sempre iguais e com isso eu sempre terei uma única chave no TreeMap com N valores.
     * Quando o TreeMap tem apenas uma chave a complexidade das operações pela chave (inserção, remoção, busca, etc) é constante (1),
     * Pois eu não preciso fazer a travessia na árvore (afinal eu tenho só uma única chave).
     * Logo no melhor caso eu tenho N * 1 => N (linear).
     */
    static List<Department> convertRecords(String[] records) {
        final Map<Department, List<Employee>> departmentPerEmployees = new TreeMap<>();

        for (final var record : records) {
            final var csvSplit = record.split(",");
            final var department = new Department(csvSplit);

            if (departmentPerEmployees.containsKey(department)) {
                final var employees = departmentPerEmployees.get(department);
                final var departmentToModify = employees.getFirst().getDepartment();

                employees.add(new Employee(csvSplit, departmentToModify));
                continue;
            }

            departmentPerEmployees.put(department, new ArrayList<>(List.of(new Employee(csvSplit, department))));
        }

        return departmentPerEmployees.keySet().stream().toList();
    }
}
