package guijavafx.events.action;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoanCalculator extends Application {
    @Override
    public void start(Stage primaryStage) {

        // text titles
        Text annualInterestRateTitle = new Text("Annual Interest Rate: ");
        Text numberOfYearsTitle = new Text("Number Of Years: ");
        Text loanAmountTitle = new Text("Loan Amount: ");
        Text monthlyPaymentTitle = new Text("Monthly Payment: ");
        Text totalPaymentTitle = new Text("Total Payment: ");

        // text fields
        TextField annualInterestRateField = new TextField();
        TextField numberOfYearsField = new TextField();
        TextField loanAmountField = new TextField();
        TextField monthlyPaymentField = new TextField();
        TextField totalPaymentField = new TextField();

        // error messsage
        Text error = new Text();
        error.setVisible(false);

        // calc button
        Button calcBtn = new Button("Calculate");

        // set events handlers
        calcBtn.setOnAction(e -> {

            try {
                double air = Double.parseDouble(annualInterestRateField.getText());
                double noy = Double.parseDouble(numberOfYearsField.getText());
                double la = Double.parseDouble(loanAmountField.getText());

                double mir = air / 1200;

                double mp = la * mir / (1 - (1 / Math.pow(1 + mir, noy * 12)));
                double tp = mp * noy * 12;

                monthlyPaymentField.setText(String.format("$%.2f", mp));
                totalPaymentField.setText(String.format("$%.2f", tp));
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
                error.setText(ex.getClass() + " " + ex.getMessage());
                error.setFill(Color.RED);
                error.setVisible(true);
            }
        });

        // layout
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(7);
        pane.setVgap(7);

        pane.add(error, 5, 5);

        pane.add(annualInterestRateTitle, 0, 0);
        pane.add(numberOfYearsTitle, 0, 1);
        pane.add(loanAmountTitle, 0, 2);
        pane.add(monthlyPaymentTitle, 0, 3);
        pane.add(totalPaymentTitle, 0, 4);

        pane.add(annualInterestRateField, 1, 0);
        pane.add(numberOfYearsField, 1, 1);
        pane.add(loanAmountField, 1, 2);
        pane.add(monthlyPaymentField, 1, 3);
        pane.add(totalPaymentField, 1, 4);

        pane.add(calcBtn, 1, 5);

        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
