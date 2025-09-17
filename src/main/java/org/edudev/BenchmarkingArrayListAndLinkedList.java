package org.edudev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BenchmarkingArrayListAndLinkedList {

    void main() {
        List<String> arrayList = new ArrayList<>(Collections.nCopies(1000000, "1.000.000 elementos!"));
        List<String> linkedList = new LinkedList<>(Collections.nCopies(1000000, "1.000.000 elementos!"));

        System.out.println(arrayList.size());
        System.out.println(linkedList.size());

        long start = System.currentTimeMillis();
        for(var i =0 ; i < 100_000; i++) {
            arrayList.add("eduardo"); //Passando um índice 27 segundos (arrayList.add(i,"eduardo")) [Inserindo no inicio, meio e fim da lista é lento], sem índice 2ms (arrayList.add("eduardo"))
            // Toda vez que precisa inserir precisa realocar o array interno, copiando os elementos do array anterior e colocando no novo array O(n).
        }
        long end = System.currentTimeMillis();
        System.out.println(STR."ArrayList add: \{end - start}ms");

        start = System.currentTimeMillis();
        for(var i =0 ; i < 100_000; i++) {
            linkedList.add("eduardo"); // Passando um índice 5 segundos (linkedList.add(i,"eduardo")) [Inserindo no inicio, meio e fim da lista é rápido], sem índice 0ms (linkedList.add("eduardo"))
            // Diferente dos arrays, a alocação aqui é dinâmica sem necessidade de mover os elementos O(1).
        }
        end = System.currentTimeMillis();
        System.out.println(STR."LinkedList add: \{end - start}ms");

        System.out.println();
        System.out.println();

        start = System.currentTimeMillis();
        for(var i =0 ; i < 100_000; i++) {
            arrayList.get(i); // 0ms busca por índice em estruturas baseadas em array é muito rápido! O(1),
            // pois é feito uma operação matématica para chegar no índice desejado graças a forma como o array é armazenado na memória (de forma contígua).
        }
        end = System.currentTimeMillis();
        System.out.println(STR."ArrayList get: \{end - start}ms");

        start = System.currentTimeMillis();
        for(var i =0 ; i < 100_000; i++) {
            linkedList.get(i); //5 segundos, busca por índice em listas ligadas é lento O(N), pois preciso percorrer a lista toda até chegar ao índice desejado.
        }
        end = System.currentTimeMillis();
        System.out.println(STR."LinkedList get: \{end - start}ms");
    }

}
