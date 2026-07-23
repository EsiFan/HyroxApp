package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    // EFFECTS: reads Competitions from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Competitions readCompetitions() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCompetitions(jsonObject);
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

    // MODIFIES: comps
    // EFFECTS: parses listofHyrox from JSON object and adds them to competitions
    private Competitions parseCompetitions (JSONObject jsonObject) {
        String name = jsonObject.getString("listofHyrox");
        Competitions comps = new Competitions();
        addHyroxs(comps, jsonObject);
        return comps;
    }
}
