package GUI;

import Model.Controller;
import Model.Student;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class StudentsTab extends BorderPane {
    //Fields ------------------------------------------------------------
private Controller controller;
    private ListView<Student> lwStudents;
    private Button btnNewStudent;
    private Button btnRemoveStudent;

    //Constructors ------------------------------------------------------
    public StudentsTab() {
        controller = new Controller();

        this.setPadding(new Insets(20));

        lwStudents = new ListView<>();
        this.setLeft(lwStudents);

        btnNewStudent = new Button("New Student");
        btnNewStudent.setMaxWidth(Double.MAX_VALUE);
        btnNewStudent.setOnAction(event -> newStudentAction());

        btnRemoveStudent = new Button("Remove Student");
        btnRemoveStudent.setMaxWidth(Double.MAX_VALUE);
        btnRemoveStudent.setOnAction(event -> removeStudentAction());

        VBox vbxButtons = new VBox(btnNewStudent, btnRemoveStudent);
        vbxButtons.setSpacing(15);
        this.setRight(vbxButtons);

    }



    //Methods - Get, Set & Add -------------------------------------------


    //Methods - Other ----------------------------------------------------
    public void updateControls () {
        Student selected = lwStudents.getSelectionModel().getSelectedItem();
        lwStudents.getItems().setAll(controller.getAllStudents());
        if (selected != null) {
            lwStudents.getSelectionModel().select(selected);
        }

        if (lwStudents.getSelectionModel().getSelectedItem() == null) {
            btnRemoveStudent.setDisable(true);
        } else {
            btnRemoveStudent.setDisable(false);
        }

    }

    public void newStudentAction () {
        //TODO
    }

    public void removeStudentAction () {
        if (lwStudents.getSelectionModel().getSelectedItem() != null) {
            controller.removeStudent(lwStudents.getSelectionModel().getSelectedItem());
        }
    }
}
