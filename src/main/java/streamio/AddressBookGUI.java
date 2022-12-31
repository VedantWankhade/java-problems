package streamio;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookGUI extends Application {
    private Label nameLabel = new Label("Name: ");
    private TextField nameField = new TextField();

    private Label streetLabel = new Label("Street: ");
    private TextField streetField = new TextField();

    private Label cityLabel = new Label("City: ");
    private TextField cityField = new TextField();

    private Label stateLabel = new Label("State: ");
    private TextField stateField = new TextField();

    private Label zipLabel = new Label("Zip: ");
    private TextField zipField = new TextField();

    private List<Address> addresses = new ArrayList<>();

    private int currentIndex = 0;

    Button addButton = new Button("Add +");
    Button firstButton = new Button("First");
    Button nextButton = new Button("Next ->");
    Button previousButton = new Button("<- Previous");
    Button lastButton = new Button("Last");
    Button updateButton = new Button("Update +-");
    Button newButton = new Button("New +");

    Label message = new Label();

    @Override
    public void start(Stage primaryStage) {

        setInitialData();

        VBox inputPane = new VBox();
        inputPane.setPadding(new Insets(5));
        inputPane.setSpacing(5);

        HBox line1 = new HBox(5);
        HBox line2 = new HBox(5);
        HBox line3 = new HBox(5);

        line1.getChildren().addAll(nameLabel, nameField);
        line2.getChildren().addAll(streetLabel, streetField);
        line3.getChildren().addAll(cityLabel, cityField, stateLabel, stateField, zipLabel, zipField);

        addButton.setOnAction(e -> {
            Address address = getAddress();
            addresses.add(address);
            try {
                writeFile();
            } catch (IOException ex) {
                System.out.println("Cannot write to file");
            }

            setMessage("Address added successfully");
        });

        firstButton.setOnAction(e -> {
            setAddress(currentIndex = 0);
            updateButtons(false);
        });

        nextButton.setOnAction(e -> {
            setAddress(++currentIndex);
            updateButtons(false);
        });

        previousButton.setOnAction(e -> {
            setAddress(--currentIndex);
            updateButtons(false);
        });

        lastButton.setOnAction(e -> {
            setAddress(currentIndex = (addresses.size() - 1));
            updateButtons(false);
        });

        updateButton.setOnAction(e -> {
            Address address = getAddress();
            addresses.set(currentIndex, address);
            try {
                writeFile();
            } catch (IOException ex) {
                System.out.println("Cannot write to file");
            }
            setMessage("Address updated successfully");
        });

        newButton.setOnAction(e -> {
            nameField.clear();
            streetField.clear();
            cityField.clear();
            stateField.clear();
            zipField.clear();

            updateButtons(true);
        });

        HBox buttonPane = new HBox(5);
        buttonPane.getChildren().addAll(firstButton, previousButton, nextButton, lastButton, updateButton, newButton, addButton);

        inputPane.getChildren().addAll(line1, line2, line3, message, buttonPane);

        Pane pane = new Pane();
        pane.getChildren().addAll(inputPane);
        primaryStage.setTitle("Address Book");
        primaryStage.setScene(new Scene(pane,500, 500));
        primaryStage.show();
    }

    private void setMessage(String message) {
        this.message.setText(message);
        this.message.setStyle("-fx-text-fill: green; -fx-border-color: green");
        FadeTransition fade = new FadeTransition(Duration.millis(2000), this.message);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
    }

    private void updateButtons(boolean flag) {
        addButton.setDisable(true);
        if (flag) addButton.setDisable(false);
        if (currentIndex == 0) {
            previousButton.setDisable(true);
            firstButton.setDisable(true);
            lastButton.setDisable(false);
            nextButton.setDisable(false);
        } else if (currentIndex == addresses.size() - 1) {
            lastButton.setDisable(true);
            nextButton.setDisable(true);
            previousButton.setDisable(false);
            firstButton.setDisable(false);
        } else {
            previousButton.setDisable(false);
            firstButton.setDisable(false);
            lastButton.setDisable(false);
            nextButton.setDisable(false);
        }
    }

    private void setInitialData() {
        Address a1 = new Address("ABC", "BSDJ ASD", "WRTY", "STWE", "2423");
        Address a2 = new Address("XYZ", "HDFS WER", "EQN", "DU", "693");
        Address a3 = new Address("MNO", "TRU AXH", "EHF", "DHT", "4678");

        addresses.add(a1);
        addresses.add(a2);
        addresses.add(a3);
    }

    private Address getAddress() {
        return new Address(nameField.getText(), streetField.getText(), cityField.getText(), stateField.getText(), zipField.getText());
    }

    private void setAddress(int index) {
        Address address = addresses.get(index);
        nameField.setText(address.getName());
        streetField.setText(address.getStreet());
        cityField.setText(address.getCity());
        stateField.setText(address.getState());
        zipField.setText(address.getZip());
    }

    private void readFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("addressBook.objects")))) {
            this.addresses = (List<Address>) in.readObject();
        }
    }

    private void writeFile() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("addressBook.objects")))) {
            out.writeObject(this.addresses);
        }
    }
}

class Address implements Serializable {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String name, String street, String city, String state, String zip) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
