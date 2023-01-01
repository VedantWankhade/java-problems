package general.recursion;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = Math.abs(in.nextInt());
        in.close();

        System.out.println("Fibonacci series:");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
    public static int fib(int n) {
        if (n == 0 || n == 1) {
//            System.out.println(n);
            return n;
        }

        int a = fib(n - 1) + fib(n - 2);

//        System.out.println(a);
        return a;
    }
}
