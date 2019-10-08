package pl.slemjet.algorithms.sort;

public class BubbleSort {

    public static <T extends Comparable<T>> T[] sort(T[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    T tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
}
