package guijavafx.basics.controlsandmultimedia;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class CheckBoxDemo extends ButtonDemo {
    @Override
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();

        Font fontBoldItalic = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
        Font fontBold = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font fontItalic = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fontNormal = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20);

        text.setFont(fontNormal);

        VBox paneForCheckBoxes = new VBox(20);
        paneForCheckBoxes.setPadding(new Insets(5));
        paneForCheckBoxes.setStyle("-fx-border-color: green");
        CheckBox checkBold = new CheckBox("Bold");
        CheckBox checkItalic = new CheckBox("Italic");
        paneForCheckBoxes.getChildren().addAll(checkBold, checkItalic);
        pane.setRight(paneForCheckBoxes);

        EventHandler<ActionEvent> handler = e -> {
            if (checkBold.isSelected() && checkItalic.isSelected()) text.setFont(fontBoldItalic);
            else if (checkBold.isSelected()) text.setFont(fontBold);
            else if (checkItalic.isSelected()) text.setFont(fontItalic);
            else text.setFont(fontNormal);
        };

        checkBold.setOnAction(handler);
        checkItalic.setOnAction(handler);

        return pane;
    }
}
