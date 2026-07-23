package model;

import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;

import persistence.Writable;

// list of user's previous hyrox attepmts
public class InstantsHistory implements Writable{
    private ArrayList<InstantHyrox> listOfInstants;

    // EFFECTS: constructs an empty list of Instants
    public InstantsHistory() {
        listOfInstants = new ArrayList<InstantHyrox>();
    }

    // EFFECTS: adds the give instant to listOfInstants
    // MODIFIES: this
    public void addInstant(InstantHyrox instant) {
        listOfInstants.add(instant);
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
        return null;
    }

    // modeled from example project JsonSerialization
    // EFFECTS: returns Instants in this Instantsistory as a JSON array
    private JSONArray instantsToJson() {
        return null;
    }
}