package general.recursion;

public class PalindromeTest {
    public static void main(String[] args) {
        System.out.println("moon: " + isPalindromeBetter("moon", 0, "moon".length() - 1));
        System.out.println("noon: " + isPalindromeBetter("noon", 0, "noon".length() - 1));
        System.out.println("a: " + isPalindromeBetter("a", 0, "a".length() - 1));
        System.out.println("ab: " + isPalindromeBetter("ab", 0, "ab".length() - 1));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;

        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;

        return isPalindrome(s.substring(1, s.length() - 1));
    }

    // better recursive helper
    public static boolean isPalindromeBetter(String s, int lo, int hi) {
        if (hi - lo < 1) return true;
        if (s.charAt(lo) != s.charAt(hi)) return false;
        return isPalindromeBetter(s, lo + 1, hi - 1);
    }
}
