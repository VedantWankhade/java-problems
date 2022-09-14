package general.arrays.D;

import java.util.Arrays;

public class Parition {

    public static int parition(int[] arr) {

        int i = 0, j = 0, k = 0;

        for (j = 1; j < arr.length; j++) {

            if (arr[j] <= arr[i]) {

                arr[j] = (arr[j] + arr[k]) - (arr[k] = arr[j]);
                i = i == k ?  j : i;
                k++;
            }
        }

        arr[i] = (arr[i] + arr[k]) - (arr[k] = arr[i]);
        i = (i + k) - (k = i);

        return i;

    }

    public static void main(String[] args) {
        int[] arr = GenerateArrayWithRandomInts.getArrayOfRandomInts(6, 6);

        System.out.println("Partitioning " + Arrays.toString(arr) + " with " +arr[0] + " as pivot");

        int index = parition(arr);

        System.out.println("-> " + Arrays.toString(arr));
        System.out.println("pivot index -> " + index);

    }
}
