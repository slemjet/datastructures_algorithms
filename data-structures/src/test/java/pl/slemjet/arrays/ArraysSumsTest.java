package pl.slemjet.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraysSumsTest {
    @Test
    void testTwoSums() {
        //given
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] expected = new int[]{0, 1};

        //when
        int[] sumIndices = ArraysSums.twoSum(numbers, target);

        //then
        Assertions.assertThat(sumIndices).isEqualTo(expected);
    }
}