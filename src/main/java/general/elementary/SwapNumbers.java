package general.elementary;

/**
 * Swap two numbers
 */
public class SwapNumbers {
    public static void swap() {
        int a = 2;
        int b = 5;

        System.out.println(a + " " + b);

        a = (a + b) - (b = a); // swap

        System.out.println(a + " " + b);
    }

    public static void main(String[] args) {
        swap();
    }
}
