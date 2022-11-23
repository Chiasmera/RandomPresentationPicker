package GUI;

import Model.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class PresentationTab extends BorderPane {
    //Fields ------------------------------------------------------------
    private ControllerInterface controller;


    //Constructors ------------------------------------------------------
    public PresentationTab() {
        this.setPadding(new Insets(20));
        controller = new Controller();

        Button btnLeastAsked = new Button("Get me a person i rarely ask");
        Button btnPriorityReliable = new Button("Get me a reliable person");
        Button btnLeastPresented = new Button("Get me a person who rarely presents something");
        //TODO


    }


    //Methods - Get, Set & Add -------------------------------------------


    //Methods - Other ----------------------------------------------------
    public void updateControls() {

    }
}
