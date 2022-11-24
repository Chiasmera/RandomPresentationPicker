package Model;

public class Student {
    //Fields ------------------------------------------------------------
    private String name;
    private int timesPresented;
    private int timesAsked;
    private boolean blacklistedThisSession;

    //Constructors ------------------------------------------------------

    public Student(String name) {
        this.name = name;
        this.timesPresented = 0;
        this.timesAsked = 0;
        this.blacklistedThisSession = false;
    }

    public  Student(String name, int timesPresented, int timesAsked) {
        this.name = name;
        this.timesPresented = timesPresented;
        this.timesAsked = timesAsked;
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

    /**
     * Returna a boolean representing the students blacklist status
     * @return Returns true if this student should not present any more this session
     */
    public boolean isBlacklisted() {
        return blacklistedThisSession;
    }

    /**
     * Blacklists a student from presenting any more this session
     */
    public void blacklist () {
        blacklistedThisSession = true;
    }


    //Methods - Other ----------------------------------------------------

    /**
     * Calculate and returns the percentage of presentations out of total times asked
     * @return a double, representing the percentage of times presented
     */
    public double calculateReliability () {
        double returnvalue;
        if (timesAsked < 1) {
            returnvalue = 100.0;
        } else {
            returnvalue = 100.0 / timesAsked * timesPresented;
        }
        return returnvalue;
    }

    @Override
    public String toString() {
        double reliability = calculateReliability();
        String returnString;
        if (reliability > 0.0) {
            returnString = name + " (" + String.format("%.1f", reliability) + "%)";
        } else {
            returnString = name;
        }
        return returnString;
    }
}
