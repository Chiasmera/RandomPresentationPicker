package GUI;

import Model.Student;

import java.util.List;

public interface ControllerInterface {

    void removeStudent(Student student);

    Student createStudent (String name);

    void askStudent (Student student);

    void studentHasPresented (Student student);

    List<Student> getAllStudents ();

    public void initContent();
}
