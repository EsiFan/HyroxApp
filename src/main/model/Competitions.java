package model;

import java.util.ArrayList;

public class Competitions {
    private ArrayList<Hyrox> listOfHyrox;

    // EFFECTS: constructs an empty list of Hyroxes
    public Competitions() {
        listOfHyrox = new ArrayList<Hyrox>();
    }

    // EFFECTS: adds the given hyrox to the listOfHyrox
    // MODIFIES: this
    public void addHyroxs(ArrayList<Hyrox> hyroxs) {

    }

    public ArrayList<Hyrox> getCompetitions() {
        return listOfHyrox;
    }
}
