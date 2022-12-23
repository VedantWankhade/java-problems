package guijavafx.events.exercise;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class EyeHandCoordination extends Application {

    DoubleProperty centerX = new SimpleDoubleProperty();
    DoubleProperty centerY = new SimpleDoubleProperty();

    Property<Color> color = new SimpleObjectProperty<>();
    Pane pane = new Pane();
    int radius = 10;
    int limit = 10;
    Circle circle = new Circle();

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(pane, 500, 500);
        pane.getChildren().add(circle);
        pane.setPrefHeight(scene.getHeight());
        pane.setPrefWidth(scene.getWidth());

        circle.centerXProperty().bind(centerX);
        circle.centerYProperty().bind(centerY);
        circle.fillProperty().bind(color);
        circle.setRadius(radius);
        newCircle();

        long start = System.currentTimeMillis();

        pane.setOnMouseClicked(e -> {
            if (circle.contains(new Point2D(e.getX(), e.getY()))) {
                if (limit > 0) {
                    newCircle();
                    limit--;
                } else {
                    // end the game - show results
                    long stop = System.currentTimeMillis();
                    long d = stop - start;
//                    System.out.println(d / 1000 + " seconds");
                    pane.getChildren().remove(circle);
                    Text text = new Text(String.format("%d seconds", d / 1000));
                    text.setX(pane.getWidth() / 2);
                    text.setY(pane.getHeight() / 2);
                    pane.getChildren().add(text);
                }
            }
        });

        primaryStage.setTitle("Eye Hand Coordination");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void newCircle() {
        randomColor();
        randomCenter();
    }

    private void randomColor() {
//        return Color.color(Math.random(), Math.random(), Math.random());
        this.color.setValue(Color.color(Math.random(), Math.random(), Math.random()));
    }

    private void randomCenter() {
        Random rn = new Random();
//        return new Point2D(rn.nextInt((int) pane.getWidth()) - radius, rn.nextInt((int) pane.getHeight()) - radius);
//        System.out.println(pane.getWidth() + " " + pane.getHeight());
        this.centerX.set(rn.nextInt((int) pane.getWidth()) - radius);
        this.centerY.set(rn.nextInt((int) pane.getHeight()) - radius);
    }
}
