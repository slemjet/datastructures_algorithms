package pl.slemjet.algorithms.simple;

public class Factorial {

    public static int factorialViaLoop(int value) {
        int sum = 1;
        while (value > 0){
            sum *= value--;
        }
        return sum;
    }

    public static int factorialViaRecursion(int value) {
        if (value > 0) {
            return value * factorialViaRecursion(value - 1);
        } else
            return 1;
    }
}
