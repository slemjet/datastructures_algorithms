package pl.slemjet.algorithms.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private Map<Integer, Integer> resultsCache = new HashMap<>();

    private int iterations = 0;

    public int fibonacciDynamic(int value) {
        iterations++;
        if (value < 2)
            return value;

        if (resultsCache.containsKey(value))
            return resultsCache.get(value);
        else {
            int result = fibonacciDynamic(value - 1) + fibonacciDynamic(value - 2);
            resultsCache.put(value, result);
            return result;
        }
    }

    public int getIterations() {
        return iterations;
    }
}
