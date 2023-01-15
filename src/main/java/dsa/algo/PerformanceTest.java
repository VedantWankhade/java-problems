package dsa.algo;

public class PerformanceTest {
    public static void main(String[] args) {
        getTime(1000000);
        getTime(10000000);
        getTime(100000000);
        getTime(1000000000);
    }

    public static void getTime(long n) {
        long startTime = System.currentTimeMillis();
        long k = 0;
        for (int i = 1; i <= n; i++)
            k += 5;

        long endTime = System.currentTimeMillis();
        // when input increases ten time, the execution time also increases 10 times approximately
        System.out.println("Execution time for n = " + n + " is " + (endTime - startTime) + " milliseconds");
    }
}
