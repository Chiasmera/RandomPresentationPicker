package GUI;

import Model.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateStudentWindow extends Stage {
    //Fields ------------------------------------------------------------
    private ControllerInterface controller;
    private TextField txfName;


    //Constructors ------------------------------------------------------
    public CreateStudentWindow (String title) {
        controller = new Controller();



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
    private void initContent(BorderPane pane){
        Label lblInstructions = new Label("Student name:");

        txfName = new TextField();
        BorderPane.setMargin(txfName, new Insets(15));

        Button btnOkay = new Button("Create");
        btnOkay.setOnAction(event -> okayAction());
        btnOkay.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnOkay, Priority.ALWAYS);

        Button btnCancel = new Button("Cancel");
        btnCancel.setOnAction(event -> cancelAction());
        btnCancel.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btnCancel, Priority.ALWAYS);

        HBox hbxButton = new HBox(btnOkay, btnCancel);
        hbxButton.setSpacing(15);
        hbxButton.setMaxWidth(Double.MAX_VALUE);

        pane.setTop(lblInstructions);
        pane.setCenter(txfName);
        pane.setBottom(hbxButton);



    }

    private void okayAction () {
        if (!txfName.getText().isBlank()) {
            controller.createStudent(txfName.getText());
            this.close();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No text in name field");
            alert.setContentText("you must provide a name for the student");
            alert.showAndWait();
        }

    }

    private void cancelAction () {
        this.close();
    }
}
