package pl.slemjet.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

    public static <T extends Comparable<T>> T[] sort(T[] array) {

        if (array.length == 1) {
            return array;
        }
        T[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        T[] right = Arrays.copyOfRange(array, array.length / 2, array.length);
        return merge(sort(left), sort(right));
    }

    private static <T extends Comparable<T>> T[] merge(T[] left, T[] right) {
        T[] merged = Arrays.copyOf(left, left.length + right.length);

        for (int i = 0, j = 0, k = 0; i < merged.length; i++) {
            if (j == left.length || k == right.length) {
                merged[i] = j == left.length ? right[k++] : left[j++];
            } else {
                merged[i] = left[j].compareTo(right[k]) > 0 ? right[k++] : left[j++];
            }
        }
        return merged;
    }
}
