package cf.mindaugas;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Scene scene;

    public static void main(String[] args) {
        Main.launch();
    }

    @Override
    public void init() throws Exception {
        System.out.println("Initializing app");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Starting app");

        // 1 ex:
        // ex1HelloWorld(primaryStage);

        // 2 ex:
        // ex2TwoColumnLayout(primaryStage);

        // 3 ex:
        // ex3GridPane(primaryStage);

        // 4 ex:
        // ex4TextControls(primaryStage);

        // 5 ex:
        // ex5ListView(primaryStage);

        // 6 ex:
        // ex6PropertiesAndChangeListeners(primaryStage);

        // 7 ex:
        // ex7ControlPropertyBindingTextFieldAndLabel(primaryStage);

        // 8 ex:
        // ex8ControlPropertyBindingSlider(primaryStage);

        // 9 ex:
        // ex9ActionEvent(primaryStage);

        // 10 ex:
        // ex10EventArgument(primaryStage);

        // 11 ex:
        // ex11FXML(primaryStage);

        // 12 ex:
        // ex12GUITesting(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        // this will be executed even if Exception is thrown at runtime
        System.out.println("Stopping app");
    }

    // Separate examples for each concept

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene(){
        return this.scene;
    }

    public void ex12GUITesting(Stage stage) {
        Button button = new Button("Press me");
        button.setOnAction(event -> System.out.println("Click!"));
        VBox vBox = new VBox();
        vBox.getChildren().add(button);
        scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public void ex11FXML(Stage stage) {
        // We can set the element to Parent type
        // ... or whichever type is the root element in the FXML
        Parent root = null;
        try {
            // If the fxml file is located in the same package:
            // root = FXMLLoader.load(getClass().getResource("view.fxml"));

            // For a maven project (view.fxml located in the resources folder):
            root = FXMLLoader.load(getClass().getResource("/view.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ex10EventArgument(Stage stage){
        TextField textField = new TextField();
        // Prints the key code in the console if the key is pressed
        textField.setOnKeyPressed(event -> System.out.print(event.getCode()));
        VBox vBox = new VBox();
        vBox.getChildren().add(textField);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public void ex9ActionEvent(Stage stage){
        Button button = new Button("Press me");
        button.setOnAction(event -> System.out.println("Click!"));
        // button.setOnAction(event -> System.out.println(event));
        VBox vBox = new VBox();
        vBox.getChildren().add(button);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public void ex8ControlPropertyBindingSlider(Stage stage) {
        Slider slider = new Slider();
        VBox root = new VBox();
        root.spacingProperty().bind(slider.valueProperty());
        ObservableList<Node> rootChildren = root.getChildren();
        rootChildren.add(slider);
        rootChildren.add(new Label("V"));

        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);
        stage.show();
    }

    public void ex7ControlPropertyBindingTextFieldAndLabel(Stage stage) {
        TextField textField = new TextField();
        Label label = new Label();
        label.textProperty().bindBidirectional(textField.textProperty());
        // do we need bidirectional binding here?
        VBox vBox = new VBox();
        ObservableList<Node> children = vBox.getChildren();
        children.add(textField);
        children.add(label);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public void ex6PropertiesAndChangeListeners(Stage stage) {
        TextField textField = new TextField("Initial text value");
        textField.getText();
        textField.setText("New value");
        StringProperty textProperty = textField.textProperty();
        textProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("New value is set: " + newValue);
        });
        Scene scene = new Scene(textField);
        stage.setScene(scene);
        stage.show();
    }

    public void ex5ListView(Stage stage) {
        ListView<String> listView = new ListView<>();
        ObservableList<String> items = listView.getItems();
        items.add("Element 1");
        items.add("Element 2");
        items.add("Element 3");
        VBox vBox = new VBox();
        vBox.getChildren().add(listView);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public void ex4TextControls(Stage stage) {
        CheckBox checkbox = new CheckBox("Tick me!");
        System.out.println(checkbox.getText());
        Scene scene = new Scene(checkbox);
        stage.setScene(scene);
        stage.show();
    }

    public void ex3GridPane(Stage stage){
        GridPane root = new GridPane();
        // Adding controls to specified cells. Second argument is column index
        // third one is the row index.
        root.add(new TextField("Element 1, 1"), 0, 0);
        root.add(new Label("Element 1, 2"), 1, 0);
        root.add(new Label("Element 2, 1"), 0, 1);
        root.add(new TextField("Element 2, 2"), 1, 1);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ex2TwoColumnLayout(Stage stage){
        // Preparing first column
        VBox column1 = new VBox();
        ObservableList<Node> column1Children = column1.getChildren();
        column1Children.add(new TextField("Element 1, 1"));
        column1Children.add(new TextField("Element 1, 2"));

        // Preparing second column
        VBox column2 = new VBox();
        ObservableList<Node> column2Children = column2.getChildren();
        column2Children.add(new Label("Element 2, 1"));
        column2Children.add(new Label("Element 2, 2"));

        // Preparing horizontal container of columns
        HBox root = new HBox();
        ObservableList<Node> rootChildren = root.getChildren();
        rootChildren.add(column1);
        rootChildren.add(column2);

        // Space between columns
        root.setSpacing(10);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ex1HelloWorld(Stage stage){
        // Creating the container object
        VBox vBox = new VBox();
        // Creating a label control. Constructor argument represents displayed text.
        Label label = new Label("Hello world!");
        // Setting label to be a child of the vBox container
        vBox.getChildren().add(label);
        // Creating a scene. The vBox is passed as it's root.
        Scene scene = new Scene(vBox);
        // Setting the main window's scene.
        stage.setScene(scene);
        // Showing the window.
        stage.show();
    }
}