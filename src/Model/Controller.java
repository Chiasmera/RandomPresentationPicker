package Model;

import GUI.ControllerInterface;
import Storage.Storage;

public class Controller implements ControllerInterface {
    //Fields ------------------------------------------------------------
    private Storage storage;


    //Constructors ------------------------------------------------------

    public Controller() {
        storage = Storage.getStorage();
    }

    //Methods - Get, Set & Add -------------------------------------------


    //Methods - Other ----------------------------------------------------
    @Override
    public void removeStudent(Student student) {
        storage.removeStudent(student);
    }

    @Override
    public Student createStudent(String name) {
        Student createdStudent = new Student(name);
        storage.addStudent(createdStudent);
        return createdStudent;
    }

    @Override
    public void askStudent(Student student) {
        student.incrementAsked();
    }

    @Override
    public void studentHasPresented(Student student) {
        student.incrementPresented();
    }
}
