package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class TestCompetitions {
    private Competitions testCompetitions;
    private Hyrox hyroxTest1;
    private Hyrox hyroxTest2;
    private ArrayList<Hyrox> hyroxsTests;

    @BeforeEach
    void runBefore() {
        testCompetitions = new Competitions();
        hyroxTest1 = new Hyrox("Grand Hyrox", 180, "mixed", 90);
        hyroxTest2 = new Hyrox("Hyrox Open", 150, "men", 70);
        hyroxsTests = new ArrayList<Hyrox>();
    }

    @Test
    void testCompetitionsConstructor() {
        assertTrue(testCompetitions.getCompetitions().size() == 0);
    }

    @Test
    void testAddHyroxsSingleElementList() {
        hyroxsTests.add(hyroxTest1);
        testCompetitions.addHyroxs(hyroxsTests);
        assertTrue(testCompetitions.getCompetitions().size() == 1);
    }

    @Test
    void testAddHyroxsMultipleElementList() {
        hyroxsTests.add(hyroxTest1);
        hyroxsTests.add(hyroxTest2);
        testCompetitions.addHyroxs(hyroxsTests);
        assertTrue(testCompetitions.getCompetitions().size() == 2);
        assertTrue(testCompetitions.getCompetitions().get(1) == hyroxTest2);
    }
    
}
