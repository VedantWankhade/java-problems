package guijavafx.basics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyJavaFX extends Application {
	@Override
	public void start(Stage primaryStage) {
		Button okBtn = new Button("OK");
		Scene scene = new Scene(okBtn, 200, 200);
		primaryStage.setTitle("First JavaFX Application");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}