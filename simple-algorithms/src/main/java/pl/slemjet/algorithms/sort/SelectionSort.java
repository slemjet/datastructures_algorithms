package pl.slemjet.algorithms.sort;

public class SelectionSort {

    public static <T extends Comparable<T>> T[] sort(T[] array) {

        for (int i = 0; i < array.length; i++) {
            int smallestIdx = i;
            T smallest = array[smallestIdx];
            for (int j = i + 1; j < array.length; j++) {
                if(array[j].compareTo(smallest) < 0){
                    smallestIdx = j;
                    smallest = array[smallestIdx];
                }
            }
            T tmp = array[i];
            array[i] = array[smallestIdx];
            array[smallestIdx] = tmp;
        }
        return array;
    }
}
