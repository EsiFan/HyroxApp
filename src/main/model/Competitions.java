package model;

import java.util.ArrayList;

import org.json.JSONObject;

import persistence.Writable;

// list of hyrox competitions
public class Competitions implements Writable{
    private ArrayList<Hyrox> listofHyrox;

    //EFFECTS: constructs an empty list of Hyroxes
    public Competitions() {
        listofHyrox = new ArrayList<Hyrox>();
    }

    // EFFECTS: adds the given comp to listOfHyrox
    // MODIFIES: this
    public void addComp(Hyrox comp) {
        listofHyrox.add(comp);
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
        json.put("thingies", hyroxsToJson());
        return json;
    }
}
