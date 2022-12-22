package guijavafx.events.key;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text text = new Text(50, 50, "Press any letter key");
        Pane pane = new Pane();

        pane.getChildren().add(text);

        text.setOnKeyPressed(e -> {
            switch(e.getCode()) {
                case DOWN: text.setY(text.getY() + 10); break;
                case UP: text.setY(text.getY() - 10); break;
                case LEFT: text.setX(text.getX() - 10); break;
                case RIGHT: text.setX(text.getX() + 10); break;
                default:
                    if (e.getText().length() > 0) text.setText(e.getText());
            }
        });

        primaryStage.setTitle("KeyEvenDemo");
        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.show();
        text.requestFocus();
    }
}
