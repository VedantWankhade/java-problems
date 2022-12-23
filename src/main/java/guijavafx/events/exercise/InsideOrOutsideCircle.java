package guijavafx.events.exercise;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InsideOrOutsideCircle extends Application {
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100, 60, 50);
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        Text text = new Text();

        pane.getChildren().add(text);
        pane.setOnMouseMoved(e -> {
//            if (isInside(e.getX(), e.getY(), circle.getCenterX(), circle.getCenterY(), circle.getRadius())) text.setText("INSIDE");
//            else text.setText("OUTSIDE");

            if (circle.contains(new Point2D(e.getX(), e.getY()))) text.setText("INSIDE");
            else text.setText("OUTSIDE");
            text.setX(e.getX());
            text.setY(e.getY());
        });

        primaryStage.setTitle("Inside or Outside Circle");
        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();
    }

//    private boolean isInside(double x, double y, double centerX, double centerY, double r) {
//        double d = Math.sqrt(Math.pow((x - centerX), 2) + Math.pow((y - centerY), 2));
//        return d - r < 0;
//    }
}
