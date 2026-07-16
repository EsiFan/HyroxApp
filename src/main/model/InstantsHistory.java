package model;

import java.util.ArrayList;

public class InstantsHistory {
    private ArrayList<Hyrox> listOfInstants;

    // EFFECTS: constructs an empty list of Instants
    public InstantsHistory() {
        listOfInstants = new ArrayList<Hyrox>();
    }

    // EFFECTS: adds the give instant to listOfInstants
    // MODIFIES: this
    public void addInstant(InstantHyrox instant) {

    }

    public ArrayList<Hyrox> getInstantsHistory() {
        return listOfInstants;
    }
}