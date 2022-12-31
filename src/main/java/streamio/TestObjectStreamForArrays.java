package streamio;

import java.io.*;
import java.util.Arrays;

public class TestObjectStreamForArrays {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int[] numbers = { 1, 2, 3, 4, 5 };
        String[] strings = { "John", "Susan", "Kim" };

//        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat", true))) {
//            output.writeObject(numbers);
//            output.writeObject(strings);
//        }
//
//        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"))) {
//            int[] newNumbers = (int[]) input.readObject();
//            String[] newStrings = (String[]) input.readObject();
//
//            Arrays.stream(newNumbers).forEach(System.out::println);
//            Arrays.stream(newStrings).forEach(System.out::println);
//        }

        try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("array.dat")))) {
            output.writeObject(numbers);
            output.writeObject(strings);
        }

        try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("array.dat")))) {
            int[] newNumbers = (int[]) input.readObject();
            String[] newStrings = (String[]) input.readObject();

            Arrays.stream(newNumbers).forEach(System.out::println);
            Arrays.stream(newStrings).forEach(System.out::println);
        }
    }
}
