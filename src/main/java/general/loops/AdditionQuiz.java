package general.loops;

import java.util.Scanner;

/**
 * Create an addition quiz ysuig loops
 */
public class AdditionQuiz {
    public static void quiz() {
        int num1 = (int) (Math.random() * 10);
        int num2 = (int) (Math.random() * 10);

        System.out.printf("What is %d + %d ? : ", num1, num2);
        Scanner in = new Scanner(System.in);

        int ans = in.nextInt();

        while (ans != (num1 + num2)) {
            System.out.println("Wrong ansert, try again: ");
            System.out.printf("What is %d + %d ? : ", num1, num2);
            ans = in.nextInt();
        }
        System.out.println("Correct");
    }

    public static void main(String[] args) {
        quiz();
    }
}
