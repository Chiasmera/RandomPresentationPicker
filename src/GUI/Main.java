package GUI;

import Model.Controller;
import Model.Student;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println();

        Controller controller = new Controller();
        Student frans = controller.createStudent("Test-Frans");

        System.out.println("Test Frans er oprettet");
        System.out.println("Han er spurgt "+frans.getTimesAsked()+" gange, og har præsenteret "+frans.getTimesPresented()+" gange");
        System.out.println();
        System.out.println("Frans bliver spurgt 3 gange, men har ikke lavet lektier nogen af gangene");
        frans.incrementAsked();
        frans.incrementAsked();
        frans.incrementAsked();
        System.out.println("Han er spurgt "+frans.getTimesAsked()+" gange, og har præsenteret "+frans.getTimesPresented()+" gange");
        System.out.println("Han har nu en reliability rating på: "+frans.calculateReliability());
        System.out.println();
        System.out.println("Frans bliver spurgt 4 gange mere, og præsenterer alle gange");
        frans.incrementAsked();
        frans.incrementPresented();
        frans.incrementAsked();
        frans.incrementPresented();
        frans.incrementAsked();
        frans.incrementPresented();
        frans.incrementAsked();
        frans.incrementPresented();
        System.out.println("Han er spurgt "+frans.getTimesAsked()+" gange, og har præsenteret "+frans.getTimesPresented()+" gange");
        System.out.println("Han har nu en reliability rating på: "+frans.calculateReliability());
        System.out.println();

    }
}