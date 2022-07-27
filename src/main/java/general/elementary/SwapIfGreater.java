package general.elementary;

/**
 * Swap if second number is greater than first
 */
public class SwapIfGreater {
    public static void swap() {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);

        System.out.println(a + " " + b);

        a = a < b ? (a + b) - (b = a) : a; // swap if b > a

        System.out.println(a + " " + b);
    }

    public static void main(String[] args) {
        swap();
    }
}
