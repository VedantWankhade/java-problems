package guijavafx.basics.ex;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessBoard extends Application {
	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		boolean dark = true;
		
		for (int i = 0; i < 8; i++) {
			dark = !dark;
			for (int j = 0; j < 8; j++) {
				Rectangle r = new Rectangle();
				if (!dark) r.setFill(Color.WHITE);
				r.setWidth(50);
				r.setHeight(50);
				dark = !dark;
				pane.add(r, j, i);
			}
		}
			
		primaryStage.setTitle("ChessBoard");
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}
}
