package general.loops;

public class PatternPrinting {
    public static void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void pattern2(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

//    public static void pyramidOf3() {
//        for ()
//    }

    public static void matrix(int n) {
        int i = n;
        while (i-- != 0) {
            int j = n;
            while (j-- != 0) System.out.print((int) (Math.random() * 2) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        matrix(8);
//        pattern1(8);
        pattern2(7);
    }
}
