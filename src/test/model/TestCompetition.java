package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;


@ExcludeFromJacocoGeneratedReport
public class TestCompetition {
    private Competitions testCompetitions;
    private Hyrox compTest1;
    private Hyrox compTest2;

    @BeforeEach
    void runBefore() {
        testCompetitions = new Competitions();
        compTest1 = new Hyrox("Grand Hyrox", 180, "mixed", 90);
        compTest2 = new Hyrox("Hyrox Open", 150, "men", 70);    
    }

    @Test
    void testCompetitionsConstructor() {
        assertTrue(testCompetitions.getCompetitions().isEmpty());
    }

    @Test
    void testaddComp() {
        testCompetitions.addComp(compTest1);
        assertEquals(testCompetitions.size(), 1);
    }

    @Test
    void testaddCompMultiplTimes() {
        testCompetitions.addComp(compTest1);
        assertEquals(testCompetitions.size(), 1);

        testCompetitions.addComp(compTest2);
        assertEquals(testCompetitions.size(), 2);
    } 
}
