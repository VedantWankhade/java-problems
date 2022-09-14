package general.arrays.D;

import java.util.Arrays;

public class GenerateArrayWithRandomInts {
    public static int[] getArrayOfRandomInts(int n, int randMax) {
        int[] arr = new int[n];

        for (int i= 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * randMax);
        }

        return arr;
    }

    public static int[] usingArrays(int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, (int) (Math.random() * 10));
        return arr;
    }

//    public static int[]

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(getArrayOfRandomInts(5, 5)));

        System.out.println(Arrays.toString(usingArrays(10)));
    }
}
