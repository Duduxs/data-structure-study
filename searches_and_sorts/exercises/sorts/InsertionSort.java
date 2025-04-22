package src.searches_and_sorts.exercises.sorts;

import java.util.Arrays;
import static java.util.stream.Collectors.joining;

public class InsertionSort {

    void main() {
        System.out.println(Arrays.stream(insertionSort(new int[]{20, 9, 86, -2, 16})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
        System.out.println(Arrays.stream(insertionSort(new int[]{5, 4, 3, 2, 1})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
        System.out.println(Arrays.stream(insertionSort(new int[]{38, 23, 8, -5, 16, 29, 0, 13})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
    }

    public static int[] insertionSort(int[] arr) {
        for (var i = 1; i < arr.length; i++) {
            var aux = arr[i];
            var j = i - 1;
            while (j >= 0 && arr[j] > aux) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = aux;
        }
        return arr;
    }
}
