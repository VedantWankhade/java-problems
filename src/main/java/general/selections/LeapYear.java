package general.selections;

/**
 * Determine if the year is leap year or not
 *
 * A year is leap year if it is divisible by 4, but not by 100, or if it is divisible by 400
 */
public class LeapYear {
    public static boolean isLeap(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    public static void main(String[] args) {
        int year = (int) (Math.random() * (3000 - 2000 + 1)) + 2000;
        System.out.println(year);
        System.out.println(isLeap(year) ? "leap" : "not leap");
    }
}
