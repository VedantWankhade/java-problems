package dsa.algo;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int m = input.nextInt();
        System.out.print("Enter second integer: ");
        int n = input.nextInt();
        System.out.println("The greatest common divisor for " + m +
                " and " + n + " is " + gcdEuclid(m, n));
    }

    public static int gcd(int m, int n) {
        m = m < n ? m : (m + n) - (n = m);

        if (n % m == 0) return m;

        System.out.println("m: " + m + " n: " + n);

        for (int i = m / 2; i > 1; i--) {
            if (m % i == 0 && n % i == 0) return i;
        }

        return 1;
    }

    public static int gcdEuclid(int m, int n) {
        m = m < n ? m : (m + n) - (n = m);

        if (n %  m == 0) return m;

        return gcdEuclid(n, n % m);
    }
}
