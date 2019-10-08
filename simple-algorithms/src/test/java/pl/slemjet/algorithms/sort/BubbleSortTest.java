package pl.slemjet.algorithms.sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class BubbleSortTest {
    @Test
    void test() {
        // given
        Integer[] a = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        // when
        Integer[] sorted = BubbleSort.sort(a);

        // then
        Stream.of(sorted).forEach(value -> System.out.print(value + " "));
        Assertions.assertThat(sorted).isEqualTo(new Integer[]{0, 1, 2, 4, 5, 6, 44, 63, 87, 99, 283});
    }
}