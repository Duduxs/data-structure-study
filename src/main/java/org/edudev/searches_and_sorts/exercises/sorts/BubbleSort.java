package org.edudev.searches_and_sorts.exercises.sorts;

import java.util.Arrays;
import static java.util.stream.Collectors.joining;

public class BubbleSort {

    void main() {
        System.out.println(Arrays.stream(sort(new int[]{20, 9, 86, -2, 16})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
        System.out.println(Arrays.stream(sort(new int[]{5, 4, 3, 2, 1})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
        System.out.println(Arrays.stream(sort(new int[]{38, 23, 8, -5, 16, 29, 0, 13})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));

        System.out.println();
        System.out.println();

        System.out.println(Arrays.stream(sort2(new int[]{20, 9, 86, -2, 16})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
        System.out.println(Arrays.stream(sort2(new int[]{5, 4, 3, 2, 1})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
        System.out.println(Arrays.stream(sort2(new int[]{38, 23, 8, -5, 16, 29, 0, 13})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
    }

    /**
     * Análise da complexidade de tempo
     * Ω(N) ⇾ Os elementos já estão ordenados.
     * Θ(N²) ⇾ Necessário ordenar parte dos elementos.
     * O(N²) ⇾ Os elementos estão na ordem inversa.
     * <p>
     * Análise da complexidade de espaço
     * O(1) ⇾ A memória não aumenta conforme o tamanho da entrada.
     * Variáveis i, j, hasSwapped e aux só tem seus valores trocados por outros na stack durante o runtime,
     * mas sem adicionar memória.
     * <p>
     * Não citei theta nem ômega, pois nesse caso eles tem o mesmo consumo de memória que o Big O.
     */
    public static int[] sort(int[] nums) {

        for (var i = 0; i < nums.length; i++) {

            var hasSwapped = false; /** Evita iterações desnecessárias caso tds os elementos em
             algum momento já estejam ordenados **/

            for (var j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    var aux = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = aux;
                    hasSwapped = true;
                }
            }

            if (!hasSwapped) {
                break;
            }
        }

        return nums;
    }

    public static int[] sort2(int[] nums) {

        var hasSwapped = true;
        var length = nums.length - 1;

        while (hasSwapped) {
            hasSwapped = false;
            for (var i = 0; i < length; i++) {
                if (nums[i] > nums[i + 1]) {
                    var aux = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = aux;
                    hasSwapped = true;
                }
            }
            length--;
        }

        return nums;
    }
}
