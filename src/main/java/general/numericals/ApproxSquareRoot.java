package general.numericals;

import java.util.Scanner;

/**
 * (Math: approximate the square root) There are several techniques for implement-
 * ing the sqrt method in the Math class. One such technique is known as the
 * Babylonian method. It approximates the square root of a number, n, by repeat-
 * edly performing the calculation using the following formula:
 * nextGuess = (lastGuess + n / lastGuess) / 2
 * When nextGuess and lastGuess are almost identical, nextGuess is the
 * approximated square root. The initial guess can be any positive value (e.g., 1).
 * This value will be the starting value for lastGuess. If the difference between
 * nextGuess and lastGuess is less than a very small number, such as 0.0001,
 * you can claim that nextGuess is the approximated square root of n. If not, next­
 * Guess becomes lastGuess and the approximation process continues.
 */
public class ApproxSquareRoot {
    public static double sqrt(long n) {
        double lastGuess;
        double nextGuess = 1;

        do {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n / lastGuess) / 2;
            System.out.println("[lastGuess = " + lastGuess + "]");
            System.out.println("[nextGuess = " + nextGuess + "]");
            System.out.println("[nextGuess - lastGuess = " + Math.abs(nextGuess - lastGuess) + "]");
            System.out.println("[nextGuess == lastGuess -> " + (Math.abs(nextGuess - lastGuess) < 0.0001)+ "]");
        } while (Math.abs(nextGuess - lastGuess) >= 0.0001);
        return nextGuess;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        in.close();

        System.out.println(sqrt(n));
    }
}
