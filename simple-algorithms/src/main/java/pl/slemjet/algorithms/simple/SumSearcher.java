package pl.slemjet.algorithms.simple;

import java.util.HashSet;

public class SumSearcher {

    public static boolean hasPairWithSum(int[] values, int sum) {

        HashSet<Integer> complements = new HashSet<>(values.length);
        for (int i = 0; i < values.length; i++) {
            int complement = sum - values[i];
            if (complements.contains(complement))
                return true;
            else complements.add(complement);
        }
        return false;
    }
}
