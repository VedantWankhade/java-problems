package guijavafx.basics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowImage extends Application {
	@Override
	public void start(Stage primaryStage) {
		Pane pane = new HBox(10);
		pane.setPadding(new Insets(15, 15, 15, 15));
		Image image = new Image("https://png.pngtree.com/png-clipart/20190617/original/pngtree-hand-drawn-whale-cartoon-whale-beautiful-whale-blue-whale-png-image_3830339.jpg");
		
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(500);
		imageView.setFitWidth(500);
		
		ImageView imageView2 = new ImageView(image);
		imageView2.setFitHeight(100);
		imageView2.setFitWidth(100);
		
		ImageView imageView3 = new ImageView(image);
		imageView3.setFitHeight(100);
		imageView3.setFitWidth(100);
		imageView3.setRotate(90);
		
		pane.getChildren().addAll(imageView, imageView2, imageView3);
		Scene scene = new Scene(pane);
		primaryStage.setTitle("IMage demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
