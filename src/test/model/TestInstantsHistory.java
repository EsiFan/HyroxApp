package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class TestInstantsHistory {
    private InstantsHistory testInstantsHistory;
    private InstantHyrox instantTest1;
    private InstantHyrox instantTest2;

    @BeforeEach
    void runBefore() {
        testInstantsHistory = new InstantsHistory();
        instantTest1 = new InstantHyrox("July", 10, 5, 6,
                9, 13, 2, 7, 8, 12);
        instantTest2 = new InstantHyrox("June", 8, 4, 6,
                8, 10, 3, 6, 5, 10);
    }

    @Test
    void testInstantsHistoryConstructor() {
        assertTrue(testInstantsHistory.getInstantsHistory().isEmpty());
    }

    @Test
    void testaddInstant() {
        testInstantsHistory.addInstant(instantTest1);
        assertEquals(testInstantsHistory.getInstantsHistory().size(), 1);
    }

    @Test
    void testaddInstantMultiplTimes() {
        testInstantsHistory.addInstant(instantTest1);
        assertEquals(testInstantsHistory.getInstantsHistory().size(), 1);

        testInstantsHistory.addInstant(instantTest2);
        assertEquals(testInstantsHistory.getInstantsHistory().size(), 2);
    }
}