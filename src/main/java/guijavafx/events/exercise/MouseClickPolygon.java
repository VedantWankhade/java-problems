package guijavafx.events.exercise;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class MouseClickPolygon extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Polygon polygon = new Polygon();
        pane.getChildren().add(polygon);
        ObservableList<Double> points = polygon.getPoints();
//        points.add(5.0);
//        points.add(5.0);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        pane.setOnMouseClicked(e -> {
            points.addAll(e.getX(), e.getY());
        });


        primaryStage.setTitle("MouseClickPolygon");
        primaryStage.setScene(new Scene(pane, 200, 200));
        primaryStage.show();
    }
}
