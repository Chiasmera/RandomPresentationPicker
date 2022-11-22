package GUI;

import Model.Student;

public interface ControllerInterface {

    void removeStudent(Student student);

    Student createStudent (String name);

    void askStudent (Student student);

    void studentHasPresented (Student student);
}
