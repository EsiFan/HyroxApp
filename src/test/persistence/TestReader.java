package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// modeled from example project JsonSerialization

@ExcludeFromJacocoGeneratedReport
public class TestReader extends TestJson {

    @Test
    void testReaderNonExistentFileCompetitions() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Competitions comps = reader.readCompetitions();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCompetitions() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCompetitions.json");
        try {
            Competitions comps = reader.readCompetitions();
            assertEquals(0, comps.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralCompetitions() {
        JsonReader reader = new JsonReader("./data/testReaderGeneral.json");
        try {
            Competitions comps = reader.readCompetitions();
            assertEquals(2, comps.size());
            List<Hyrox> hyroxs = comps.getCompetitions();
            checkCompetition("Hyrox Open", 150, "mixed", 90, hyroxs.get(0));
            checkCompetition("US Hyrox", 180, "male", 75, hyroxs.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderNonExistentFileInstantsHistory() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            InstantsHistory ins = reader.readInstantsHistory();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyInstantsHistory() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyInstantsHistory.json");
        try {
            InstantsHistory ins = reader.readInstantsHistory();
            assertEquals(0, ins.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralInstantsHistory() {
        JsonReader reader = new JsonReader("./data/testReaderGeneral.json");
        try {
            InstantsHistory ins = reader.readInstantsHistory();
            assertEquals(2, ins.size());
            List<InstantHyrox> inst = ins.getInstantsHistory();
            checkInstant("July", 1, 2, 3, 4, 5, 6, 7, 8, 18, inst.get(0));
            checkInstant("August", 1, 2, 2, 4, 3, 2, 6, 7, 15, inst.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
