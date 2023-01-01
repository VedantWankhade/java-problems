package generics;

public class GenericMethodDemo {
    public static void main(String[] args) {
        Integer[] integers = { 1, 2, 3, 4, 5 };
        String[] strings = { "London", "Paris", "New York", "Austin" };

        // all the following ways work

        GenericMethodDemo.<Integer>printStatic(integers);
        GenericMethodDemo.<String>printStatic(strings);

        GenericMethodDemo.printStatic(integers);
        GenericMethodDemo.printStatic(strings);

        printStatic(integers);
        printStatic(strings);

        GenericMethodDemo demo = new GenericMethodDemo();
        demo.<Integer>print(integers);
        demo.print(integers);
        demo.<String>print(strings);
        demo.print(strings);
    }

    public static <E> void printStatic(E[] list) {
        for (E e: list) System.out.print(e + " ");
        System.out.println();
    }

    public <E> void print(E[] a) {
        for(E e: a) System.out.print(e + " ");
        System.out.println();
    }
}
