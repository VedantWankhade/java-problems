package general.recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = in.nextInt();
        in.close();
        n = Math.abs(n);
        System.out.println("Factorial of " + n + " is: " + factorial(n));
    }

    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        } else return n * factorial(n - 1);
    }
}
