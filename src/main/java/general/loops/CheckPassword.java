package general.loops;

/**
 * (Check password) Some websites impose certain rules for passwords. Write a
 * method that checks whether a string is a valid password. Suppose the password
 * rules are as follows:
 * 1. A password must have at least ten characters.
 * 2. A password consists of only letters and digits.
 * 3. A password must contain at least three digits.
 * Write a program that prompts the user to enter a password and displays Valid
 * Password if the rules are followed or Invalid Password otherwise.
 */
public class CheckPassword {
    public static boolean validateLength(String password) {
        return password.length() >= 10;
    }

    public static boolean validateAlphaNumeral(String password) {
        for (char c : password.toCharArray())
            if (!Character.isLetterOrDigit(c)) return false;
        return true;
    }

    public static boolean validate3digits(String password) {
        int digitCount = 0;
        for (char c: password.toCharArray()) {
            digitCount += Character.isDigit(c) ? 1 : 0;
        }
        return digitCount >= 3;
    }

    public static void validatePassword(String password) {
        if (!validateLength(password) || !validateAlphaNumeral(password) || !validate3digits(password)) System.out.println("INVALID!!");
        else System.out.println("VALID!!");
    }

    public static void main(String[] args) {
        validatePassword("sda456");
    }
}

