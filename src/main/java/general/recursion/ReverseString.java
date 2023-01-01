package general.recursion;

public class ReverseString {
    public static void main(String[] args) {
        String s = "ABCDEFG";
        System.out.println(s);
        reverseDisplay(s, s.length() - 1);
//        System.out.println(s);
    }

    public static void reverseDisplay(String s, int hi) {
        if (hi >= 0) {
            System.out.print(s.charAt(hi));
            reverseDisplay(s, hi - 1);
        }
    }
}
