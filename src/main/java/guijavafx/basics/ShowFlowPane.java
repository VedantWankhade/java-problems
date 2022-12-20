package guijavafx.basics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ShowFlowPane extends Application {
	@Override
	public void start(Stage primaryStage) {
		FlowPane pane = new FlowPane();
		pane.setPadding(new Insets(11, 12, 13, 15));
		pane.setHgap(5);
		pane.setVgap(5);
		
		pane.getChildren().addAll(new Label("First Name:"), new TextField(), new Label("MI:"));
		TextField tfMi = new TextField();
		tfMi.setPrefColumnCount(1);
		pane.getChildren().addAll(tfMi, new Label("Last Name:"), new TextField());
//		pane.getChildren().add(tfMi); // runtime error - can add a particular text field once in same pane
		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("FlowPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
