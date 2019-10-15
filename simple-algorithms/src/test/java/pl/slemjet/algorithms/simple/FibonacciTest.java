package pl.slemjet.algorithms.simple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FibonacciTest {

    @Test
    void fibonacciLoop() {
        // given
        Fibonacci fibonacci = new Fibonacci();

        // when
        int result = fibonacci.fibonacciLoop(6);

        // then
        Assertions.assertThat(result).isEqualTo(8);
    }

    @Test
    void fibonacciRecursive() {
        // given
        Fibonacci fibonacci = new Fibonacci();

        // when
        int result = fibonacci.fibonacciRecursive(6);

        // then
        Assertions.assertThat(result).isEqualTo(8);
    }
}