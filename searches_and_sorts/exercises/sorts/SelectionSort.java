package src.searches_and_sorts.exercises.sorts;

import java.util.Arrays;
import static java.util.stream.Collectors.joining;

public class SelectionSort {

    void main() {
        System.out.println(Arrays.stream(selectionSort(new int[]{20, 9, 86, -2, 16})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
        System.out.println(Arrays.stream(selectionSort(new int[]{5, 4, 3, 2, 1})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
        System.out.println(Arrays.stream(selectionSort(new int[]{38, 23, 8, -5, 16, 29, 0, 13})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
    }

    public static int[] selectionSort(int[] arr) {
        for (var i = 0; i < arr.length - 1; i++) {
            var minIndex = i;
            for (var j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                var temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}
