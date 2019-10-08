package pl.slemjet.algorithms.sort;

import java.util.Arrays;

public class QuickSort {

    public static <T extends Comparable<T>> T[] sort(T[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int start, int end) {
        if (array.length == 0 || start >= end) {
            return;
        }

        // select pivot
        int middle = (start + end) / 2;
        T pivot = array[middle];

        int left = start;
        int right = end;

        while (left <= right) {
            while (array[left].compareTo(pivot) < 0) // just switch to next element
                left++;

            while (array[right].compareTo(pivot) > 0) // just switch to next element
                right--;

            if (left <= right) {
                swapElements(array, left, right);
                left++;
                right--;
            }
        }
        // sort left and right parts
        if (left > start)
            quickSort(array, start, right);
        if (end > right)
            quickSort(array, left, end);
    }

    private static <T extends Comparable<T>> void swapElements(T[] array, int i, int j) {
        T tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

}
