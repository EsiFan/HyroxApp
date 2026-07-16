package model;

import java.util.ArrayList;

public class InstantsHistory {
    private ArrayList<Hyrox> listOfInstants;

    // EFFECTS: constructs an empty list of Instants
    public InstantsHistory() {
        listOfInstants = new ArrayList<Hyrox>();
    }

    public ArrayList<Hyrox> getInstantsHistory() {
        return listOfInstants;
    }
}