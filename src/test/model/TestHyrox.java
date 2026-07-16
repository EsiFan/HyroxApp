package model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestHyrox {
    private Hyrox hyroxTest;

    @BeforeEach
    void runBefore() {
        hyroxTest = new Hyrox("Grand Hyrox", 180, "mixed", 90);
    }

    @Test
    void testHyroxConstructor() {
        assertEquals("Grand Hyrox", hyroxTest.getTitle());
        assertEquals(180, hyroxTest.getWeightClass());
        assertEquals("mixed", hyroxTest.getGender());
        assertEquals(90, hyroxTest.getMinTimeRec());
    }
}
