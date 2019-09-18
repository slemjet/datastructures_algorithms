package pl.slemjet.algorithms.simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static java.util.stream.Stream.of;

public class ArraysChecker {

    // O(a * b) time complexity
    public static boolean hasCommonItemsBad(char[] array1, char[] array2) {

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j])
                    return true;
            }
        }
        return false;
    }

    // O(a*log(b)) time complexity
    public static boolean hasCommonItemsBetter(char[] array1, char[] array2) {
        char[] bigger = array1.length > array2.length ? array1 : array2;
        char[] smaller = bigger == array1 ? array2 : array1;
        Arrays.sort(bigger);
        for (int i = 0; i < smaller.length; i++) {
            int index = Arrays.binarySearch(bigger, smaller[i]);
            if (index >= 0)
                return true;
        }
        return false;
    }

    // O(a + b) time complexity
    public static boolean hasCommonItemsGood(char[] array1, char[] array2) {
        char[] bigger = array1.length > array2.length ? array1 : array2;
        char[] smaller = bigger == array1 ? array2 : array1;

        HashSet<Character> referenceSet = new HashSet<>();
        for (int i = 0; i < bigger.length; i++) {
            referenceSet.add(bigger[i]);
        }

        for (int i = 0; i < smaller.length; i++) {
            if (referenceSet.contains(smaller[i]))
                return true;
        }
        return false;
    }
}
