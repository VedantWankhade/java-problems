package dsa.collections;

import javafx.scene.shape.Circle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(6);
        Circle c2 = new Circle(5);
        Circle biggerC = max(c1, c2, new ShapeAreaComparator<Circle>());
        System.out.println(biggerC.getRadius());


        String[] cities = {"Atlanta", "Savannah", "New York", "Dallas"};
//        Arrays.sort(cities, new StringComparatorByLength<String>());
        System.out.println(Arrays.toString(cities));

        List<String> cities2 = Arrays.asList(cities);
        cities2.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
//        cities2.sort(String::compareToIgnoreCase);

//        cities2.sort(Comparator.comparing(String::length));
//        System.out.println(cities2);


            Circle[] circles = { new Circle(0, 0, 4), new Circle(3, 4,56), new Circle(1, 2,5) };
            Arrays.sort(circles, Comparator.comparing(Circle::getRadius).thenComparing(Circle::getCenterX).thenComparing(Circle::getCenterY));
    }

    public static Circle max(Circle c1, Circle c2, ShapeAreaComparator<Circle> comparator) {
        if (comparator.compare(c1, c2) > 0) return c1;
        return c2;
    }
}

class ShapeAreaComparator<T extends Circle> implements Comparator<T> {
    public int compare(T s1, T s2) {
        double a1 = 2 * Math.PI * s1.getRadius();
        double a2 = 2 * Math.PI * s2.getRadius();

        if (a1 < a2) return -1;
        else if (a1 == a2) return 0;
        return 1;
    }
}

class StringComparatorByLength<T extends String> implements Comparator<T> {
    public int compare(T s1, T s2) {
        return s1.length() - s2.length();
    }
}

//class StringComparatorByLength implements Comparator<String> {
//    public int compare(String s1, String s2) {
//        return s1.length() - s2.length();
//    }
//}