package model;

import java.util.ArrayList;

public class Competitions {
    private ArrayList<Hyrox> listofHyrox;

    //EFFECTS: constructs an empty list of Hyroxes
    public Competitions() {
        listofHyrox = new ArrayList<Hyrox>();
    }

    public ArrayList<Hyrox> getCompetitions() {
        return listofHyrox;
    }
}
