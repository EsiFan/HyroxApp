package model;

import java.util.ArrayList;

public class Wishlist {
    private ArrayList<Hyrox> listOfHyrox;

    // EFFECTS: constructs an empty list of Hyroxes
    public Wishlist() {
        listOfHyrox = new ArrayList<Hyrox>();
    }

    // EFFECTS: adds the given hyrox to the listOfHyrox
    // MODIFIES: this
    public void addHyroxs(ArrayList<Hyrox> hyroxs) {
        listOfHyrox.addAll(hyroxs);
    }

    public ArrayList<Hyrox> getCompetitions() {
        return listOfHyrox;
    }
}
