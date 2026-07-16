package model;

import java.util.ArrayList;

// list of hyrox competitions
public class Competitions {
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
}
