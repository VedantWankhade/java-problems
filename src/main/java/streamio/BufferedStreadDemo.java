package streamio;

import java.io.*;

// wrapping a stream in buffered steam increased performance by reducing the r/w operations on disk
public class BufferedStreadDemo {
    public static void main(String[] args) throws IOException {
        try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("temp.dat")))) {
            output.writeUTF("JOHN");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeUTF("Georghe");
            output.writeDouble(105.25);
        }

        try (DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("temp.dat")))) {
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
}
