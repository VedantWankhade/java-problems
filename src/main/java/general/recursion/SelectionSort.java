package general.recursion;

import general.arrays.D.GenerateArrayWithRandomInts;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = GenerateArrayWithRandomInts.getArrayOfRandomInts(10, 10);
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] list) {
        sort(list, 0, list.length - 1);
    }

    private static void sort(int[] list, int lo, int hi) {
        if (lo < hi) {  // at least two elements
            int indexOfMin = lo;
            int min = list[lo];
            for (int i = lo + 1; i <= hi; i++) {
                if (list[i] < min) {
                    min = list[i];
                    indexOfMin = i;
                }
            }

            list[indexOfMin] = list[lo];
            list[lo] = min;

            sort(list, lo + 1, hi);
        }
    }



//    public static void selectionSort(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {   // lasat one is automatically sorted after n - 1 iteration
//
//            int m = i;
////            System.out.println("Sorting " + arr[m]);
//
//            int j = m - 1;
//            while (j >= 0 && arr[j] > arr[m]) {
//                //swap
////                System.out.println("swapping " + arr[m] + " <=> " + arr[j]);
//                arr[j] = (arr[j] + arr[m]) - (arr[m] = arr[j]);
//                j--;
//                m--;
//            }
//        }
//    }
}
