package org.edudev.searches_and_sorts.exercises.sorts;

public class QuickSort {

    void main() {
        int[] nums = {5, 2, 9, 1, 5, 6};
        quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.print(STR."\{num} ");
        }
    }

    /**
     * Análise da complexidade de tempo
     * Ω(NlogN) ⇾ Os elementos já estão ordenados.
     * Θ(NlogN) ⇾ Necessário ordenar parte dos elementos.
     * O(N²) ⇾ Os elementos estão na ordem inversa.
     *
     * Análise da complexidade de espaço
     * O(logN) ⇾ No consumo de memória cresce de forma logarítmica conforme a entrada.
     *
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, j, i);
                i++;
            }
        }

        swap(nums, i, right);
        return i;
    }

    public static void swap(int[] nums, int a, int b) {
        int aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }
}
