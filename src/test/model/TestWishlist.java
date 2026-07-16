package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class TestWishlist {
    private Wishlist testWishlist;
    private Hyrox hyroxTest1;
    private Hyrox hyroxTest2;
    private ArrayList<Hyrox> hyroxsTests;

    @BeforeEach
    void runBefore() {
        testWishlist = new Wishlist();
        hyroxTest1 = new Hyrox("Grand Hyrox", 180, "mixed", 90);
        hyroxTest2 = new Hyrox("Hyrox Open", 150, "men", 70);
        hyroxsTests = new ArrayList<Hyrox>();
    }

    @Test
    void testCompetitionsConstructor() {
        assertTrue(testWishlist.getWishlist().isEmpty());
    }

    @Test
    void testAddHyroxsSingleElementList() {
        hyroxsTests.add(hyroxTest1);
        testWishlist.addHyroxs(hyroxsTests);
        assertEquals(testWishlist.getWishlist().size(), 1);
    }

    @Test
    void testAddHyroxsMultipleElementList() {
        hyroxsTests.add(hyroxTest1);
        hyroxsTests.add(hyroxTest2);
        testWishlist.addHyroxs(hyroxsTests);
        assertEquals(testWishlist.getWishlist().size(), 2);
    }

    @Test
    void testAddHyroxsMultipleLists() {
        hyroxsTests.add(hyroxTest1);
        testWishlist.addHyroxs(hyroxsTests);
        assertEquals(testWishlist.getWishlist().size(), 1);
        hyroxsTests.clear();
        hyroxsTests.add(hyroxTest1);
        hyroxsTests.add(hyroxTest2);
        testWishlist.addHyroxs(hyroxsTests);
        assertEquals(testWishlist.getWishlist().size(), 3);
    }
    
}
