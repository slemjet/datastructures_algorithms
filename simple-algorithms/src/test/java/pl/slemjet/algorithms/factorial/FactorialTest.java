package pl.slemjet.algorithms.factorial;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.slemjet.algorithms.simple.Factorial;

class FactorialTest {

    @Test
    void factorialViaLoop() {
        // when
        int factorial = Factorial.factorialViaLoop(5);

        // then
        Assertions.assertThat(factorial).isEqualTo(120);
    }

    @Test
    void factorialViaRecursion() {
        // when
        int factorial = Factorial.factorialViaRecursion(5);

        // then
        Assertions.assertThat(factorial).isEqualTo(120);
    }
}