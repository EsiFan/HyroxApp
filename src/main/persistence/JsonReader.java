package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.json.*;

// modeled from example project JsonSerialization

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // from example project JsonSerialization
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: reads Competitions from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Competitions readCompetitions() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCompetitions(jsonObject);
    }

    // MODIFIES: comps
    // EFFECTS: parses listofHyrox from JSON object and adds them to competitions
    // returns Competitions
    private Competitions parseCompetitions(JSONObject jsonObject) {
        JSONArray listofHyrox = jsonObject.getJSONArray("listofHyrox");
        Competitions comps = new Competitions();
        for (Object json : listofHyrox) {
            JSONObject nextHyrox = (JSONObject) json;
            addHyrox(comps, nextHyrox);
        }
        return comps;
    }

    // MODIFIES: comps
    // EFFECTS: parses hyroxs from JSON object and adds them to competitions
    private void addHyrox(Competitions comps, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        int weightClass = jsonObject.getInt("weightClass");
        String gender = jsonObject.getString("gender");
        int minTimeRec = jsonObject.getInt("minTimeRec");
        Hyrox hyrox = new Hyrox(title, weightClass, gender, minTimeRec);
        comps.addComp(hyrox);
    }

    // EFFECTS: reads InstantsHistory from file and returns it;
    // throws IOException if an error occurs reading data from file
    public InstantsHistory readInstantsHistory() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseInstantsHistory(jsonObject);
    }

    // MODIFIES: ins
    // EFFECTS: parses listofInstants from JSON object and adds them to
    // InstantsHistory
    // returns Competitions
    private InstantsHistory parseInstantsHistory(JSONObject jsonObject) {
        JSONArray listofHyrox = jsonObject.getJSONArray("listOfInstants");
        InstantsHistory ins = new InstantsHistory();
        for (Object json : listofHyrox) {
            JSONObject nextInstant = (JSONObject) json;
            addInstant(ins, nextInstant);
        }
        return ins;
    }

    // MODIFIES: comps
    // EFFECTS: parses hyroxs from JSON object and adds them to competitions
    private void addInstant(InstantsHistory ins, JSONObject jsonObject) {
        
    }
}
