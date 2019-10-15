package pl.slemjet.algorithms.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public int fibonacciDynamicBottomUp(int value) {
        iterations++;

        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);

        for (int i = 2; i <= value; i++) {
            iterations++;
            fibonacci.add(fibonacci.get(i - 2) + fibonacci.get(i - 1));
        }
        return fibonacci.get(value);
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
