package Model;

public class Student {
    //Fields ------------------------------------------------------------
    private String name;
    private int timesPresented;
    private int timesAsked;

    //Constructors ------------------------------------------------------

    public Student(String name) {
        this.name = name;
        this.timesPresented = 0;
        this.timesAsked = 0;
    }


    //Methods - Get, Set & Add -------------------------------------------
    public String getName() {
        return name;
    }

    public int getTimesPresented() {
        return timesPresented;
    }

    public int getTimesAsked() {
        return timesAsked;
    }

    /**
     * Increments the times presented by 1
     */
    public void incrementPresented () {
        timesPresented++;
    }

    /**
     * Increments the times being asked to present by 1
     */
    public void incrementAsked () {
        timesAsked++;
    }


    //Methods - Other ----------------------------------------------------

    /**
     * Calculate and returns the percentage of presentations out of total times asked
     * @return a double, representing the percentage of times presented
     */
    public double calculateReliability () {
        return 100.0 / timesAsked * timesPresented;
    }
}
