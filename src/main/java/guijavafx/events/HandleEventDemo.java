package guijavafx.events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HandleEventDemo extends Application {
	@Override
	public void start(Stage primaryStage) {
		HBox pane = new HBox(10);
		pane.setAlignment(Pos.CENTER);
		Button btOK = new Button("OK");
		Button btCancel = new Button("Cancel");
		
		OKHandlerClass handler1 = new OKHandlerClass();
		btOK.setOnAction(handler1);
		CancelHandlerClass handler2 = new CancelHandlerClass();
		btCancel.setOnAction(handler2);
		
		pane.getChildren().addAll(btOK, btCancel);
	
		primaryStage.setTitle("HandleEventDemo");
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}
}

class OKHandlerClass implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
		System.out.println("OK button clicked  " + e);
	}
}

class CancelHandlerClass implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
		System.out.println("Cancel button clicked " + e);
	}
}
