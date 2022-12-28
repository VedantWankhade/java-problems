package guijavafx.basics.general;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ShowCircle extends Application {
	@Override
	public void start(Stage primaryStage) {
		Circle c = new Circle();
		Pane p = new Pane();
		
		c.centerXProperty().bind(p.widthProperty().divide(2));
		c.centerYProperty().bind(p.heightProperty().divide(2));
		c.setRadius(50);
		c.setStroke(Color.GREEN);
		c.setFill(Color.RED);
		p.getChildren().add(c);
		Scene s = new Scene(p, 200, 200);
		primaryStage.setTitle("CIRASD");
		primaryStage.setScene(s);
		primaryStage.show();
	}
}
