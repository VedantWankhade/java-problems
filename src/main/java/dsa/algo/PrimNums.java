package dsa.algo;

import java.util.Scanner;

public class PrimNums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Find all prime numbers <= n, enter n: ");
        int n = in.nextInt();

        final int NUMBER_PER_LINE = 10;
        int count = 0;
        int number = 2;

        System.out.println("The prime numbers are: ");

        int sqrt = 1;

        while (number <= n) {
            boolean isPrime = true;

            if (sqrt * sqrt < number) sqrt++;

            for (int divisor = 2; divisor <= sqrt; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;

                if (count % NUMBER_PER_LINE == 0)
                    System.out.printf("%7d\n", number);
                else System.out.printf("%7d", number);
            }

            number++;
        }
        System.out.println("\n" + count + " prime(s) <= " + n);
    }
}
