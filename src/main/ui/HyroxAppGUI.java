package ui;

import model.Competitions;
import model.Hyrox;
import model.InstantHyrox;
import model.InstantsHistory;
import model.Wishlist;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// Hyrox app w Graphical User Interface
@ExcludeFromJacocoGeneratedReport
public class HyroxAppGUI {
    private static final String JSON_STORE = "./data/hyroxApp.json";
    private Scanner input;
    private Competitions competitions;
    private InstantsHistory instantsHistory;
    private Wishlist wishlist;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private ArrayList<String> wl;

    // EFFECTS: tuns the hyrox application
    public HyroxAppGUI() {
            
    }
}
