package general.selections;

import java.util.Scanner;
import general.numericals.GeneratingRandomNumbers;

enum Hand {
    ROCK, PAPER, SCISSORS
}

public class RockPaperScissors {

    public static void play() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your chpice: ");
        Hand userChoice = Hand.valueOf(in.nextLine());

        Hand comHand = Hand.values()[GeneratingRandomNumbers.random(0, 3)];

        System.out.println("user -> " + userChoice);
        System.out.println("com -> " + comHand);
    }

    public static void main(String[] args) {
        play();
    }
}
