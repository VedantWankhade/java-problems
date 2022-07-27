package general.numericals;

/**
 * Convert decimal integer to hexadecimal
 */
public class DecimalToHex {
    public static String hex(int num) {
        System.out.println("num: " + num);

        StringBuilder hex = new StringBuilder();
        int dividend = num;
        final int DIVISOR = 16;

        while (dividend != 0) {
            int rem = dividend % DIVISOR;
            System.out.println("rem: " + rem);
            char hexDigit = (0 <= rem && rem <= 9) ? (char) (rem + '0') : (char)(rem - 10 + 'A');
            hex.insert(0, hexDigit);
            dividend /= DIVISOR;
        }
        return hex.toString();
    }

    public static void main(String[] args) {
        System.out.println(hex(1234));
    }
}
