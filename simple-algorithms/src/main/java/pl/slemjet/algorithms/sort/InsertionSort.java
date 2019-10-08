package pl.slemjet.algorithms.sort;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertionSort {

    public static <T extends Comparable<T>> T[] sort(T[] array) {

        LinkedList<T> list = new LinkedList<>(Arrays.asList(array));

        for (int i = 0; i < list.size(); i++) {
            // search for insertion point
            int insertIdx = i;
            T current = list.get(i);
            while (insertIdx > 0) {
                T next = list.get(insertIdx - 1);
                if (current.compareTo(next) < 0) {
                    insertIdx--;
                } else {
                    break;
                }
            }

            // insert at index
            T itemToInsert = list.get(i);
            list.remove(i);
            list.add(insertIdx, itemToInsert);
        }

        T[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
