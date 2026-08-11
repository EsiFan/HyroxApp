package model;

import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;

import persistence.Writable;

// list of hyrox competitions
public class Competitions implements Writable {
    private ArrayList<Hyrox> listofHyrox;

    //EFFECTS: constructs an empty list of Hyroxes
    public Competitions() {
        listofHyrox = new ArrayList<Hyrox>();
    }

    // EFFECTS: adds the given comp to listOfHyrox
    // MODIFIES: this
    public void addComp(Hyrox comp) {
        listofHyrox.add(comp);
        EventLog.getInstance().logEvent(new Event("A Hyrox has been added to Competetitions"));
    }

    public ArrayList<Hyrox> getCompetitions() {
        return listofHyrox;
    }

    // EFFECTS: returns the size of the competition
    public int size() {
        return listofHyrox.size();
    }

    // modeled from example project JsonSerialization
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("listOfHyrox", hyroxsToJson());
        return json;
    }

    // modeled from example project JsonSerialization
    // EFFECTS: returns hyroxs in Competitions as a JSON array
    private JSONArray hyroxsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Hyrox h : listofHyrox) {
            jsonArray.put(h.toJson());
        }

        return jsonArray;
    }
}
