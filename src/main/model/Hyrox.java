package model;

public class Hyrox {
    String title;
    int weightClass;
    String gender;
    int minTimeRec;

    // REQUIRES: title length to be more than 0 characters
    //           weight class to be more than 0
    //           gender length to be more than 0 characters
    //           minimum time record to be more than 0
    // EEFECTS: account title is set to given title; weightClass
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

}
