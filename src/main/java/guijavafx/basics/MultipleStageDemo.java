package guijavafx.basics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MultipleStageDemo extends Application {
	public MultipleStageDemo() {
		System.out.println("MultipleStageDemo consrtuvtor");
	}
	@Override
	public void start(Stage primaryStage) {
		System.out.println("Enter start");
		primaryStage.setTitle("Stage 1");
		primaryStage.setScene(new Scene(new Button("OK"), 200, 250));
		primaryStage.show();
		
		Stage stage = new Stage();
		stage.setTitle("Stage 2");
		stage.setScene(new Scene(new Button("NEW STAGE NBUTTON"), 200, 250));
		stage.show();
		stage.setResizable(false);
		System.out.println("Exit start");
	}
}
