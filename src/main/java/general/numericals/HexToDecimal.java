package general.numericals;

import java.util.Scanner;

public class HexToDecimal {
    public static int dec(String hex) {
        int dec = 0;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            dec = dec * 16 + hexCharToDigit(c);
        }
        return dec;
    }

    public static int hexCharToDigit(char c) {
        if (c >= 'A' && c <= 'F')
            return 10 + c - 'A';
        return Character.getNumericValue(c); // return c - '0' -> gives integer value of c
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String hex = in.nextLine();
        in.close();

        System.out.println("-> " + dec(hex));
    }
}
