package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean continueInput = true;

        while (continueInput) {
            try {
                System.out.print("Enter an integer: ");
                int num = in.nextInt();
                System.out.println("SUCCESSSSSSSSS");
                continueInput = false;
            } catch (InputMismatchException e) {
                System.out.println("FAILUREEEEEEE");
                in.nextLine();
            }
        }
    }
}
