package pl.slemjet.algorithms.dynamic_programming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void testFibonacciDynamic() {
        // given
        Fibonacci fibonacci = new Fibonacci();

        // when
        int result = fibonacci.fibonacciDynamic(10);

        // then
        System.out.println("Dynamic Iterations: " + fibonacci.getIterations());
        Assertions.assertThat(result).isEqualTo(55);
    }

    @Test
    void fibonacciLoop() {
        // given
        pl.slemjet.algorithms.simple.Fibonacci fibonacci = new pl.slemjet.algorithms.simple.Fibonacci();

        // when
        int result = fibonacci.fibonacciLoop(10);

        // then
        System.out.println("Loop Iterations: " + fibonacci.getIterations());
        Assertions.assertThat(result).isEqualTo(55);
    }

    @Test
    void fibonacciRecursive() {
        // given
        pl.slemjet.algorithms.simple.Fibonacci fibonacci = new pl.slemjet.algorithms.simple.Fibonacci();

        // when
        int result = fibonacci.fibonacciRecursive(10);

        // then
        System.out.println("Recursive Iterations: " + fibonacci.getIterations());
        Assertions.assertThat(result).isEqualTo(55);
    }
}