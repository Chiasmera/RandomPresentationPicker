package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Test-Frans");
    }

    @Test
    void incrementPresented() {
        //Arrange
        int startCount = student.getTimesPresented();

        //Act
        student.incrementPresented();

        //Assert
        assertEquals(startCount+1, student.getTimesPresented());

    }

    @Test
    void incrementAsked() {
        //Arrange
        int startCount = student.getTimesAsked();

        //Act
        student.incrementAsked();

        //Assert
        assertEquals(startCount+1, student.getTimesAsked());
    }

    @Test
    void calculateReliability() {
        //Arrange
        int askedCount = 5;
        student.incrementAsked();
        student.incrementAsked();
        student.incrementAsked();
        student.incrementAsked();
        student.incrementAsked();

        int presentedCount = 2;
        student.incrementPresented();
        student.incrementPresented();

        double expectedReliability = 100.0 / askedCount * presentedCount;

        //Act
        double reliabilityRating = student.calculateReliability();

        //Assert
        assertEquals(askedCount, student.getTimesAsked());
        assertEquals(presentedCount, student.getTimesPresented());
        assertEquals(expectedReliability, reliabilityRating);


    }
}