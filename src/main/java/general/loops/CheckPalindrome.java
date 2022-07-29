package general.loops;

import java.util.Scanner;

/**
 * Check if the String is palindrome or not
 */
public class CheckPalindrome {
    public static boolean isPalindrome(String s) {

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();

        System.out.println(isPalindrome(s));
    }
}
