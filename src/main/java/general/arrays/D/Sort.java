package general.arrays.D;

import java.util.Arrays;

public class Sort {

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) return false;
        }
        return true;

    }

    public static void selectionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {   // lasat one is automatically sorted after n - 1 iteration

            int m = i;
//            System.out.println("Sorting " + arr[m]);

            int j = m - 1;
            while (j >= 0 && arr[j] > arr[m]) {
                //swap
//                System.out.println("swapping " + arr[m] + " <=> " + arr[j]);
                arr[j] = (arr[j] + arr[m]) - (arr[m] = arr[j]);
                j--;
                m--;
            }
        }

    }

    public static void main(String[] args) {

        int[] arr = GenerateArrayWithRandomInts.getArrayOfRandomInts(10, 10);
        System.out.println(isSorted(arr));

        Arrays.parallelSort(arr);
        System.out.println(isSorted(arr));

//            while (true) {
//                int n = (int) (Math.random() * 100000) + 1;
//                int[] arr = GenerateArrayWithRandomInts.getArrayOfRandomInts(n, 2 * n);
//                int[] sorted = arr.clone();
//                long start, end, time;
//
//                start = System.currentTimeMillis();
//                Arrays.parallelSort(sorted);
//                end = System.currentTimeMillis();
//
//                System.out.println("System took: " + (end - start));
//
//                start = System.currentTimeMillis();
//                selectionSort(arr);
//                end = System.currentTimeMillis();
//                System.out.println("You took: " + (end - start));
//
//                if (Arrays.equals(arr, sorted)) {
//                    System.out.println("✅" + " Test Passed");
//                } else {
//                    System.out.println("❌" + " Test Failed");
//                    System.out.println("Expected " + Arrays.toString(sorted) + " Got " + Arrays.toString(arr));
//                    break;
//                }
//            }
    }
}
