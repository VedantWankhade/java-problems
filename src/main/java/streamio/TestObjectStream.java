package streamio;

import java.io.*;
import java.util.Date;

public class TestObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat"))) {
            output.writeUTF("John");
            output.writeDouble(86.6);
            output.writeObject(new Date());
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"))) {
            String name = input.readUTF();
            double score = input.readDouble();
            Date date = (Date) input.readObject();
            System.out.println(name + " " + score + " " + date);
        }
    }
}
