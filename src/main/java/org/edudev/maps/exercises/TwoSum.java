package org.edudev.maps.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    void main() {
        Arrays.stream(twoSum(new int[]{8, 2, 7, 15}, 9)).forEach(System.out::println); // saída 1,2
        System.out.println();
        Arrays.stream(twoSum(new int[]{3, 2, 4}, 6)).forEach(System.out::println); // saída 1,2
        System.out.println();
        Arrays.stream(twoSum(new int[]{3, 5, 7, 2, 4, 8, 1, 6}, 15)).forEach(System.out::println); // saída 2,5
        System.out.println();

        System.out.println();

        Arrays.stream(twoSumTwo(new int[]{8, 2, 7, 15}, 9)).forEach(System.out::println); // saída 1,2
        System.out.println();
        Arrays.stream(twoSumTwo(new int[]{3, 2, 4}, 6)).forEach(System.out::println); // saída 1,2
        System.out.println();
        Arrays.stream(twoSumTwo(new int[]{3, 5, 7, 2, 4, 8, 1, 6}, 15)).forEach(System.out::println); // saída 2,5
    }

    public static int[] twoSum(final int[] nums, final int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        final var result = new int[2];

        for (var i = 0; i < nums.length; i++) {
            final var difference = target - nums[i];
            final var mapValue = map.get(difference);

            if (mapValue != null) {
                result[0] = i;
                result[1] = mapValue;
                break;
            }

            map.put(nums[i], i);
        }

        return result;
    }

    public static int[] twoSumTwo(final int[] nums, final int target) {
        final var result = new int[2];

        for (var i = 0; i < nums.length; i++) {
            for (var j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }
}
