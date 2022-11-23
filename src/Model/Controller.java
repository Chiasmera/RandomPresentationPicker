package Model;

import GUI.ControllerInterface;
import Storage.Storage;

import java.util.List;

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

    public List<Student> getAllStudents () {
        return storage.getStudentList();
    }

    public void initContent() {
        Student s1 = createStudent("Sebastian Behnke");
        Student s2 =createStudent("Kristoffer Bredgaard Frank");
        Student s3 =createStudent("Behzad Haidari");
        Student s4 =createStudent("Peter Bundgaard Immersen");
        Student s5 = createStudent("Rasmus Ingerslev");
        Student s6 =createStudent("Dines Søgaard Jørgensen");
        Student s7 =createStudent("Oskar Sommer Kanstrup");
        Student s8 =createStudent("Sidsel Ava Kirk");
        Student s9 = createStudent("Rasmus Kvejborg");
        Student s10 =createStudent("Abdulahi Isse Ibrahim Mahamed");
        Student s11=createStudent("Magnus Kjøller Mejlgaard");
        Student s12 =createStudent("Daniel Møller");
        Student s13 = createStudent("Sebastian Haug Nielsen");
        Student s14 =createStudent("Lucas Patrick O'Brien");
        Student s15 =createStudent("Jeppe Pedersen");
        Student s16 =createStudent("Rikke Lemvig Pedersen");
        Student s17 =createStudent("Julius Larsen Seerup");
        Student s18 =createStudent("Anujan Selvarajah");
        Student s19 =createStudent("Johan Jørgen Stener");
        Student s20 = createStudent("Tobias Mads Svendsen");
        Student s21 =createStudent("Dan Søndergaard");
        Student s22 =createStudent("Alex Dahl Eiriksson Yildirim");



    }
}
