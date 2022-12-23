package guijavafx.events.exercise;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CreateRemovePoints extends Application {
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Dynamic Points");
        primaryStage.setScene(new Scene(new DynamicPointsPane(), 500, 500));
        primaryStage.show();
    }
}

class DynamicPointsPane extends Pane {
    double radius = 5;
    public DynamicPointsPane() {
        this.setOnMousePressed(this::togglePoint);
    }

    public void togglePoint(MouseEvent e) {
        if (e.isPrimaryButtonDown()) {
            Circle circle = new Circle(e.getX(), e.getY(), this.radius);
            this.getChildren().add(circle);
        } else if (e.isSecondaryButtonDown()) {
            this.getChildren().forEach(c -> {
                if (c.getTypeSelector().equals("Circle") && c.contains(new Point2D(e.getX(), e.getY()))) this.getChildren().remove(c);
            });
        }
    }
}
