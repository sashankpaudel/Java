package lab5ii;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import static javafx.application.Application.launch;
public class Lab5ii extends Application {
    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("JavaFX UI Controls Example");
        Label label = new Label("Enter your name:");
        final TextField textField = new TextField();
        Button button = new Button("Submit");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String enteredText = textField.getText();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Hello, " + enteredText + "!");
                alert.showAndWait();
            }
        });
        RadioButton radioButton = new RadioButton("Option 1");
        RadioButton radioButton2 = new RadioButton("Option 2");
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        CheckBox checkBox = new CheckBox("Agree to terms");
        Hyperlink hyperlink = new Hyperlink("Visit our website");
        hyperlink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getHostServices().showDocument("https://facebook.com");
            }
        });
        Menu menu = new Menu("File");
        MenuItem openMenuItem = new MenuItem("Open");
        openMenuItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                openFile(primaryStage);
            }
        });
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                System.exit(0);
            }
        });
        menu.getItems().addAll(openMenuItem, exitMenuItem);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        Tooltip tooltip = new Tooltip("Click to submit");
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(label, textField, button, radioButton, radioButton2, checkBox, hyperlink);
        hbox.setSpacing(10);
        Scene scene = new Scene(new HBox(10, label, textField, button, radioButton, radioButton2, checkBox, hyperlink), 1100, 200);
        ((HBox) scene.getRoot()).getChildren().addAll(menuBar);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void openFile(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Selected file: " + file.getAbsolutePath());
            alert.showAndWait();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}