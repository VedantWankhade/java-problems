package general.selections;

import java.util.Scanner;

/**
 * @author VedantWankhade
 *
 * Problem:  The program
 * randomly generates two single-digit integers, number1 and number2, with number1 >=
 * number2, and it displays to the student a question such as “What is 9 - 2?” After the student
 * enters the answer, the program displays a message indicating whether it is correct
 */
public class SubtractionQuiz {

    public static int getRandom() {
        return (int) (Math.random() * 10);
    }

    public static void quiz() {
        int num1 = getRandom();
        int num2 = getRandom();

        num1 = num1 < num2 ? num1 + num2 - (num2 = num1) : num1; // swap if num2 > num1

        System.out.printf("What is %d - %d ? : ", num1, num2);
        Scanner in = new Scanner(System.in);
        int ans = in.nextInt();
        in.close();

        if (ans == (num1 - num2)) System.out.println("CORRECT");
        else {
            System.out.println("WRONG");
            System.out.printf("%d - %d is %d", num1, num2, num1 - num2);
        }
    }

    public static void main(String[] args) {
        quiz();
    }
}
