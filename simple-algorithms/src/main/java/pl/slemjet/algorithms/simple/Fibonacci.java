package pl.slemjet.algorithms.simple;

// Given a number N return the index value of the Fibonacci sequence, where the sequence is:

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
// the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3

//For example: fibonacciRecursive(6) should return 8
public class Fibonacci {

    private int iterations = 0;
    public int fibonacciLoop(int value) {
        iterations++;
        if (value < 2)
            return value;

        int sum1 = 0;
        int sum2 = 1;

        for (int i = 2; i < value; i++) {
            iterations++;
            int tmp = sum1;
            sum1 = sum2;
            sum2 = sum2 + tmp;
        }

        return sum1 + sum2;
    }

    public int fibonacciRecursive(int value) {
        iterations++;
        if (value < 2)
            return value;

        return fibonacciRecursive(value - 1) + fibonacciRecursive(value - 2);
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
