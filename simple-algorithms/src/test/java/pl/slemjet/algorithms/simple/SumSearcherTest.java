package pl.slemjet.algorithms.simple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SumSearcherTest {

    @Test
    void hasPairWithSum() {
        int[] arrayWithoutPair = new int[] {1, 2, 3, 9};
        int[] arrayWithPair = new int[] {1, 2, 4, 4};

        Assertions.assertThat(SumSearcher.hasPairWithSum(arrayWithoutPair, 8)).isFalse();
        Assertions.assertThat(SumSearcher.hasPairWithSum(arrayWithPair, 8)).isTrue();
    }
}