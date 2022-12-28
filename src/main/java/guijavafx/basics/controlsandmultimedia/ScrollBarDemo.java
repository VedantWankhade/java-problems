package guijavafx.basics.controlsandmultimedia;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollBarDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text text = new Text(20, 20, "JavaFX Programming");

        ScrollBar hor = new ScrollBar();
        ScrollBar vir = new ScrollBar();
        vir.setOrientation(Orientation.VERTICAL);

        Pane pane = new Pane();
        pane.getChildren().add(text);

        BorderPane pane2 = new BorderPane();
        pane2.setCenter(pane);
        pane2.setBottom(hor);
        pane2.setRight(vir);

        hor.valueProperty().addListener(ov -> {
            text.setX(hor.getValue() * pane.getWidth() / hor.getMax());
        });

        vir.valueProperty().addListener(ov -> {
            text.setY(vir.getValue() * pane.getHeight() / vir.getMax());
        });

        Scene scene = new Scene(pane2, 450, 170);
        primaryStage.setTitle("ScrollDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
