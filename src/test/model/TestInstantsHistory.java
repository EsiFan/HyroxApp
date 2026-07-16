package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestInstantsHistory {
    private InstantsHistory testInstantsHistory;

    @BeforeEach
    void runBefore() {
        testInstantsHistory = new InstantsHistory();
    }

    @Test
    void testInstantsHistoryConstructor() {
        assertTrue(testInstantsHistory.getInstantsHistory().isEmpty());
    }
}