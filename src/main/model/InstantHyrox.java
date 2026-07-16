package model;

public class InstantHyrox {
    
    private String title;
    private int timeSkiErg, timeSledPush, timeSledPull,    // all of the times are recorded in minutes
    timeBBJ,     //Burpee Board Jump
    timeRowing, 
    timeFC,      //Farmers Carry
    timeSL,      //Sandbag Lunges
    timeWallBall, sumTimeRuns;

    // REQUIRES: time to be more than 0
    //           requires all of the times for the 8 phases to be above 0
    //           requires sumTimeRuns to be above 0
    // EFFECTS: instant title is set to the given title; timeSkiErg, timeSledPush, 
    //          timeSledPull, timeBBJ, timeRowing, timeFC, timeSL, timeWallBall, 
    //          and sumTimeRuns are all set to give time records.
    public InstantHyrox (String title, int timeSE, int timeSPush, int timeSPull, int timeBBJ, int timeR, int timeFC, 
    int timeSL, int timeWB, int sumTimeRuns) {

    }
}
