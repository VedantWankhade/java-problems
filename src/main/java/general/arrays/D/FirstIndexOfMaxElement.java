package general.arrays.D;

import java.util.Arrays;

public class FirstIndexOfMaxElement {

    public static void main(String[] args) {
        // initialize array with random elements
        int[] arr = new int[21];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 21);
        }
        System.out.println(Arrays.toString(arr));

        int leastIndexOfMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[leastIndexOfMax]) leastIndexOfMax = i;
        }

        System.out.println("Max -> " + arr[leastIndexOfMax] + " index -> " + leastIndexOfMax);
    }
}
