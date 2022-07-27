package general.numericals;

import java.util.Random;
import java.util.Scanner;

/**
 * @author VedantWankhade
 *
 * Problem: Generate random numbers
 *
 * Math.random() gives random double value between 0.0 (inclusive) and 1.0 (exlusive)
 *
 * References:
 *      https://www.javatpoint.com/how-to-generate-random-number-in-java
 *      https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
 */
public class GeneratingRandomNumbers {
    /**
     * Generate random integer greater than a
     * @param a
     * @return int
     */
    public static int random(int a) {
        return (int) (Math.random() * 10) + a;
    }

    /**
     * Generate random integer within (a, b]
     * @param a
     * @param b
     * @return int
     */
    public static int random(int a, int b) {
        return (int) (Math.random() * (b - a) + a);
    }

    /**
     * Generate random integer using Random class
     * @param a
     * @return int
     */
    public static int randomWithRandomClass(int a) {
        Random generator = new Random();
        return generator.nextInt(a);
    }

    /**
     * Generate random integer using Random class
     * @param a
     * @param b
     * @return int
     */
    public static int randomWithRandomClass(int a, int b) {
        Random generator = new Random();
        return generator.nextInt(a, b);
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
//        in.close();

        System.out.println(randomWithRandomClass(2, 5));
    }
}
