package persistence;

import model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// modeled from example project JsonSerialization

//specific tests for competitions and instants
@ExcludeFromJacocoGeneratedReport
public class TestJson {
    protected void checkCompetition(String title, int weightClass, String gender, int minTimeRec, Hyrox hyrox) {
        assertEquals(title, hyrox.getTitle());
        assertEquals(weightClass, hyrox.getWeightClass());
        assertEquals(gender, hyrox.getGender());
        assertEquals(minTimeRec, hyrox.getMinTimeRec());
    }

    protected void checkInstant(String title, int timeSkiErg, int timeSledPush, int timeSledPull, int timeBBJ,
            int timeRowing, int timeFC, int timeSL, int timeWallBall, int sumTimeRuns, InstantHyrox ins) {
        assertEquals(title, ins.getTitle());
        assertEquals(timeSkiErg, ins.getTimeSkiErg());
        assertEquals(timeSledPush, ins.getTimeSledPush());
        assertEquals(timeSledPull, ins.getTimeSledPull());
        assertEquals(timeBBJ, ins.getTimeBurpeeBoardJump());
        assertEquals(timeRowing, ins.getTimeRowing());
        assertEquals(timeFC, ins.getTimeFarmersCarry());
        assertEquals(timeSL, ins.getTimeSandbagLounges());
        assertEquals(timeWallBall, ins.getTimeWallBall());
        assertEquals(sumTimeRuns, ins.getSumTimeRuns());
    }
}
