package guijavafx.events.exercise;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DynamicAngles extends Application {

    Point2DProperty point1 = new Point2DProperty(20, 20);
    Point2DProperty point2 = new Point2DProperty(100, 40);
    Point2DProperty point3 = new Point2DProperty(50, 50);
    Polygon polygon = new Polygon();
    Pane pane = new Pane();
    double radius = 10;
    Text textA = new Text(), textB = new Text(), textC = new Text();

    @Override
    public void start(Stage primaryStage) {

        polygon.setStroke(Color.BLACK);
        polygon.setFill(Color.WHITE);

        Circle circle1 = new Circle(point1.getX(), point1.getY(), radius);
        Circle circle2 = new Circle(point2.getX(), point2.getY(), radius);
        Circle circle3 = new Circle(point3.getX(), point3.getY(), radius);

        circle1.centerXProperty().bind(point1.getxProperty());
        circle1.centerYProperty().bind(point1.getyProperty());

        circle2.centerXProperty().bind(point2.getxProperty());
        circle2.centerYProperty().bind(point2.getyProperty());

        circle3.centerXProperty().bind(point3.getxProperty());
        circle3.centerYProperty().bind(point3.getyProperty());

        circle1.setOnMouseDragged(e -> {
            point1.setxProperty(e.getX());
            point1.setyProperty(e.getY());
            repaintPolygon();
        });

        circle2.setOnMouseDragged(e -> {
            point2.setxProperty(e.getX());
            point2.setyProperty(e.getY());
            repaintPolygon();
        });

        circle3.setOnMouseDragged(e -> {
            point3.setxProperty(e.getX());
            point3.setyProperty(e.getY());
            repaintPolygon();
        });

        pane.getChildren().addAll(circle1, circle2, circle3);

        repaintPolygon();
        pane.getChildren().addAll(textA, textB, textC);

        polygon.setFill(Color.color(1, 1, 1, 0));
        pane.getChildren().add(polygon);

        primaryStage.setTitle("Dynamic angles");
        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();
    }

    private void repaintPolygon() {
        polygon.getPoints().clear();
        polygon.getPoints().addAll(
                point1.getxProperty().get(),point1.getyProperty().get(),
                point2.getxProperty().get(), point2.getyProperty().get(),
                point3.getxProperty().get(), point3.getyProperty().get()
        );

        // angles

        double a = Math.sqrt(
                Math.pow((point1.getxProperty().get() - point2.getxProperty().get()), 2)
                + Math.pow((point1.getyProperty().get() - point2.getyProperty().get()), 2)
        );

        double b = Math.sqrt(
                Math.pow((point1.getxProperty().get() - point3.getxProperty().get()), 2)
                        + Math.pow((point1.getyProperty().get() - point3.getyProperty().get()), 2)
        );

        double c = Math.sqrt(
                Math.pow((point2.getxProperty().get() - point3.getxProperty().get()), 2)
                        + Math.pow((point2.getyProperty().get() - point3.getyProperty().get()), 2)
        );

        double A = Math.cos(Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2) / (2 * b * c));

        double B = Math.cos( - Math.pow(b, 2) + Math.pow(c, 2) + Math.pow(a, 2) / (2 * a * c));

        A *= 180/Math.PI;
        B *= 180/Math.PI;
        double C = 180 - A - B;

        System.out.printf("a: %f b: %f c: %f\nA: %f B: %f C: %f\n", a, b, c, A, B, C);

        textA.setX(point1.getxProperty().get() + radius);
        textA.setY(point1.getyProperty().get() + radius);
        textA.setText(String.format("%.2f", A));

        textB.setX(point2.getxProperty().get() + radius);
        textB.setY(point2.getyProperty().get() + radius);
        textB.setText(String.format("%.2f", B));

        textC.setX(point3.getxProperty().get() + radius);
        textC.setY(point3.getyProperty().get() + radius);
        textC.setText(String.format("%.2f", C));
    }
}

class Point2DProperty extends Point2D {

    DoubleProperty xProperty = new SimpleDoubleProperty();
    DoubleProperty yProperty = new SimpleDoubleProperty();

    public Point2DProperty(double x, double y) {
        super(x, y);
        xProperty.set(this.getX());
        yProperty.set(this.getY());
    }

    public DoubleProperty getxProperty() {
        return xProperty;
    }

    public void setxProperty(double x) {
        xProperty.set(x);
    }

    public DoubleProperty getyProperty() {
        return yProperty;
    }

    public void setyProperty(double y) {
        yProperty.set(y);
    }
}