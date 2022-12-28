package guijavafx.animations;

import guijavafx.basics.general.clock.ClockPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ClockAnimation extends Application {
    @Override
    public void start(Stage primaryStage) {
        ClockPane clock = new ClockPane();
        Timeline tick = new Timeline(new KeyFrame(Duration.millis(1000),
                event -> {
                    clock.setCurrentTime();
                }));
        tick.setCycleCount(Timeline.INDEFINITE);
        tick.play();
        primaryStage.setTitle("Clock Animation");
        primaryStage.setScene(new Scene(clock, 500, 500));
        primaryStage.show();
    }
}
