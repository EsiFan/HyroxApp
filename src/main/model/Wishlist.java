package model;

import java.util.ArrayList;

import org.json.JSONObject;

import persistence.Writable;

// wishlist of the possible future hyroxs the user wants to participate
public class Wishlist implements Writable{
    private ArrayList<String> wishList;

    // EFFECTS: constructs an empty list of Hyroxes
    public Wishlist() {
        wishList = new ArrayList<String>();
    }

    // EFFECTS: adds the given hyrox to the listOfHyrox
    // MODIFIES: this
    public void addHyroxs(ArrayList<String> hyroxTitles) {
        for (String hyrox : hyroxTitles) {
            wishList.add(hyrox);
        }
    }

    public ArrayList<String> getWishlist() {
        return wishList;
    }

    // EFFECTS: returns the size of the competition
    public int size() {
        return wishList.size();
    }

    // modeled from example project JsonSerialization
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("listOfInstants", wishListToJson());
        return json;
    }
}
