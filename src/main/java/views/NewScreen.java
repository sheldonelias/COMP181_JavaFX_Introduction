package views;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class NewScreen
{
    NewScreen()
    {
        drawScreen();
    }

    NewScreen(Scene scene)
    {
        drawScreen(scene);
    }

    void drawScreen(Scene scene)
    {
        scene.setFill(Color.BLUE);
    }

    void drawScreen()
    {
        Stage stage = new Stage();

        //STEP (1) ADD ROOT NODE OF TYPE GROUP
        Group myRoot = new Group();

        //STEP (2) PASS ROOT NODE AS ARG TO SCENE CONSTRUCTOR
        Scene scene = new Scene(myRoot,  Color.DARKCYAN); //

        //STEP (3) SET WINDOW ATTRIBUTES

        // (3A) TITLE TEXT
        stage.setTitle("COMP 181: Advance Programming: JavaFX Demo: NewScreen");

        //(3B) WINDOW DIMENSIONS
        stage.setWidth(480);
        stage.setHeight(720);

        //(3C) RESIZABILITY DEFAULTS TO TRUE
        stage.setResizable(true);

        //(3D) LOCATION OF FIRST APPEARANCE (ORIGIN 0,0 IS UPPER LEFT CORNER)
        stage.setX(821);// A float between 0 and the screen width works.
        stage.setY(100);

        //--  END STEP(3) WINDOW SET UP ---


        //(4a) CREATES A TEXT NODE (not user-editable)
        //immediately visible
        String topicOfDay = StartScreen.staticString; //creates local string variable
        Text myText = new Text(); //creates text object
        myText.setText(topicOfDay); //feeds string data into text object constructor
        myText.setFont(Font.font("Calibri", 40)); //set font and fontsize early for correct alignment
        myText.setTextAlignment(TextAlignment.CENTER);
        myText.setX(stage.getWidth()/2 - myText.getLayoutBounds().getWidth()/2); //positions X-axis. try stage.getWidth()/2 for dyanmic horizonal centering
        myText.setY(100); //positions Y-axis. try stage.getHeight()/2 for dynamic vertical centering

        //Attaches the text node to root node. Must add node to root node to make it appear
        myRoot.getChildren().add(myText);

        //STEP (6) PASS SCENE AS ARG TO SET ARG OF METHOD.
        //Must always be second to last statement of method.
        stage.setScene(scene);

        //STEP (7) DEMONSTRATE STAGE TO THE SCREEN
        //Always last line of window layout.
        stage.show();
    }
}
