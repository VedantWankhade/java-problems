package lib.text;

public abstract class ColoredText {
    public static String coloredString(String s, String color) {
        return color + s + "\033[0m";
    }

    public static String red(String s) {
        return coloredString(s, "\033[0;31m");
    }
    
    public static String green(String s) {
        return coloredString(s, "\033[0;32m");
    }

    public static String yellow(String s) {
        return coloredString(s, "\033[0;33m");
    }
}