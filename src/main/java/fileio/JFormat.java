package fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import lib.text.ColoredText;

public class JFormat {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(ColoredText.red("Usage: java JFormat <source_file.java>"));
            System.exit(1);
        }

        File file = new File(args[0]);
        // if (!file.exists()) {
        //     System.out.println(ColoredText.red("File does " + file.getName() + " not exist"));
        //     System.exit(2);
        // }
        // if (!file.canRead()) {
        //     System.out.println(ColoredText.red("Cannot read " + file.getName()));
        //     System.exit(3);
        // }        

        try (
            Scanner in = new Scanner(file);
            PrintWriter out = new PrintWriter(file); 
        ) {
            System.out.println(ColoredText.green("Formatting file " + file.getName()));
            // System.out.println("Fomatted");
            while (in.hasNextLine()) {
                StringBuilder s = new StringBuilder(in.nextLine());
                System.out.println(s);
                if (s.charAt(s.length() - 1) == '{') {
                    s.insert(s.length() - 2, "\n");
                }
                System.out.println(s);

                out.println(s);
            }

        } catch(FileNotFoundException e) {
            System.out.println(ColoredText.red(e.getMessage()));
        }
    }
}
