package org.edudev.sets.exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

final class IntersectionOfTwoArrays {

    void main() {
        Arrays.stream(intersection(new int[]{1,2,2,1}, new int[]{2,2})).forEach(System.out::println);
        System.out.println("-----------------");
        Arrays.stream(intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})).forEach(System.out::println);
        System.out.println("-----------------");
    }

    public static int[] intersection(final int[] nums1, final int[] nums2) {
        final Set<Integer> setNums1 = new HashSet<>();
        final Set<Integer> setNums2 = new HashSet<>();

        for(var i = 0; i < nums1.length ; i++) setNums1.add(nums1[i]);
        for(var i = 0; i < nums2.length ; i++) setNums2.add(nums2[i]);

        setNums1.retainAll(setNums2);

        // return setNums1.stream().mapToInt(Integer::intValue).toArray(); Retorno mais lento

        final int[] result = new int[setNums1.size()];
        int i = 0;

        for(final var num: setNums1) result[i++] = num;

        return result;
    }

}
