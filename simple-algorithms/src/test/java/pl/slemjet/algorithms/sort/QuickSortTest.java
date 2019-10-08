package pl.slemjet.algorithms.sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortTest {

    @Test
    void sort() {
        // given
        Integer[] array = new Integer[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        // when
        Integer[] sorted = QuickSort.sort(array);

        // then
        Assertions.assertThat(sorted).isEqualTo(new Integer[]{0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283});
    }
}