package fileio;

import java.io.File;

public class ReplaceText {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Invalid Input");
            System.exit(1);
        }

        File sourceFile = new File(args[0]);
        File targetFile = new File(args[1]);
        String oldString = args[2];
        String newString = args[3];

        if (!sourceFile.exists()) {
            System.out.println("Source file " + sourceFile.getName() + " does not exist");
            System.exit(2);
        }
        if (targetFile.exists()) {
            System.out.println("");
        }
    }
}
