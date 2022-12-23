package guijavafx.events.exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.stream.Stream;

public class CreateRemovePointsWithBoundingRectangle extends Application {
    @Override
    public void start(Stage primaryStage) {

        CustomDynamicPointsPane pointsPane = new CustomDynamicPointsPane();
        primaryStage.setTitle("Resizing rect");
        primaryStage.setScene(new Scene(pointsPane, 500, 500));
        primaryStage.show();
    }
}

class CustomDynamicPointsPane extends DynamicPointsPane {
    private Rectangle rectangle;
    double  radius = 5;

    public CustomDynamicPointsPane() {
        super();
        this.rectangle = new Rectangle();
        this.rectangle.setStroke(Color.BLACK);
        this.rectangle.setFill(Color.WHITE);
        this.getChildren().add(rectangle);
    }

    public void resizeRect() {

        double leftX = this.getCircleStream()
                .min(this::compareX)
                .map(Circle::getCenterX).get();

        double rightX = this.getCircleStream()
                        .max(this::compareX)
                        .map(Circle::getCenterX).get();

        double upY = this.getCircleStream()
                        .min(this::compareY)
                        .map(Circle::getCenterY).get();

        double bottomY = this.getCircleStream()
                .max(this::compareY)
                .map(Circle::getCenterY).get();

        double length = Math.abs((leftX - this.radius) - (rightX - this.radius)) + radius;
        double height = Math.abs((upY - this.radius) - (bottomY - this.radius)) + radius;

        System.out.println(length + " " + height);

        this.rectangle.setHeight(height);
        this.rectangle.setWidth(length);

        this.rectangle.setX(leftX);
        this.rectangle.setY(upY);
    }

    private Stream<Circle> getCircleStream() {
        return this.getChildren()
                .stream()
                .filter(n -> n.getTypeSelector().equals("Circle"))
                .map(n -> (Circle) n);
    }
    private int compareX(Circle c1, Circle c2) {
        if (c1.getCenterX() < c2.getCenterX()) return -1;
        if (c1.getCenterX() > c2.getCenterX()) return 1;
        return 0;
    }

    private int compareY(Circle c1, Circle c2) {
        if (c1.getCenterY() < c2.getCenterY()) return -1;
        if (c1.getCenterY() > c2.getCenterY()) return 1;
        return 0;
    }

    @Override
    public void  togglePoint(MouseEvent e) {
        super.togglePoint(e);
        resizeRect();
    }
}
