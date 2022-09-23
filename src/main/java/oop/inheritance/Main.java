package oop.inheritance;

public class Main {
    public static void main(String[] args) {
//        GenericObject obj1 = new GenericObject("red", true);
//        GenericObject obj2 = new GenericObject();
//        System.out.println(obj1);
//        System.out.println(obj2);

        Circle circ1 = new Circle(5);
        System.out.println(circ1.getArea());
        GenericObject circ2 = new Circle(8);
        System.out.println(circ2.getArea());
    }
}
