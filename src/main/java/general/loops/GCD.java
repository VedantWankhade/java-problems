package general.loops;

import java.util.Scanner;

/**
 * Calculate GCD of two numbers
 */
public class GCD {
    public static int gcd(int num1, int num2) {
        int gcd = 1;
        int n = 2;

        while (n <= Math.min(num1, num2)) {
            if (num1 % n == 0 && num2 % n == 0) gcd = n;
            n++;
        }

        return gcd;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        in.close();

        System.out.println("GCD: " + gcd(num1, num2));
    }
}
