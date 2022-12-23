package guijavafx.animations.bouncingball;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BallController extends Application {
    @Override
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane();

        Scene scene = new Scene(ballPane, 200, 200);

//        scene.setOnMouseClicked(e -> ballPane.toggleAnimation()); // dont know why not working - not registering second mouse click

        scene.setOnMousePressed(e -> ballPane.pause());
        scene.setOnMouseReleased(e -> ballPane.play());

        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) ballPane.increaseSpeed();
            else if (e.getCode() == KeyCode.DOWN) ballPane.decreaseSpeed();
        });

        primaryStage.setTitle("Bouncing?? ball");
        primaryStage.setScene(scene);
        primaryStage.show();

        ballPane.requestFocus();
    }
}
