package guijavafx.basics.controlsandmultimedia;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        String[] countries = {
                "Canada", "China", "Denmark",
                "France", "Germany", "India", "Norway", "United Kingdom",
                "United States of America"
        };

        Text text = new Text(20, 20, countries[0]);

        ComboBox<String> select = new ComboBox<>();
        select.getItems().addAll(countries);
        select.setValue(countries[0]);
        BorderPane pane = new BorderPane();
        pane.setTop(text);
        pane.setCenter(select);

        select.setOnAction(e -> text.setText(select.getValue()));

        primaryStage.setTitle("Sdasd");
        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();
    }
}
