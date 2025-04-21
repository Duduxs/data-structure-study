package src.searches_and_sorts.exercises.sorts;

import java.util.Arrays;
import static java.util.stream.Collectors.joining;

public class BubbleSort {

    void main() {
        System.out.println(Arrays.stream(sort(new int[]{20, 9, 86, -2, 16})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
        System.out.println(Arrays.stream(sort(new int[]{5, 4, 3, 2, 1})).mapToObj(x -> String.valueOf(x)).collect(joining(",")));
    }

    public static int[] sort(int[] nums) {

        for (var i = 0; i < nums.length; i++) {
            for (var j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    var aux = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = aux;
                }
            }
        }

        return nums;
    }
}
