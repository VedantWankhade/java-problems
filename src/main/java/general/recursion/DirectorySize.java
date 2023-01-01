package general.recursion;

import java.io.File;
import java.util.Scanner;

public class DirectorySize {
    public static void main(String[] args) {
        System.out.print("Enter a directory or a file: ");
        Scanner in = new Scanner(System.in);
        String dir = in.nextLine();

        System.out.println(getSize(new File(dir)) + " bytes");
    }

    public static long getSize(File dir) {
        long size = 0;

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (int i = 0; files != null && i < files.length; i++) size += getSize(files[i]);
        } else size += dir.length();

        return size;
    }
}
