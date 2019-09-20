package pl.slemjet.hashmaps;

import javafx.util.Pair;

import java.util.Arrays;

public class MyHashMap {

    private Pair<String, Integer>[][] data;

    public MyHashMap(int size) {
        this.data = new Pair[size][1];
    }

    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + (key.codePointAt(i)) * i) % this.data.length;
        }
        return hash;
    }

    public void set(String key, Integer value) {
        Pair<String, Integer>[] bucketValues = data[hash(key)];
        Pair<String, Integer> newValue = new Pair<>(key, value);
        if (bucketValues.length == 1 && bucketValues[0] == null) {
            data[hash(key)] = new Pair[]{newValue};
        } else {
            int length = bucketValues.length;
            bucketValues = Arrays.copyOf(bucketValues, length + 1);
            bucketValues[length] = newValue;
            data[hash(key)] = bucketValues;
        }
    }

    public Pair<String, Integer> get(String key) {
        Pair[] bucketValues = data[hash(key)];
        if (bucketValues.length == 1) {
            return bucketValues[0];
        } else {
            for (int i = 0; i < bucketValues.length; i++) {
                if (bucketValues[i].getKey().equals(key)) {
                    return bucketValues[i];
                }
            }
        }
        return null;
    }

    public String[] getKeys() {

        int size = 0;
        for (Pair[] values : data) {
            if (values[0] != null) {
                for (Pair<String, Integer> value : values) {
                    size++;
                }
            }
        }

        int i = 0;
        String[] keys = new String[size];
        for (Pair[] values : data) {
            if (values[0] != null) {
                for (Pair<String, Integer> value : values) {
                    keys[i] = value.getKey();
                    i++;
                }
            }
        }

        return keys;
    }

}
