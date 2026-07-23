package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// modeled from example project JsonSerialization

public class TestReader {

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
}
