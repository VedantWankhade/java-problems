package guijavafx.events;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AnonHandlerDemo extends Application {
    private TextPane textPane = new TextPane("Programming is Fun");

    @Override
    public void start(Stage primaryStage) {

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(5);

        Button up = new Button("UP");
        Button down = new Button("DOWN");
        Button left = new Button("LEFT");
        Button right = new Button("RIGHT");

        buttons.getChildren().addAll(
            up, down, left, right
        );

//        up.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println(event);
//                textPane.up();
//            }
//        });
//
//        down.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println(event);
//                textPane.down();
//            }
//        });
//
//        left.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println(event);
//                textPane.left();
//            }
//        });
//
//        right.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println(event);
//                textPane.right();
//            }
//        });

        up.setOnAction((event) -> textPane.up());
        down.setOnAction((event) -> textPane.down());
        left.setOnAction((event) -> textPane.left());
        right.setOnAction((event) -> textPane.right());

        BorderPane pane = new BorderPane();
        pane.setCenter(textPane);
        pane.setBottom(buttons);

        primaryStage.setTitle("Text postition");
        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.show();
    }
}

class TextPane extends Pane {
    private Text text;

    public TextPane(String text) {
        this.setWidth(200);
        this.setHeight(200);
        this.text = new Text(this.getWidth() / 2, this.getHeight() / 2, text);
        this.getChildren().add(this.text);
    }

    public void left() {
        this.text.setX(this.text.getX() - 20);
    }

    public void right() {
        this.text.setX(this.text.getX() + 20);
    }

    public void up() {
        this.text.setY(this.text.getY() - 20);
    }

    public void down() {
        this.text.setY(this.text.getY() + 20);
    }
}