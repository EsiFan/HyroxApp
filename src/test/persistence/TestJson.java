package persistence;

import model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;


// modeled from example project JsonSerialization

@ExcludeFromJacocoGeneratedReport
public class TestJson {
    protected void checkCompetition(String title, int weightClass, String gender, int minTimeRec, Hyrox hyrox) {
        assertEquals(title, hyrox.getTitle());
        assertEquals(weightClass, hyrox.getWeightClass());
        assertEquals(gender, hyrox.getGender());
        assertEquals(minTimeRec, hyrox.getMinTimeRec());
    }
}

