package org.edudev.searches_and_sorts.challenges;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eduardo J
 * JDK 22.0.1 (Zulu) + Gradle 8.13 with preview features enabled.
 */

final class SortBenchmark {

    void main() {
        try {
            final var mapper = new ObjectMapper();

            final var file = new File("src/main/resources/input.json");
            final List<String> data = mapper.readValue(file, List.class);

            var start = Instant.now();
            insertionSort(new ArrayList<>(data));
            var end = Instant.now();

            // ~80ms
            System.out.println(STR."Insertion sort: \{Duration.between(start, end).toMillis()}ms");

            start = Instant.now();
            bubbleSort(new ArrayList<>(data));
            end = Instant.now();

            // ~430ms
            System.out.println(STR."Bubble sort: \{Duration.between(start, end).toMillis()}ms");

            start = Instant.now();
            quickSort(new ArrayList<>(data), 0, data.size() - 1);
            end = Instant.now();

            // ~3ms
            System.out.println(STR."Quick sort: \{Duration.between(start, end).toMillis()}ms");

        } catch (final Exception e) {
            e.printStackTrace();
        }

    }

    static void insertionSort(final List<String> data) {
        for (var i = 1; i < data.size(); i++) {
            var aux = data.get(i);
            var j = i - 1;
            while (j >= 0 && data.get(j).compareTo(aux) > 0) {
                data.set(j + 1, data.get(j));
                j--;
            }
            data.set(j + 1, aux);
        }
    }

    static void bubbleSort(final List<String> data) {

        for (var i = 0; i < data.size(); i++) {

            var hasSwapped = false;

            for (var j = 0; j < data.size() - i - 1; j++) {
                if (data.get(j).compareTo(data.get(j + 1)) > 0) {
                    swap(data, j, j + 1);
                    hasSwapped = true;
                }
            }

            if (!hasSwapped) {
                break;
            }
        }
    }

    static void quickSort(final List<String> data, final int left, final int right) {
        if (left < right) {
            int pivot = partition(data, left, right);
            quickSort(data, left, pivot - 1);
            quickSort(data, pivot + 1, right);
        }
    }

    static int partition(final List<String> data, final int left, final int right) {
        var pivot = data.get(right);
        int i = left;

        for (int j = left; j < right; j++) {
            if (data.get(j).compareTo(pivot) <= 0) {
                swap(data, j, i);
                i++;
            }
        }

        swap(data, i, right);
        return i;
    }

    static void swap(final List<String> data, final int a, final int b) {
        final var aux = data.get(a);
        data.set(a, data.get(b));
        data.set(b, aux);
    }

}
