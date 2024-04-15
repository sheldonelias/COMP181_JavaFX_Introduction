package views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreen extends Application {

    static String staticString = "";
    static Label myLabel = new Label(); // creates an instruction label for the button

    public static void main(String[] args) {

        System.out.println("Inside StartScreen.main()");

        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        //STEP (1) ADD ROOT NODE OF TYPE GROUP
        Group myRoot = new Group();

        //STEP (2) PASS ROOT NODE AS ARG TO SCENE CONSTRUCTOR
        Scene scene = new Scene(myRoot,  Color.DARKSEAGREEN); //

        //STEP (3) SET WINDOW ATTRIBUTES

        // (3A) TITLE TEXT
        stage.setTitle("COMP 181: Advance Programming: JavaFX Demo: StartScreen");

        //(3B) WINDOW DIMENSIONS
        stage.setWidth(720);
        stage.setHeight(480);

        //(3C) RESIZABILITY DEFAULTS TO TRUE
        stage.setResizable(true);

        //(3D) LOCATION OF FIRST APPEARANCE (ORIGIN 0,0 IS UPPER LEFT CORNER)
        stage.setX(100);// A float between 0 and the screen width works.
        stage.setY(100);

        //--  END STEP(3) WINDOW SET UP ---


        //(4a) CREATES A TEXT NODE (not user-editable)
        //immediately visible
        String topicOfDay = "Scenes in JavaFX"; //creates local string variable
        Text myText = new Text(); //creates text object
        myText.setText(topicOfDay); //feeds string data into text object constructor
        myText.setFont(Font.font("Calibri", 40)); //set font and fontsize early for correct alignment
        myText.setTextAlignment(TextAlignment.CENTER);
        myText.setX(stage.getWidth()/2 - myText.getLayoutBounds().getWidth()/2); //positions X-axis. try stage.getWidth()/2 for dyanmic horizonal centering
        myText.setY(100); //positions Y-axis. try stage.getHeight()/2 for dynamic vertical centering

        //Attaches the text node to root node. Must add node to root node to make it appear
        myRoot.getChildren().add(myText);

        //(4b) CREATES A TEXTFIELD NODE (user editable)
        TextField myTextField = new TextField(); //creates new textfield object with empty constructor
        myTextField.setMaxWidth(100); //constrains horizonal size.
        myTextField.setMaxHeight(20); //constrains vertical size.
        myTextField.setText("hello"); //feeds string data into textfield object
        myTextField.setLayoutX(stage.getWidth()/2 - myTextField.getMaxWidth()/2); //sets X-axis position. try stage.getWidth()/2 for dynamic horizonal centering
        myTextField.setLayoutY(200); //sets Y-axis position. try stage.getWidth()/2 for dynamic vertical centering

        //Attaches a textfieLd node to root node. Must add node to root node to make it appear
        //myRoot.getChildren().add(myTextField); //<< Can add node to root here for each node, or at end all at once.
        //Captures data from user to local variable
        String str = myTextField.getText();
        //Prints local string value to console
        System.out.println(str);
        //Attaches the textfield node to root node. Must add node to root node to make it appear
        myRoot.getChildren().add(myTextField);
        //END STEP (4b) NEW TEXT NODE


        //(4c) CREATES A LABEL AND BUTTON NODES
        //Create button
        Button myButton = new Button("Press"); // creates a button with a button text
        myButton.setPrefWidth(100);
        myButton.setPrefHeight(20);
        myButton.setLayoutX(stage.getWidth()/2 - 40);
        myButton.setLayoutY(10);
        //Attaches the button node to root node. Must add node to root node to make it appear
        myRoot.getChildren().add(myButton);

        //Create label for button

        myLabel.setText("Press Button"); // sets text of label for button
        myLabel.setTextAlignment(TextAlignment.CENTER);
        myLabel.setLayoutX(stage.getWidth()/2 - 20); // positions label on X-axis
        myLabel.setLayoutY(50); // positions label on Y-axis
        //Attaches the label node to root node. Must add node to root node to make it appear
        myRoot.getChildren().add(myLabel);



        //END STEP (4c) CREATE A BUTTON NODE

        //(4d) EVENT HANDLER DECLARED AND SET FOR A BUTTON

        EventHandler<ActionEvent> myEvent = new EventHandler<ActionEvent>()
        {
            //Method within handler used for event parameter.
            public void handle(ActionEvent e)
            {
                System.out.println("Button says hello from StartScreen.");

                //Activates static method
                StartScreenHelper.onHelloButtonClick();
                StartScreen.myLabel.setLayoutX(stage.getWidth()/2 - 70); // positions label on X-axis

                //Assign the value in myTextField to staticString
                staticString = myTextField.getText();

                //Instantiates NewScreen object
                NewScreen ns = new NewScreen();
            }
        };

        //Assign event as argument to activate if button is clicked.
        myButton.setOnAction(myEvent);
        //END STEP (4d) DECLARE AND SET EVENT HANDLER FOR BUTTON


/*
        //STEP (5) CONNECT ALL CHILD NODES TO ROOT NODE
        //Adding nodes to the root can be done at the end of each step to create the node or here all at once
        //Either add nodes as nodes are declared or add at the end of the whole GUI setup. But not both!
        //The nodes were added as nodes were declared.
        myRoot.getChildren().add(myTextField);
        myRoot.getChildren().add(myButton);
        myRoot.getChildren().add(myLabel);
*/


        //NEED THESE STEPS AT THE END TO SHOW THE WINDOW

        //STEP (6) PASS SCENE AS ARG TO SET ARG OF METHOD.
        //Must always be second to last statement of method.
        stage.setScene(scene);

        //STEP (7) DEMONSTRATE STAGE TO THE SCREEN
        //Always last line of window layout.
        stage.show();

    }
}