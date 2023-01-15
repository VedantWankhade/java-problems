package dsa.algo;

import java.util.Scanner;

public class FastFibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an index for the fib no.: ");
        int index = in.nextInt();
        in.close();

        System.out.println("Fib number at index " + index + " is " + fib(index));
    }

    public static long fib(long n) {
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;

        if (n == 0)
            return f0;
        if (n == 1 || n == 2) return f1;

        for (int i = 3; i <= n; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }

        return f2;
    }
}
