package general.numericals;

/**
 * Program to get random character within given limits, let the limits be characters
 */
public class RandomCharacter {
    public static char getRandomCharacter(char ch1, char ch2) {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    public static char getRandomCharacter() {
        return getRandomCharacter('\u0000', '\uFFFF');
    }

    public static char getRandomLowercaseCharacter() {
        return getRandomCharacter('a', 'z');
    }

    public static char getRandomUppercaseCharacter() {
        return getRandomCharacter('A', 'Z');
    }

    public static char getRandomDigitCharacter() {
        return getRandomCharacter('0', '9');
    }

    public static void main(String[] args) {
        System.out.println(getRandomCharacter());
        System.out.println(getRandomCharacter('b', 'r'));
        System.out.println(getRandomLowercaseCharacter());
        System.out.println(getRandomUppercaseCharacter());
        System.out.println(getRandomDigitCharacter());
    }
}
