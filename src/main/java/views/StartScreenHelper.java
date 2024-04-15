package views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StartScreenHelper {
    @FXML
    static Label welcomeText = new Label();

    @FXML
    static protected void onHelloButtonClick()
    {
        System.out.println("Button says hello from StartScreenHelper.");

        StartScreen.myLabel.setText("Welcome to JavaFX Application!");

    }
}