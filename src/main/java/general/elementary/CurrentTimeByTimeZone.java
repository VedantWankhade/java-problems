package general.elementary;

import java.util.Scanner;

/**
 * @author VedantWankhade
 *
 * Problem: DisplayCurrentTime.java gives a program that displays
 * the current time in GMT. Revise the program so it prompts the user to enter the
 * time zone offset to GMT and displays the time in the specified time zone. Here is
 * a sample run:
 *      Enter the time zone offset to GMT: -5
 *      The current time is 4:50:34
 *
 * References:
 *      https://en.wikipedia.org/wiki/List_of_UTC_offsets
 *      https://www.w3.org/International/core/2005/09/timezone.html#:~:text=The%20zone%20offset%20can%20be,%3A00%20minus%20eight%20hours).
 *      https://docs.oracle.com/javase/tutorial/datetime/iso/timezones.html
 */
public class CurrentTimeByTimeZone {
    public static String currentTimeTZ(int offset) {
        long totalMillis = System.currentTimeMillis();
        System.out.println("Total Millies Passed: " + totalMillis);

        long totalSec = totalMillis / 1000;
        System.out.println("Total Sec Passed: " + totalSec);

        long sec = totalSec % 60;
        System.out.println("Current Sec: " + sec);

        long totalMin = totalSec / 60;

        long min = totalMin % 60;
        System.out.println("Current min: " + min);

        long totalHour = totalMin / 60;

        long hour = (totalHour + offset) % 12;
        System.out.println("Current Hour: " + hour);

        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int offset = in.nextInt();
        in.close();
        System.out.println(currentTimeTZ(offset));
    }
}
