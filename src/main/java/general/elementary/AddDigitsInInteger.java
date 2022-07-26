package general.elementary;

/**
 * @author VedantWankhade
 *
 * Problem: (Add the digits in an integer) Write a program that reads an integer between
 * 0 and 1000 and adds all the digits in the integer. For example, if an integer
 * is 932, the addition of all its digits is 14.
 *
 * DO NOT USE LOOPS
 */
public class AddDigitsInInteger {
    public static long multiplyDigits(int num) {
        System.out.println("Num: " + num);

        long ans = 0;

        ans += num % 10;
        num /= 10;

        ans += num % 10;
        num /= 10;

        ans += num % 10;
        num /= 10;

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(multiplyDigits(28));
    }
}
