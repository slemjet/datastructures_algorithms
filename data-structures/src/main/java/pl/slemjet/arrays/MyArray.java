package pl.slemjet.arrays;

import java.lang.reflect.Array;

public class MyArray<T> {

    private int length = 0;
    private T[] data;
    private double ratio = 0.8;

    public MyArray(T[] data) {
        this.data = data;
        this.length = data.length;
    }

    public T get(int index) {
        return index < length ? data[index] : null;
    }

    // O(n)
    public void remove(int index) {
        if (index > length - 1)
            return;

        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        length--;

        shrinkIfNeeded();
    }

    public int append(T item) {
        extendIfNeeded();
        data[length++] = item;
        return length;
    }

    private void extendIfNeeded() {
        if (data.length >= length) {
            int newLength = (int) (data.length * (1 + ratio));
//            data = Arrays.copyOf(data, newLength);
            T[] newArray = (T[]) Array.newInstance(data.getClass().getComponentType(), newLength);
            System.arraycopy(data, 0, newArray, 0, data.length);
            data = newArray;
        }
    }

    public T pop() {
        T result = data[length - 1];
        length--;
        shrinkIfNeeded();
        return result;
    }

    private void shrinkIfNeeded() {
        if (data.length > length * (1 + ratio)) { // shrink array
            T[] newArray = (T[]) Array.newInstance(data.getClass().getComponentType(), length);
            System.arraycopy(data, 0, newArray, 0, length);
            data = newArray;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(data[i]);
            if (i < length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
