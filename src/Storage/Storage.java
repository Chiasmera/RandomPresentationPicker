package Storage;

import Model.Student;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    //Fields ------------------------------------------------------------
    private List<Student> studentList;
    private static Storage uniqueInstance;


    //Constructors ------------------------------------------------------

    private Storage() {
        this.studentList = new ArrayList<>();
    }


    //Methods - Get, Set & Add -------------------------------------------

    public static Storage getStorage() {
        if (uniqueInstance == null) {
            uniqueInstance = new Storage();
        }
        return uniqueInstance;
    }

    public List<Student> getStudentList() {
        return new ArrayList<>( studentList);
    }

    public void addStudent (Student student) {
        if (!studentList.contains(student)) {
            studentList.add(student);
        }
    }

    public void removeStudent (Student student) {
        if (studentList.contains(student)) {
            studentList.remove(student);
        }
    }

    //Methods - Other ----------------------------------------------------
}
