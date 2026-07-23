package persistence;
import model.*;
import org.json.JSONObject;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.*;

// modeled from example project JsonSerialization

@ExcludeFromJacocoGeneratedReport
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of Competitions to file
    public void write(Competitions comp) {
        JSONObject json = comp.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of InstantsHistory to file
    public void write(InstantsHistory ins) {
        JSONObject json = ins.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of Wishlist to file
    public void write(Wishlist wl) {
        
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }

}
