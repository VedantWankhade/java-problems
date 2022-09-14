package general.arrays.D;

import java.io.IOException;
import java.util.Arrays;

public class Search {

    public static int linearSearch(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) if (arr[i] == key) return i;
        return -1;
    }

    public static int binarySearch(int[] sortedArr, int key) {
        int lo = 0, hi = sortedArr.length - 1, mid;

//        if (sortedArr[lo] == key) return lo;
//        if (sortedArr[hi] == key) return hi;



        while (lo <= hi) {

            if (sortedArr[lo] == key) return lo;

            mid = (lo + hi) / 2;

//            if (key < sortedArr[mid]) {
//                if (sortedArr[lo] == key) return lo;
//                hi = mid - 1;
//            } else


            if (key > sortedArr[mid]) {
//                if (sortedArr[hi] == key) return hi; // wont be the earliest key
                lo = mid + 1;
            } else if (sortedArr[mid] == key && sortedArr[mid - 1] != key) {
                return mid;
            } else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        long testCount = 0;
        // shutdown hook
        long finalTestCount = testCount;
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("--------------- SHUTTING DOWN --------------");
            System.out.println(finalTestCount + " TEST COMPLETED");
        }));


//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter number of elements: ");
//        int n = sc.nextInt();
        while (true) {

            int n = (int) (Math.random() * 100) + 1;
            int[] arr = GenerateArrayWithRandomInts.getArrayOfRandomInts(n, n);
            int key = (int) (Math.random() * n);

            System.out.println("Sorting " + Arrays.toString(arr));
            Arrays.sort(arr);
            System.out.println("Finding " + key + " in " + Arrays.toString(arr));

            int expected = linearSearch(arr, key);
            int got = binarySearch(arr, key);

            if (expected == got) System.out.println("✅" + " Test Passed");
            else {
                System.out.println("❌" + " Test Failed\n Expected " + expected + " but got " + got);
                break;
            }
            testCount++;
        }
        System.out.println("-----------" + testCount + " TESTS COMPLETED------------");
//        int index = linearSearch(arr, key);
////        System.out.println(index == -1 ? "Not Found" : "Found at " + index);
//        System.out.println("Finding " + key + " in " + Arrays.toString(arr));
//        int index = binarySearch(arr, key);
//        System.out.println(index == -1 ? "Not Found" : "Found at " + index);
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//        executor.scheduleAtFixedRate(getRunnable(), 0, 5, TimeUnit.SECONDS);


    }

    public static Runnable getRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                int n = (int) (Math.random() * 10);
                int[] arr = GenerateArrayWithRandomInts.getArrayOfRandomInts(n, n);
                int key = (int) (Math.random() * n);

                System.out.println("Sorting " + Arrays.toString(arr));
                Arrays.sort(arr);
                System.out.println("Finding " + key + " in " + Arrays.toString(arr));
                int index = binarySearch(arr, key);
                System.out.println(index == -1 ? "Not Found" : "Found at " + index);
            }
        };
    }
}
