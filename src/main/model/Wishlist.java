package model;

import java.util.ArrayList;

public class Wishlist {
    private ArrayList<Hyrox> wishList;

    // EFFECTS: constructs an empty list of Hyroxes
    public Wishlist() {
        wishList = new ArrayList<Hyrox>();
    }

    // EFFECTS: adds the given hyrox to the listOfHyrox
    // MODIFIES: this
    public void addHyroxs(ArrayList<Hyrox> hyroxs) {
        wishList.addAll(hyroxs);
    }

    public ArrayList<Hyrox> getWishList() {
        return wishList;
    }
}
