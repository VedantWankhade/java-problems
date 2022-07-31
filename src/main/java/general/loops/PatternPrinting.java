package general.loops;

public class PatternPrinting {
    public static void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void matrix(int n) {
        int i = n;
        while (i-- != 0) {
            int j = n;
            while (j-- != 0) System.out.print((int) (Math.random() * 2) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        matrix(8);
    }
}
