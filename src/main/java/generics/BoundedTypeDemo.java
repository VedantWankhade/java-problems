package generics;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class BoundedTypeDemo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(2, 2);
        Circle circ = new Circle(2);

        System.out.println("Same area? " + equalArea(rect, circ));

        // womt work
//        Point2D p = new Point2D(1, 2);
//        equalArea(rect, p);
    }

    public static <E extends Shape> boolean equalArea(E obj1, E obj2) {
        return obj2 == obj1;
    }
}
