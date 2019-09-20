package pl.slemjet.hashmaps;

import java.util.HashSet;
import java.util.Set;

public class HashMapMaster {

    public static Integer firstRecurringNumber(Integer[] values) {
        Set<Integer> occurredNumbers = new HashSet<>();

        for (Integer value : values) {
            if (occurredNumbers.contains(value)) {
                return value;
            } else
                occurredNumbers.add(value);
        }
        return null;
    }
}
