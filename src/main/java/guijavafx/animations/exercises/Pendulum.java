package guijavafx.animations.exercises;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pendulum extends Application {
    PathTransition animation = new PathTransition();

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle circle = new Circle(1, 2,7);

        Arc arc = new Arc(400, 400, 200, 200, 200, 140);
        pane.getChildren().addAll(circle, arc);
        arc.setFill(Color.color(1, 1, 1, 0));
        arc.setStroke(Color.BLACK);

        animation.setPath(arc);
        animation.setNode(circle);
        animation.setAutoReverse(true);
        animation.setDuration(Duration.millis(2000));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setRate(2);
        animation.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        animation.play();

        // change animation according to circle position
        // speed = some function of y coordinate
        Timeline speed = new Timeline(new KeyFrame(Duration.millis(2), s -> {
            animation.setRate(circle.getCenterY());
            System.out.println("cemter: " + circle.getCenterY());
            System.out.println(animation.getCurrentRate());
        }));
        speed.setCycleCount(Timeline.INDEFINITE);

        speed.play();

        primaryStage.setTitle("Pendulum");
        primaryStage.setScene(new Scene(pane, 700, 700));
        primaryStage.show();
    }
}
