package guijavafx.events.exercise;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DynamicAngles extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Point2D point1 = new Point2D(20, 20);
        Point2D point2 = new Point2D(40, 40);
        Point2D point3 = new Point2D(50, 50);

        Circle circle1 = new Circle(point1.getX(), point1.getY(), 5);
        Circle circle2 = new Circle(point2.getX(), point2.getY(), 5);
        Circle circle3 = new Circle(point3.getX(), point3.getY(), 5);

        pane.getChildren().addAll(circle1, circle2, circle3);

        primaryStage.setTitle("Dynamic angles");
    }
}
