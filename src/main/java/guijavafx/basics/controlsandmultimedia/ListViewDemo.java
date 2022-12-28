package guijavafx.basics.controlsandmultimedia;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {
    private String[] flagTitles = {
            "Canada", "China", "Denmark",
            "France", "Germany", "India", "Norway", "United Kingdom",
            "United States of America"
    };

    private ImageView[] imageViews = {
            new ImageView("images/countries/ca.gif"),
            new ImageView("images/countries/china.gif"),
            new ImageView("images/countries/denmark.gif"),
            new ImageView("images/countries/fr.gif"),
            new ImageView("images/countries/germany.gif"),
            new ImageView("images/countries/india.gif"),
            new ImageView("images/countries/norway.gif"),
            new ImageView("images/countries/uk.gif"),
            new ImageView("images/countries/us.gif")
    };

    @Override
    public void start(Stage primaryStage) {
        ListView<String> lv = new ListView<>(FXCollections.observableArrayList(flagTitles));
        lv.setPrefSize(400, 400);
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        FlowPane imagePane = new FlowPane(10, 10);
        BorderPane pane = new BorderPane();
        pane.setLeft(new ScrollPane(lv));
        pane.setCenter(new ScrollPane(imagePane));

        lv.getSelectionModel().selectedItemProperty().addListener(ov -> {
            imagePane.getChildren().clear();
            for(Integer i: lv.getSelectionModel().getSelectedIndices())
                imagePane.getChildren().add(imageViews[i]);
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("ListViewDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
