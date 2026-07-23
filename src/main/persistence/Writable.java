package persistence;

import org.json.JSONObject;

// modeled from example project JsonSerializationDemo

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
