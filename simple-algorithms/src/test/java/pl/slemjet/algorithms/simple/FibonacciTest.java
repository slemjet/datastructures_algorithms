package pl.slemjet.algorithms.simple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FibonacciTest {

    @Test
    void fibonacciLoop() {
        // when
        int fibonacci = Fibonacci.fibonacciLoop(6);

        // then
        Assertions.assertThat(fibonacci).isEqualTo(8);
    }

    @Test
    void fibonacciRecursive() {
        // when
        int fibonacci = Fibonacci.fibonacciRecursive(6);

        // then
        Assertions.assertThat(fibonacci).isEqualTo(8);
    }
}