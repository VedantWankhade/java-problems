package guijavafx.basics.controlsandmultimedia;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        DescriptionPane descriptionPane = new DescriptionPane();

        String description = "This is a Cute Whale.....";
        descriptionPane.setTaDescription(description);

//        TextArea text = new TextArea();
//        ScrollPane descriptionPane = new ScrollPane(text);
//        text.setText("ASdasasfadkfjad;fadfadf\nasdasdasd");

        Scene scene = new Scene(descriptionPane, 450, 200);
        primaryStage.setTitle("TextAreaDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class DescriptionPane extends BorderPane {
    private TextArea taDescription = new TextArea();

    public DescriptionPane() {

        taDescription.setFont(new Font("Serif", 14));

        taDescription.setWrapText(true);
        taDescription.setEditable(false);

        ScrollPane scrollPane = new ScrollPane(taDescription);

        setCenter(scrollPane);
        setPadding(new Insets(5));
    }

    public void setTaDescription(String text) {
        taDescription.setText(text);
    }
}