package general.arrays.D;

import java.util.Arrays;

/**
 * (Merge two sorted lists) Write method that merges two sorted lists
 * into a new sorted list
 */

public class MergeSorted {
    public static int[] merge(int[] arr1, int[] arr2) {

        int[] arr = new int[arr1.length + arr2.length];

        int i = 0, left = 0, right = 0;

        while (i < arr.length && left < arr1.length && right < arr2.length) {
            if (arr1[left] < arr2[right]) {
                arr[i] = arr1[left];
                left++;
            } else {
                arr[i] = arr2[right];
                right++;
            }
            i++;
        }

        if (left >= arr1.length) {
            for (; i < arr.length; i++) {
                arr[i] = arr2[right];

                right++;
            }
        } else
        if (right >= arr2.length) {
            for (; i < arr.length; i++) {
                arr[i] = arr1[left];

                left++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr1 = GenerateArrayWithRandomInts.getArrayOfRandomInts(6, 6);
        int[] arr2 = GenerateArrayWithRandomInts.getArrayOfRandomInts(6, 6);

        Arrays.parallelSort(arr1);
        Arrays.parallelSort(arr2);

        System.out.println("Merging " + Arrays.toString(arr1) + " " + Arrays.toString(arr2));

        System.out.println("-> " + Arrays.toString(merge(arr1, arr2)));
    }
}
