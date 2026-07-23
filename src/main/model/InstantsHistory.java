package model;

import java.util.ArrayList;

// list of user's previous hyrox attepmts
public class InstantsHistory {
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
}