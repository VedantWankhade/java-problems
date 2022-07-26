package general.elementary;

/**
 * @author VedantWankhade
 *
 * Problem: The problem is to develop a program that displays the current time in GMT (Greenwich Mean
 * Time) in the format hour:minute:second, such as 13:19:8.
 * The currentTimeMillis method in the System class returns the current time in milli-
 * seconds elapsed since the time midnight, January 1, 1970 GMT. This
 * time is known as the UNIX epoch. The epoch is the point when time starts, and 1970 was the
 * year when the UNIX operating system was formally introduced.
 *
 * Java also provides the System.nanoTime() method that returns the elapse time in nano-
 * seconds. nanoTime() is more precise and accurate than currentTimeMillis()
 *
 * References:
 *      https://en.wikipedia.org/wiki/Unix_time
 */
public class DisplayCurrentTime {
    public static String currentTime() {
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

        long hour = totalHour % 12;
        System.out.println("Current Hour: " + hour);

        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

    public static void main(String[] args) {
        System.out.println(currentTime());
    }
}
