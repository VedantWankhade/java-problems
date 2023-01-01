package general.recursion;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class SierpinskiTraingle extends Application {
    @Override
    public void start(Stage primaryStage) {
        SierpinskiTrainglePane pane = new SierpinskiTrainglePane();
        TextField tfOrder = new TextField();

        tfOrder.setOnAction(e -> pane.setOrder(Integer.parseInt(tfOrder.getText())));
        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hbox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hbox);

        primaryStage.setTitle("SierpinskiTriangle");
        primaryStage.setScene(new Scene(borderPane, 200, 210));
        primaryStage.show();

        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }

    static class SierpinskiTrainglePane extends Pane {
        private int order = 0;

        public void setOrder(int order) {
            this.order = order;
            paint();
        }

        SierpinskiTrainglePane() {}

        protected void paint() {
            Point2D p1 = new Point2D(getWidth() / 2, 10);
            Point2D p2 = new Point2D(10, getHeight() - 10);
            Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);

            this.getChildren().clear();
            displayTraingles(order, p1, p2, p3);
        }

        private void displayTraingles(int order, Point2D p1, Point2D p2, Point2D p3) {
            if (order == 0) {
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.WHITE);

                this.getChildren().add(triangle);
            } else {
                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p31 = p3.midpoint(p1);

                displayTraingles(order - 1, p1, p12, p31);
                displayTraingles(order - 1, p12, p2, p23);
                displayTraingles(order - 1, p31, p23, p3);
            }
        }
    }
}
