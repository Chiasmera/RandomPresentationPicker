package GUI;

import Model.Controller;
import Model.Student;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PresentationTab extends BorderPane {
    //Fields ------------------------------------------------------------
    private ControllerInterface controller;
    private List<Student> blacklist;
    private List<Student> studentsAskedThisSession;



    //Constructors ------------------------------------------------------
    public PresentationTab() {
        this.setPadding(new Insets(20));
        controller = new Controller();
        blacklist = new ArrayList<>();
        studentsAskedThisSession = new ArrayList<>();

        Button btnRandomPerson = new Button("Get me a random presenter!");
        btnRandomPerson.setFont(new Font(24));
        btnRandomPerson.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(btnRandomPerson, Priority.ALWAYS);
        btnRandomPerson.setOnAction(event -> randomPersonAction() );

        Button btnLeastPresentations = new Button("Get me someone who doesn't present much");
        btnLeastPresentations.setFont(new Font(24));
        btnLeastPresentations.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(btnLeastPresentations, Priority.ALWAYS);
        btnLeastPresentations.setOnAction(event -> leastPresentsAction() );

        Button btnReliablePerson = new Button("Get me a reliable presenter");
        btnReliablePerson.setFont(new Font(24));
        btnReliablePerson.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(btnReliablePerson, Priority.ALWAYS);
        btnReliablePerson.setOnAction(event -> reliablePersonAction() );

        VBox vbxButtons = new VBox(btnRandomPerson,btnLeastPresentations, btnReliablePerson);
        vbxButtons.setSpacing(30);
        vbxButtons.setAlignment(Pos.CENTER);
        this.setCenter(vbxButtons);

    }


    //Methods - Get, Set & Add -------------------------------------------
    public void addToBlacklist (Student student) {
        if (!blacklist.contains(student)) {
            blacklist.add(student);
        }
    }


    //Methods - Other ----------------------------------------------------
    public void updateControls() {

    }

    private void initContent (BorderPane pane) {

    }

    private void randomPersonAction() {
        List<Student> whitelist = controller.getAllStudents();
        for (Student s : whitelist) {
            if (s.getBlacklistStatus()) {
                whitelist.remove(s);
            }
        }
        int randomNum = ThreadLocalRandom.current().nextInt(0, whitelist.size());

        PresenterWindow presenterWindow = new PresenterWindow("Random Person", whitelist.get(randomNum));
        presenterWindow.showAndWait();


    }

    private void leastPresentsAction () {
        PresenterWindow presenterWindow = new PresenterWindow("Least Presentations", controller.getAllStudents().get(0));
        presenterWindow.showAndWait();

    }

    private void reliablePersonAction () {
        PresenterWindow presenterWindow = new PresenterWindow("Realiable", controller.getAllStudents().get(0));
        presenterWindow.showAndWait();

    }



}
