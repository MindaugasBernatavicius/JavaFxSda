package cf.mindaugas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField textField;
    @FXML
    private Label label;

    @FXML
    private void onButtonClick() {
        label.setText(textField.getText());
        System.out.println("Click!");
    }

    @FXML
    private void initialize() {
        label.setText("Label text...");
        textField.setText("Text field text...");
        System.out.println("Controller is initialized!");
    }
}