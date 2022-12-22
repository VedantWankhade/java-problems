package guijavafx.events.action;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ResizingCircle extends Application {

	private ResizingCirclePane circlePane = new ResizingCirclePane();

	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		pane.setCenter(this.circlePane);

		HBox buttons = new HBox();
		buttons.setSpacing(5);
		buttons.setAlignment(Pos.CENTER);
		Button enlargeBtn = new Button("Enlarge");
		Button shrinkBtn = new Button("Shrink");

		buttons.getChildren().addAll(enlargeBtn, shrinkBtn);

		pane.setBottom(buttons);

		enlargeBtn.setOnAction(new EnlargeHandler());
		shrinkBtn.setOnAction(new ShrinkHandler());

		// anonymous
//		enlargeBtn.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				circlePane.enlarge();
//			}
//		});
//
//		shrinkBtn.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				circlePane.shrink();
//			}
//		});

		primaryStage.setTitle("ResizingCircle");
		primaryStage.setScene(new Scene(pane, 500, 500));
		primaryStage.show();
	}

	class EnlargeHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			circlePane.enlarge();
		}
	}

	class ShrinkHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			circlePane.shrink();
		}
	}
}

class ResizingCirclePane extends StackPane {
	private Circle circle = new Circle(50);

	public ResizingCirclePane() {
		this.circle.setStroke(Color.BLACK);
		this.circle.setFill(Color.WHITE);
		this.getChildren().add(circle);
	}

	public void enlarge() {
		this.circle.setRadius(this.circle.getRadius() + 2);
	}

	public void shrink() {
		this.circle.setRadius(this.circle.getRadius() > 2 ? this.circle.getRadius() - 2 : this.circle.getRadius());
	}
}