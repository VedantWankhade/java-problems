package general.loops;

import java.util.Scanner;

/**
 * You will write a program that
 * randomly generates an integer between 0 and 100, inclusive. The program prompts the user
 * to enter a number continuously until the number matches the randomly generated number. For
 * each user input, the program tells the user whether the input is too low or too high, so the user
 * can make the next guess intelligently
 */
public class GuessTheNumber {
    public static void game() {
        int num = (int) (Math.random() * 101); // random (0, 101]
        int guess;

        Scanner in = new Scanner(System.in);

            System.out.println("Guess the number");
        while (true) {
            guess = in.nextInt();

            if (guess == num) break;

            System.out.println("your guess is too " + (guess > num ? "high" : "low"));
        }
        System.out.println("CORRECT");
    }

    public static void main(String[] args) {
        game();
    }
}
