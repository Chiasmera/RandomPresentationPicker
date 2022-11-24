package GUI;

import Model.Controller;
import Model.Student;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PresentationTab extends BorderPane {
    //Fields ------------------------------------------------------------
    private ControllerInterface controller;
    private List<Student> currentCandidates;
    private ListView<Student> lwCandidates;


    //Constructors ------------------------------------------------------
    public PresentationTab() {
        this.setPadding(new Insets(20));
        controller = new Controller();
        currentCandidates = controller.getAllStudents();

        Label lblCandidates = new Label("Candidates for presentation:");

        lwCandidates = new ListView<>();
        lwCandidates.getItems().setAll(currentCandidates);
        VBox.setVgrow(lwCandidates, Priority.ALWAYS);

        Button btnRandomPerson = new Button("Get me a random presenter!");
        btnRandomPerson.setFont(new Font(24));
        btnRandomPerson.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(btnRandomPerson, Priority.ALWAYS);
        btnRandomPerson.setOnAction(event -> randomPersonAction());

        Button btnLeastPresentations = new Button("Get me someone who doesn't present much");
        btnLeastPresentations.setFont(new Font(24));
        btnLeastPresentations.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(btnLeastPresentations, Priority.ALWAYS);
        btnLeastPresentations.setOnAction(event -> leastPresentsAction());

        Button btnReliablePerson = new Button("Get me a reliable presenter");
        btnReliablePerson.setFont(new Font(24));
        btnReliablePerson.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(btnReliablePerson, Priority.ALWAYS);
        btnReliablePerson.setOnAction(event -> reliablePersonAction());

        VBox vbxButtons = new VBox(btnRandomPerson, btnLeastPresentations, btnReliablePerson);
        vbxButtons.setSpacing(30);
        vbxButtons.setAlignment(Pos.CENTER);
        this.setCenter(vbxButtons);

        VBox vbxCandidates = new VBox(lblCandidates, lwCandidates);
        this.setLeft(vbxCandidates);

    }


    //Methods - Get, Set & Add -------------------------------------------


    //Methods - Other ----------------------------------------------------
    public void updateControls() {
        if (currentCandidates.size() < 1) {
            for (Student s : controller.getAllStudents()) {
                if (!s.isBlacklisted()) {
                    currentCandidates.add(s);
                }
            }
        }
        lwCandidates.getItems().setAll(currentCandidates);

    }


    private void randomPersonAction() {
        for (Student s : currentCandidates) {
            if (s.isBlacklisted()) {
                currentCandidates.remove(s);
            }
        }
        int randomNum = ThreadLocalRandom.current().nextInt(0, currentCandidates.size());

        PresenterWindow presenterWindow = new PresenterWindow("Random Person", currentCandidates.get(randomNum));
        presenterWindow.showAndWait();

        if (!presenterWindow.getKeepAsOption()) {
            currentCandidates.remove(currentCandidates.get(randomNum));
        }
        updateControls();


    }

    private void leastPresentsAction() {
        ArrayList<Student> leastPresentations = new ArrayList<>();
        //Find all with the number of least presentations
        int leastTimesPresented = currentCandidates.get(0).getTimesPresented();
        for (Student s : currentCandidates) {
            if (s.getTimesPresented() < leastTimesPresented) {
                leastTimesPresented = s.getTimesPresented();
            }
        }
        for (Student s : currentCandidates) {
            if (s.getTimesPresented() == leastTimesPresented) {
                leastPresentations.add(s);
            }
        }

        //If there is more than one with the least number, find the one with the least asks
        if (leastPresentations.size() > 1) {
            int leastTimesAsked = leastPresentations.get(0).getTimesAsked();
            for (Student s : leastPresentations) {
                if (s.getTimesAsked() < leastTimesAsked) {
                    leastTimesAsked = s.getTimesAsked();
                }
            }
            for (Student s : leastPresentations) {
                if (s.getTimesAsked() > leastTimesAsked) {
                    leastPresentations.remove(s);
                }
            }
        }

        //Get a random person from those left
        int randomNum = ThreadLocalRandom.current().nextInt(0, leastPresentations.size());

        PresenterWindow presenterWindow = new PresenterWindow("Random Person", leastPresentations.get(randomNum));
        presenterWindow.showAndWait();

        if (!presenterWindow.getKeepAsOption()) {
            currentCandidates.remove(currentCandidates.get(randomNum));
        }
        updateControls();

    }

    private void reliablePersonAction() {
        ArrayList<Student> mostReliableList = new ArrayList<>();
        //Find all with the highest percentage reliability
        double highestReliability = currentCandidates.get(0).calculateReliability();
        for (Student s : currentCandidates) {
            double currentReliability = s.calculateReliability();
            if (currentReliability > highestReliability) {
                highestReliability = currentReliability;
            }
        }
        for (Student s : currentCandidates) {
            double currentReliability = s.calculateReliability();
            if (currentReliability == highestReliability) {
                mostReliableList.add(s);
            }
        }

        //If there is more than one with the least number, find the one with the least asks
        if (mostReliableList.size() > 1) {
            int leastTimesAsked = mostReliableList.get(0).getTimesAsked();
            for (Student s : mostReliableList) {
                if (s.getTimesAsked() < leastTimesAsked) {
                    leastTimesAsked = s.getTimesAsked();
                }
            }
            for (Student s : mostReliableList) {
                if (s.getTimesAsked() > leastTimesAsked) {
                    mostReliableList.remove(s);
                }
            }
        }

        //Get a random person from those left
        int randomNum = ThreadLocalRandom.current().nextInt(0, mostReliableList.size());


        PresenterWindow presenterWindow = new PresenterWindow("Random Person", mostReliableList.get(randomNum));
        presenterWindow.showAndWait();

        if (!presenterWindow.getKeepAsOption()) {
            currentCandidates.remove(currentCandidates.get(randomNum));
        }
        updateControls();

    }


}
