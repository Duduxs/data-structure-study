package src.searches_and_sorts.exercises.sorts;

public class MergeSort {

    void main(){
        int[] nums = {5, 2, 9, 1, 5, 6};
        mergeSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.print(STR."\{num} ");
        }
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(nums, left, middle);
            mergeSort(nums, middle + 1, right);
            merge(nums, left, middle, right);
        }
    }

    public static void merge(int[] nums, int left, int middle, int right) {
        int length = right - left + 1;
        int[] result = new int[length];

        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {
            if (nums[i] < nums[j]) {
                result[k++] = nums[i++];
            } else {
                result[k++] = nums[j++];
            }
        }

        while (i <= middle) {
            result[k++] = nums[i++];
        }

        while (j <= right) {
            result[k++] = nums[j++];
        }

        for (int m = 0; m < length; m++) {
            nums[left + m] = result[m];
        }
    }
}
