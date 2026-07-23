package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// modeled from example project JsonSerialization

@ExcludeFromJacocoGeneratedReport
public class TestJsonWriter extends TestJson {
    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyCompetitions() {
        try {
            Competitions comp = new Competitions();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCompetitions.json");
            writer.open();
            writer.write(comp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCompetitions.json");
            comp = reader.readCompetitions();
            assertEquals(0, comp.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
