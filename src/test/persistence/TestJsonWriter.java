package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.ArrayList;
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
    void testWriterGeneralCompetitions() {
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
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyInstantsHistory.json");
            writer.open();
            writer.write(ins);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyInstantsHistory.json");
            ins = reader.readInstantsHistory();
            assertEquals(0, ins.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralInstantsHistory() {
        try {
            InstantsHistory ins = new InstantsHistory();
            ins.addInstant(new InstantHyrox("July", 1, 2, 3, 4, 5, 6, 7, 8, 18));
            ins.addInstant(new InstantHyrox("June", 1, 2, 2, 4, 5, 3, 7, 6, 15));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneral.json");
            writer.open();
            writer.write(ins);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneral.json");
            ins = reader.readInstantsHistory();
            List<InstantHyrox> insts = ins.getInstantsHistory();
            assertEquals(2, insts.size());
            checkInstant("July", 1, 2, 3, 4, 5, 6, 7, 8, 18, insts.get(0));
            checkInstant("June", 1, 2, 2, 4, 5, 3, 7, 6, 15, insts.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterEmptyWishlist() {
        try {
            Wishlist wl = new Wishlist();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyInstantsHistory.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyInstantsHistory.json");
            wl = reader.readWishlist();
            assertEquals(0, wl.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWishlist() {
        try {
            Wishlist wl = new Wishlist();
            ArrayList<String> hyroxTitles = new ArrayList<>();
            hyroxTitles.add("Open");
            hyroxTitles.add("US");
            wl.addHyroxs(hyroxTitles);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneral.json");
            writer.open();
            writer.write(wl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneral.json");
            wl = reader.readWishlist();
            List<String> wishList = wl.getWishlist();
            assertEquals(2, wishList.size());
            assertEquals("Open", wishList.get(0));
            assertEquals("US", wishList.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
