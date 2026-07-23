package model;

import java.util.Collection;

import org.json.JSONObject;
import persistence.Writable;

// setup and the requirments of a hyrox competition
public class Hyrox implements Writable{
    private String title;
    private int weightClass;
    private String gender;
    private int minTimeRec;

    // REQUIRES: title length to be more than 0 characters
    //           weight class to be more than 0
    //           gender length to be more than 0 characters
    //           minimum time record to be more than 0
    // EEFECTS: hyrox title is set to given title; weightClass
    //          is set to the give weight class; gender is set
    //          to "male", "female", or "mixed"; minTimeRec
    //          is set to the given minimmum time record in minutes
    public Hyrox(String title, int weightClass, String gender, int minTimeRec) {
        this.title = title;
        this.weightClass = weightClass;
        this.gender = gender;
        this.minTimeRec = minTimeRec;
    }

    public String getTitle() {
        return this.title;
    }

    public int getWeightClass() {
        return this.weightClass;
    }

    public String getGender() {
        return this.gender;
    }

    public int getMinTimeRec() {
        return this.minTimeRec;
    }

    // modeled from example project JsonSerialization
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("weightClass", weightClass);
        json.put("gender", gender);
        json.put("minTimeRec", minTimeRec);
        return json;
    }

}
