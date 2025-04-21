package src.searches_and_sorts.exercises.sorts;

import java.util.Arrays;
import static java.util.stream.Collectors.joining;

public class BubbleSort {

    void main() {
        System.out.println(Arrays.stream(sort(new int[]{20, 9, 86, -2, 16})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
        System.out.println(Arrays.stream(sort(new int[]{5, 4, 3, 2, 1})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
        System.out.println(Arrays.stream(sort(new int[]{38, 23, 8, -5, 16, 29, 0, 13})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
    }

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
}
