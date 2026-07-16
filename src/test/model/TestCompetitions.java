package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCompetitions {
    private Competitions testCompetitions;

    @BeforeEach
    void runBefore() {
        testCompetitions = new Competitions();
    }

    @Test
    void testCompetitionsConstructor() {
        assertTrue(testCompetitions.getCompetitions().size() == 0);
    }
    
}
