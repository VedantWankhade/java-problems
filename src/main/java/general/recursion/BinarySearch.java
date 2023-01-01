package general.recursion;

import general.arrays.D.GenerateArrayWithRandomInts;

import java.util.Arrays;

public class BinarySearch {
    public static int recBinarySearch(int[] list, int key) {
        return recBinarySearch(list, key, 0, list.length - 1);
    }

    private static int recBinarySearch(int[] list, int key, int lo, int hi) {
        if (lo > hi) return - lo - 1; // not found

        int mid = (lo + hi) / 2;

        if (key < list[mid]) return recBinarySearch(list, key, lo, mid - 1);
        if (key == list[mid]) return mid;
        return recBinarySearch(list, key, mid + 1, hi);
    }

    public static void main(String[] args) {
        int[] arr = GenerateArrayWithRandomInts.getArrayOfRandomInts(10, 10);
        int key = arr[(int) (Math.random() * 10)];
        System.out.println("Array: " + Arrays.toString(arr) + " Key: " + key);
        System.out.println("Index: " + recBinarySearch(arr, key));
    }
}
