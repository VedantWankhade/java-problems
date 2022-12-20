package guijavafx.basics;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

class CustomPane extends StackPane {
	static Random rn;
	static {
		rn = new Random();
	}
	public CustomPane(String title) {
//		this.getChildren().add(new Label(title));
//		this.setStyle("-fx-border-color: red");
		Rectangle r = new Rectangle();
		r.setHeight(this.getHeight() + 100);
		r.setWidth(this.getWidth() + 100);
		Color c = new Color(rn.nextFloat(), rn.nextFloat(), rn.nextFloat(), rn.nextFloat());
		r.setFill(c);
		System.out.println(c.getRed() + " " + c.getGreen() + " " + c.getBlue());
		this.getChildren().add(r);
		this.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
	}
}

public class ShowBorderPane extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		
		pane.setTop(new CustomPane("TOP"));
		pane.setLeft(new CustomPane("LEFT"));
		pane.setRight(new CustomPane("RIGHT"));
		pane.setBottom(new CustomPane("BOTTOM"));
		pane.setCenter(new CustomPane("CENTER"));
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowBorderPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
