package pl.slemjet.algorithms.simple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraysCheckerTest {
    @Test
    void testIfChecksForCommonItemsBadNegative() {
        char[] array1 = new char[]{'a', 'b', 'c', 'x'};
        char[] array2 = new char[]{'z', 'y', 'i'};

        Assertions.assertThat(ArraysChecker.hasCommonItemsBad(array1, array2)).isFalse();
    }

    @Test
    void testIfChecksForCommonItemsBadPositive() {
        char[] array1 = new char[]{'a', 'b', 'c', 'x'};
        char[] array2 = new char[]{'z', 'y', 'x'};

        Assertions.assertThat(ArraysChecker.hasCommonItemsBad(array1, array2)).isTrue();
    }

    @Test
    void testIfChecksForCommonItemsBetterNegative() {
        char[] array1 = new char[]{'a', 'b', 'c', 'x'};
        char[] array2 = new char[]{'z', 'y', 'i'};

        Assertions.assertThat(ArraysChecker.hasCommonItemsBetter(array1, array2)).isFalse();
    }

    @Test
    void testIfChecksForCommonItemsBetterPositive() {
        char[] array1 = new char[]{'a', 'b', 'c', 'x'};
        char[] array2 = new char[]{'z', 'y', 'x'};

        Assertions.assertThat(ArraysChecker.hasCommonItemsBetter(array1, array2)).isTrue();
    }

    @Test
    void testIfChecksForCommonItemsGoodNegative() {
        char[] array1 = new char[]{'a', 'b', 'c', 'x'};
        char[] array2 = new char[]{'z', 'y', 'i'};

        Assertions.assertThat(ArraysChecker.hasCommonItemsGood(array1, array2)).isFalse();
    }

    @Test
    void testIfChecksForCommonItemsGoodPositive() {
        char[] array1 = new char[]{'a', 'b', 'c', 'x'};
        char[] array2 = new char[]{'z', 'y', 'x'};

        Assertions.assertThat(ArraysChecker.hasCommonItemsGood(array1, array2)).isTrue();
    }
}