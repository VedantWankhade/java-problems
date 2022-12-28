//package guijavafx.basics.controlsandmultimedia.exercises;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//
//public class TicTacToe extends Application {
//    private char whoseTurn = 'X';
//    private Cell[][] cell = new Cell[3][3];
//    private Label lblStatus = new Label("X's turn to play");
//
//    @Override
//    public void start(Stage primaryStage) {
//        GridPane board = new GridPane();
//        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++)
//                board.add(cell[i][j] = new Cell(), j, i);
//
//        BorderPane borderPane = new BorderPane();
//        borderPane.setCenter(board);
//        borderPane.setBottom(lblStatus);
//
//        primaryStage.setTitle("Tic Tac Toe");
//        primaryStage.setScene(new Scene(borderPane, 450, 140));
//        primaryStage.show();
//    }
//
//    public boolean isFull() {
//        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < 3; j++)
//                if (cell[i][j].getToken() == ' ')
//                    return false;
//        return true;
//    }
//
//    public boolean isWon(char token) {
//        for (int i = 0; i < 3; i++)
//            if (cell[i][0].getToken() == token && cell[i][1].getToken() == token && cell[i][2].getToken() == token)
//                return true;
//
//        for (int j = 0; j < 3; j++)
//            if (cell[0][j].getToken() == token)
//    }
//}
//
//class Cell extends Pane {
//    private char token = ' ';
//
//    public char getToken() {
//        return this.token;
//    }
//}
