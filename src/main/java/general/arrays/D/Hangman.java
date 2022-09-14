package general.arrays.D;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Hangman {
    static Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    private static String getRandomWord() {
        String[] words = {"hello", "help", "programming", "vedant"};

        int index = (int) (Math.random() * 4);
        return words[index];
    }

    private static void play() {


        String word = getRandomWord();
        System.out.println("[word -> " + word + "]");
//        System.out.println(word);
        int n = word.length();
        Character[] auxWord = new Character[n];
        for (int i = 0; i < n; i++) auxWord[i] = '*';

        boolean flag = true;

        for (int i = 0 ; i < (n + 3); i++) {
            System.out.print("(Guess) Enter a letter in word ");
            Arrays.stream(auxWord).forEach((letter) -> System.out.print(letter + " "));
            System.out.print(" > ");

            char inLetter = sc.next().charAt(0);

            System.out.println("[user chose -> " + inLetter + "]");

            flag = true;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == inLetter) auxWord[j] = word.charAt(j);
                if (auxWord[j] == '*') flag = false;
            }

            if (flag) break;
        }

//        for (char c: auxWord) {
//            if (c == '*') {
//                flag = false;
//                break;
//            }
//        }
        System.out.println(flag ? "YOU WON" : "YOU LOST.... the word was -> " + word);

    }
    public static void main(String[] args) {
        do {
            play();
            System.out.println("Do want to guess another word? [y/N]");
        } while ('y' == sc.next().charAt(0));
    }
}
