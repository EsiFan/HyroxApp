package model;

import java.util.ArrayList;

// wishlist of the possible future hyroxs the user wants to participate
public class Wishlist {
    private ArrayList<String> wishList;

    // EFFECTS: constructs an empty list of Hyroxes
    public Wishlist() {
        wishList = new ArrayList<String>();
    }

    // EFFECTS: adds the given hyrox to the listOfHyrox
    // MODIFIES: this
    public void addHyroxs(ArrayList<Hyrox> hyroxs) {
        wishList.addHyroxs(hyroxs);
    }

    public ArrayList<Hyrox> getWishlist() {
        return wishList;
    }
}
