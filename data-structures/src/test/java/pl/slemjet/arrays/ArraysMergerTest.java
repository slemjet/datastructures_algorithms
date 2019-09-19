package pl.slemjet.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraysMergerTest {
    @Test
    void testMerge() {
        //given
        int[] expectedArray = {0, 3, 4, 4, 6, 30, 31};
        int[] sortedArray1 = {0, 3, 4, 31};
        int[] sortedArray2 = {4, 6, 30};

        //when
        int[] mergedArray = ArraysMerger.merge(sortedArray1, sortedArray2);

        //then
        Assertions.assertThat(mergedArray).isEqualTo(expectedArray);
    }
}