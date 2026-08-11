package model;

import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;

import persistence.Writable;

// list of user's previous hyrox attepmts
public class InstantsHistory implements Writable {
    private ArrayList<InstantHyrox> listOfInstants;

    // EFFECTS: constructs an empty list of Instants
    public InstantsHistory() {
        listOfInstants = new ArrayList<InstantHyrox>();
    }

    // EFFECTS: adds the give instant to listOfInstants
    // MODIFIES: this
    public void addInstant(InstantHyrox instant) {
        listOfInstants.add(instant);
        EventLog.getInstance().logEvent(new Event("A practice instance has been added to the history"));
    }

    public ArrayList<InstantHyrox> getInstantsHistory() {
        return listOfInstants;
    }


    // EFFECTS: returns the size of the competition
    public int size() {
        return listOfInstants.size();
    }

    // modeled from example project JsonSerialization
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("listOfInstants", instantsToJson());
        return json;
    }

    // modeled from example project JsonSerialization
    // EFFECTS: returns Instants in this Instantsistory as a JSON array
    private JSONArray instantsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (InstantHyrox i : listOfInstants) {
            jsonArray.put(i.toJson());
        }

        return jsonArray;
    }
}