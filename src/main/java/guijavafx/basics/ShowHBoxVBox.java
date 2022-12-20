package guijavafx.basics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowHBoxVBox extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		pane.setTop(getHBox());
		pane.setLeft(getVBox());
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("HBoxVBox");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private HBox getHBox() {
		HBox hbox = new HBox(15);
		hbox.setPadding(new Insets(15, 15, 15, 15));
		hbox.setStyle("-fx-background-color: gold");
		hbox.getChildren().add(new Button("Computer Science"));
		hbox.getChildren().add(new Button("Chemistry"));
		ImageView imageView = new ImageView(new Image("https://png.pngtree.com/png-clipart/20190617/original/pngtree-hand-drawn-whale-cartoon-whale-beautiful-whale-blue-whale-png-image_3830339.jpg"));
		imageView.setFitHeight(200);
		imageView.setFitWidth(200);
		hbox.getChildren().add(imageView);
		return hbox;
	}

	private VBox getVBox() {
		VBox vbox = new VBox(15);
		vbox.setPadding(new Insets(15, 5, 5, 5));
		vbox.getChildren().add(new Label("Courses"));
		
		Label[] courses = { new Label("CSCI 1301"), new Label("CSCI 1302"), new Label("CSCI 2410"), new Label("CSCI 1425r3") };
		
		for (Label course: courses) {
			VBox.setMargin(course, new Insets(0, 0, 0, 15));
			vbox.getChildren().add(course);
		}
		return vbox;
	}
}
