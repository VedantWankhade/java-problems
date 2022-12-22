package guijavafx.animations;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

//        Rectangle rect = new Rectangle(0, 0, 25, 50);
        Rectangle rect = new Rectangle(25, 50);
        rect.setFill(Color.ORANGE);

        Circle circ = new Circle(125, 100, 50);
        circ.setFill(Color.WHITE);
        circ.setStroke(Color.BLACK);

        pane.getChildren().add(circ);
        pane.getChildren().add(rect);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(3000));
        pt.setPath(circ);
        pt.setNode(rect);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
//        pt.setAutoReverse(true);
        pt.play();

        circ.setOnMousePressed(e -> pt.pause());
        circ.setOnMouseReleased(e -> pt.play());

        primaryStage.setTitle("PathTransition");
        primaryStage.setScene(new Scene(pane, 250, 200));
        primaryStage.show();
    }
}
