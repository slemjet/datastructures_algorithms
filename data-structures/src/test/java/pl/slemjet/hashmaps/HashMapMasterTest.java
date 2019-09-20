package pl.slemjet.hashmaps;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HashMapMasterTest {
    @Test
    void testIfReturnsCorrectRecurringNumber() {
        //given
        Integer[] array1 = new Integer[]{2, 5, 1, 2, 3, 5, 1, 2, 4};
        Integer[] array2 = new Integer[]{2, 1, 1, 2, 3, 5, 1, 2, 4};
        Integer[] array3 = new Integer[]{2, 3, 4, 5};

        //when
        Integer firstRecurringNumber1 = HashMapMaster.firstRecurringNumber(array1);
        Integer firstRecurringNumber2 = HashMapMaster.firstRecurringNumber(array2);
        Integer firstRecurringNumber3 = HashMapMaster.firstRecurringNumber(array3);

        //then
        Assertions.assertThat(firstRecurringNumber1).isEqualTo(2);
        Assertions.assertThat(firstRecurringNumber2).isEqualTo(1);
        Assertions.assertThat(firstRecurringNumber3).isNull();

    }
}