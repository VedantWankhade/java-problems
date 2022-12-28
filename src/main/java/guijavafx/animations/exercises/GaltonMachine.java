package guijavafx.animations.exercises;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GaltonMachine extends Application {

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);
        int length = 400;
        int slots = 8;
        int balls = 10;

        // draw board
        Line bottomLine = new Line(scene.getWidth() / 2 - length / 2, 450, scene.getWidth() / 2 + length / 2, 450);

        double len = length / slots;

        for (int i = 0; i < slots + 1; i++) {
            Line line = new Line(
                    bottomLine.getStartX() + len * i, bottomLine.getStartY(),
                    bottomLine.getStartX() + len * i, bottomLine.getStartY() - length / 4
            );

            pane.getChildren().add(line);
        }

        Line slantLineLeft = new Line(bottomLine.getStartX(), bottomLine.getStartY() - length / 4, bottomLine.getStartX() + len * 3, bottomLine.getStartY() - length / 4 - 300);
        Line slantLineRight = new Line(bottomLine.getEndX(), bottomLine.getStartY() - length / 4, bottomLine.getStartX() + len * 5, bottomLine.getEndY() - length / 4 - 300);

        pane.getChildren().addAll(bottomLine, slantLineLeft, slantLineRight);

        double height = slantLineLeft.getStartY() - slantLineLeft.getEndY();

        Line temp = new Line(bottomLine.getStartX() + length / 2, bottomLine.getStartY() - length / 4, bottomLine.getStartX() + length / 2, bottomLine.getStartY() - length / 4 - height);

        temp.setStroke(Color.RED);

        // TODO: 27/12/22 Make balls fall into slots and stay 

        double radius = 7;
        boolean flag = true;
        double startY = 2 * (temp.getEndY() + radius);
        double endY = temp.getStartY() - radius;
        double dist = (endY - startY) / (slots - 1);
        double widthDist = (bottomLine.getEndX() - bottomLine.getStartX()) / (slots);

        ArrayList<Double> centers = new ArrayList<>();

        for (int i = 0; i < slots - 1; i++, flag = !flag) {
            double centerX = temp.getStartX();
            double y = startY + dist * i;
            double leftX = centerX - 2 * radius;
            double rightX = centerX + 2 * radius;
            double d = widthDist;

            if (flag) {
                Circle circleCenter = new Circle(centerX, y, radius);
                pane.getChildren().add(circleCenter);
                centers.add(centerX);
                centers.add(y);
            }

            if (i == 1) {
                Circle circleLeft = new Circle(centerX - widthDist / 2, y, radius);
                Circle circleRight = new Circle(centerX + widthDist / 2, y, radius);
                centers.add(centerX - widthDist / 2);
                centers.add(y);
                centers.add(centerX + widthDist / 2);
                centers.add(y);
                pane.getChildren().addAll(circleLeft, circleRight);
            }

            if (i > 1) {
                int m;
                d /= 2;
                double leftCenterX = centerX, rightCenterX = centerX;
                if (flag) {m = i; leftCenterX -= d; rightCenterX += d;}
                else {m = i + 1;}
                boolean flag2 = true;
                boolean flag3 = false;


                for (int j = 1; j < m / 2 + 1; j++) {
                    Circle circleLeft = new Circle(leftCenterX - d, y, radius);
                    Circle circleRight = new Circle(rightCenterX + d, y, radius);

                    centers.add(leftCenterX - d);
                    centers.add(y);
                    centers.add(leftCenterX + d);
                    centers.add(y);

                    pane.getChildren().addAll(circleLeft, circleRight);

                    leftCenterX -= d;
                    rightCenterX += d;

                    if (flag3 && flag2) {
                        d = widthDist / 2;
                        flag3 = !flag3;
                    } else {
                        d = widthDist;
                    }
                    flag2 = !flag2;
                }
            }
        }

        // FIXME: 27/12/22 Window isnt shown before the animation starts, probably something to do with Thread.sleep at 142
        primaryStage.setTitle("Galton Machine");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // animate
        for (int i = 0; i < balls; i++) {
            Circle ball = new Circle(radius);
            pane.getChildren().add(ball);

            Runnable animationThread = new Runnable() {
                @Override
                public void run() {
                    PathTransition fall = new PathTransition();
                    fall.setCycleCount(1);
                    fall.setRate(0.2);
                    fall.setNode(ball);
                    fall.setPath(getPath(widthDist, centers, pane));
                    fall.play();
                }
            };
            animationThread.run();
            Thread.sleep(200);
        }

//        System.out.println("Path: " + path.getPoints() + "\nCenters: " + centers);


    }

    public Polyline getPath(double widthDist, List<Double> centers, Pane pane) {
        Polyline path = new Polyline();
        path.getPoints().clear();
        path.setFill(Color.color(1, 1, 1, 0));
        path.setStroke(Color.BLACK);

        ObservableList<Double> points = path.getPoints();

        points.addAll(centers.get(0), centers.get(1));

        pane.getChildren().add(path);
        double x = centers.get(0);
        double y = centers.get(1);

        for (int i = 0; i < centers.size(); i += 2) {
            int j = i + 1;
            double _x = centers.get(i), _y = centers.get(i + 1);

            if (_y > y) {
                if (Math.random() > 0.5) {
                    points.addAll(x - widthDist / 2, _y);
                    x -= widthDist / 2;
                    y = _y;
                } else {
                    points.addAll(x + widthDist / 2, _y);
                    x += widthDist / 2;
                    y = _y;
                }
            }
        }
        path.setVisible(false);
        return path;
    }
}
