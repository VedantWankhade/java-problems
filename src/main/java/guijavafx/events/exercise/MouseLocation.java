package guijavafx.events.exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseLocation extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Text text = new Text();
        pane.getChildren().add(text);
        pane.setOnMouseMoved(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
            text.setText(String.format("(%.2f, %.2f)", e.getX(), e.getY()));
        });

        primaryStage.setTitle("MouseLocation");
        primaryStage.setScene(new Scene(pane, 200, 200));
        primaryStage.show();
    }
}
