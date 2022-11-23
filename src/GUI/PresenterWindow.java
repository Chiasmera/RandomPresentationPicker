package GUI;

import Model.Controller;
import Model.Student;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

public class PresenterWindow extends Stage {
    //Fields ------------------------------------------------------------
    private ControllerInterface controller;
    private Student chosenStudent;

    //Constructors ------------------------------------------------------
    public PresenterWindow(String title, Student chosenStudent) {
        controller = new Controller();
        this.chosenStudent = chosenStudent;


        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);

        this.setTitle(title);
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20));
        Scene scene = new Scene(pane);
        this.setScene(scene);

        this.initContent(pane);
    }

    //Methods - Get, Set & Add -------------------------------------------


    //Methods - Other ----------------------------------------------------
    private void initContent(BorderPane pane) {
        Label lblStudent = new Label(chosenStudent.getName());
        lblStudent.setAlignment(Pos.CENTER);
        lblStudent.setFont(new Font(36));
        BorderPane.setMargin(lblStudent, new Insets(30));
        BorderPane.setAlignment(lblStudent, Pos.CENTER);

        Label lblStaticText = new Label("Its your turn to present!");
        lblStaticText.setFont(new Font(16));
        BorderPane.setMargin(lblStaticText, new Insets(20));


        Button btnAcceptChoice = new Button("Accept Choice");
        btnAcceptChoice.setOnAction(event -> acceptAction());
        btnAcceptChoice.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnAcceptChoice, Priority.ALWAYS);

        Button btnPassAlways = new Button("Pass, and do not choose this person again");
        btnPassAlways.setOnAction(event -> alwaysPassAction());
        btnPassAlways.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnPassAlways, Priority.ALWAYS);

        Button btnPassForNow = new Button("Pass, but keep this person as an option");
        btnPassForNow.setOnAction(event -> tempPassAction());
        btnPassForNow.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnPassForNow, Priority.ALWAYS);

        HBox hbxButtons = new HBox(btnAcceptChoice, btnPassAlways, btnPassForNow);
        hbxButtons.setSpacing(15);
        hbxButtons.setAlignment(Pos.CENTER);
        BorderPane.setMargin(hbxButtons, new Insets(15));

        pane.setTop(lblStudent);
        pane.setCenter(lblStaticText);
        pane.setBottom(hbxButtons);

    }

    private void acceptAction() {
        this.close();


    }

    private void alwaysPassAction() {
        this.close();

    }

    private void tempPassAction() {
        this.close();
    }
}
