package guijavafx.events.mouse;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseEventDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Text text = new Text(100, 100, "Progrmaming is fun");
        pane.getChildren().add(text);
        primaryStage.setTitle("MouseEventDemo");
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);

//        pane.setOnMouseMoved(e -> {
//            text.setX(e.getX());
//            text.setY(e.getY());
//        });

        text.setOnMouseDragged(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
        });

        System.out.println("Scene: " + scene.getWidth() + " " + scene.getHeight());
        System.out.println("Pane: " + pane.getWidth() + " " + pane.getHeight());
        System.out.println("Text: " + text.getX() + " " + text.getY());
        primaryStage.show();
    }
}
