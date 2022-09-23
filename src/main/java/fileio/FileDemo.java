package fileio;

import java.io.*;
import java.util.Scanner;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("../../Desktop/newFie.txt/");
        System.out.println(file.exists());

        try {
            PrintWriter out = new PrintWriter(file);
            Scanner in = new Scanner(file);

            out.print("HELLO WORLD BRO");
            out.close();
            while (in.hasNext())
                System.out.println(in.next());
        } catch (FileNotFoundException e) {
            System.out.println("FILE NNOT EXIXST BRO");
        }

    }
}
