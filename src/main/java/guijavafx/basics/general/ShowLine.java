package guijavafx.basics.general;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ShowLine extends Application {
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(new LinePane(), 200, 200);
		primaryStage.setTitle("Showline");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

class LinePane extends Pane {
	public LinePane() {
		Line line1 = new Line(0, 0, 0, 0);
		line1.endXProperty().bind(this.widthProperty());
		line1.endYProperty().bind(this.heightProperty());
		line1.setStrokeWidth(5);
		line1.setStroke(Color.GREEN);
		
		Line line2 = new Line(0, 0, 0, 0);
		line2.startXProperty().bind(this.widthProperty());
		line2.endYProperty().bind(this.heightProperty());
		line2.setStrokeWidth(5);
		line2.setStroke(Color.GREEN);
		this.getChildren().addAll(line1, line2);
	}
}