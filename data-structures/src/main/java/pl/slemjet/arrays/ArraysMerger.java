package pl.slemjet.arrays;

public class ArraysMerger {
    public static int[] merge(int[] sortedArray1, int[] sortedArray2) {
        int[] mergedArray = new int[sortedArray1.length + sortedArray2.length];

        for (int i = 0, j = 0, k = 0; k < sortedArray1.length + sortedArray2.length; k++) {
            if (i == sortedArray1.length) {
                mergedArray[k] = sortedArray2[j];
                j++;
            } else if (j == sortedArray2.length) {
                mergedArray[k] = sortedArray1[i];
                i++;
            } else {
                if (sortedArray1[i] > sortedArray2[j]) {
                    mergedArray[k] = sortedArray2[j];
                    j++;
                } else {
                    mergedArray[k] = sortedArray1[i];
                    i++;
                }
            }
        }

        return mergedArray;
    }
}
