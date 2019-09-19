package pl.slemjet.arrays;

import java.util.Arrays;
import java.util.Stack;

public class StringMaster {

    public static String reverse(String input) {

        String[] strings = input.split("");
        for (int i = 0, j = strings.length - 1; i < j; i++, j--) {
            String swap = strings[i];
            strings[i] = strings[j];
            strings[j] = swap;
        }
        return String.join("", strings);
    }

    public static String reverse2(String input) {

        return new StringBuilder(input).reverse().toString();
    }

    public static String reverse3(String input) {

        Stack<String> strings = new Stack<>();
        Arrays.stream(input.split("")).forEach(strings::push);

        StringBuilder sb = new StringBuilder();
        while (!strings.isEmpty()) {
            sb.append(strings.pop());
        }

        return sb.toString();
    }
}
