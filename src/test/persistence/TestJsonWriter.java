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

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Competitions comp = new Competitions();
            comp.addComp(new Hyrox("Open", 150, "mixed", 120));
            comp.addComp(new Hyrox("US", 180, "male", 90));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneral.json");
            writer.open();
            writer.write(comp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneral.json");
            comp = reader.readCompetitions();
            List<Hyrox> hyroxs = comp.getCompetitions();
            assertEquals(2, hyroxs.size());
            checkCompetition("Open", 150, "mixed", 120, hyroxs.get(0));
            checkCompetition("US", 180, "male", 90, hyroxs.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterEmptyInstantsHistory() {
        try {
            InstantsHistory ins = new InstantsHistory();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCompetitions.json");
            writer.open();
            writer.write(ins);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCompetitions.json");
            ins = reader.readInstantsHistory();
            assertEquals(0, ins.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
