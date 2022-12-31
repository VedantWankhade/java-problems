package streamio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {
    public static void main(String[] args) throws IOException {
        try (RandomAccessFile io = new RandomAccessFile("inout.dat", "rw")) {
            io.setLength(0);

            for (int i = 0; i < 200; i++) io.writeInt(i);

            System.out.println("Current file lenght is: " + io.length());

            io.seek(0);
            System.out.println("The first number is: " + io.readInt());

            io.seek(4);
            System.out.println("Second numner: " + io.readInt());

            io.seek(9 * 4);
            System.out.println("The tenth number: " + io.readInt());

            io.writeInt(555);

            io.seek(io.length());
            io.writeInt(999);

            System.out.println("The new lenght is " + io.length());

            io.seek(10 * 4);
            System.out.println("The eleventh number is: " + io.readInt());
        }
    }
}
