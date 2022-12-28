package guijavafx.basics.general.ex;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Cylinder extends Application {
	@Override 
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		double upperEllipseCenterX = 100;
		double upperEllipseCenterY = 100;
		
		double height = 300;
		
		double lowerEllipseCenterX = upperEllipseCenterX;
		double lowerEllipseCenterY = upperEllipseCenterY + height;
		
		double ellipseRadiusX = 120;
		double elliseRadiusY = 55;
		
		Ellipse e1 = new Ellipse(upperEllipseCenterX, upperEllipseCenterY, ellipseRadiusX, elliseRadiusY);
		Ellipse e2 = new Ellipse(lowerEllipseCenterX, lowerEllipseCenterY, ellipseRadiusX, elliseRadiusY);
		
		e1.setStroke(Color.BLACK);
		e1.setFill(Color.WHITE);
		e2.setStroke(Color.BLACK);
		e2.setFill(Color.WHITE);
		
		double leftLineStartX = upperEllipseCenterX - ellipseRadiusX;
		double leftLineStartY = upperEllipseCenterY;
		
		double leftLineEndX = lowerEllipseCenterX - ellipseRadiusX;
		double leftLineEndY = lowerEllipseCenterY;
		
		
		double rightLineStartX = upperEllipseCenterX + ellipseRadiusX;
		double rightLineStartY = upperEllipseCenterY;
		
		double rightLineEndX = lowerEllipseCenterX + ellipseRadiusX;
		double rightLineEndY = lowerEllipseCenterY;
		
		Line leftLine = new Line(leftLineStartX, leftLineStartY, leftLineEndX, leftLineEndY);
		Line rightLine = new Line(rightLineStartX, rightLineStartY, rightLineEndX, rightLineEndY);
		
		Group group = new Group(e1, e2, leftLine, rightLine);
		pane.getChildren().add(group);
		
		primaryStage.setTitle("Cylinder");
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}
}
