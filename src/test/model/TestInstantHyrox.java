package model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class TestInstantHyrox {
    private InstantHyrox instantTest;
    
    @BeforeEach
    void runBefore() {
        instantTest =  new InstantHyrox("July", 10, 5, 6,
         9, 13, 2, 7, 8, 12);
    }

    @Test
    void testInstantHyroxConstructor() {
        assertEquals("July", instantTest.getTitle());
        assertEquals(10, instantTest.getTimeSkiErg());
        assertEquals(5,  instantTest.getTimeSledPush());
        assertEquals(6,  instantTest.getTimeSledPull());
        assertEquals(9,  instantTest.getTimeBurpeeBoardJump());
        assertEquals(13, instantTest.getTimeRowing());
        assertEquals(2,  instantTest.getTimeFarmersCarry());
        assertEquals(7,  instantTest.getTimeSandbagLounges());
        assertEquals(8,  instantTest.getTimeWallBall());
        assertEquals(12, instantTest.getSumTimeRuns());
    }

    @Test
    void testTotalTime() {
        assertEquals(72, instantTest.totalTime());
    }
}
