package guijavafx.events.exercise;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlternateText extends Application {
    @Override
    public void start(Stage primaryStage) {
        String a = "Welcome to java";
        String b = "LearningJavaFX";
        StackPane pane = new StackPane();

        Text text = new Text(a);
        pane.setOnMouseClicked(e -> text.setText(text.getText().equals(a) ? b : a));

        pane.getChildren().add(text);
        primaryStage.setTitle("AlternateText");
        primaryStage.setScene(new Scene(pane, 100, 100));
        primaryStage.show();
    }
}
