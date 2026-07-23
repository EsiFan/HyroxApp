package model;

import java.util.Collection;

import org.json.JSONObject;
import org.json.JSONArray;

import persistence.Writable;

// a practice hyrox run
public class InstantHyrox implements Writable {
    private String title;
    private int timeSkiErg; // all of the times are recorded in minutes
    private int timeSledPush;
    private int timeSledPull;
    private int timeBBJ; // Burpee Board Jump
    private int timeRowing;
    private int timeFC; // Farmers Carry
    private int timeSL; // Sandbag Lunges
    private int timeWallBall;
    private int sumTimeRuns;

    // REQUIRES: time to be more than 0
    // requires all of the times for the 8 phases to be above 0
    // requires sumTimeRuns to be above 0
    // EFFECTS: instant title is set to the given title; timeSkiErg, timeSledPush,
    // timeSledPull, timeBBJ, timeRowing, timeFC, timeSL, timeWallBall,
    // and sumTimeRuns are all set to give time records.
    public InstantHyrox(String title, int timeSE, int timeSPush, int timeSPull, int timeBBJ, int timeR, int timeFC,
            int timeSL, int timeWB, int sumTimeRuns) {
        this.title = title;
        this.timeSkiErg = timeSE;
        this.timeSledPush = timeSPush;
        this.timeSledPull = timeSPull;
        this.timeBBJ = timeBBJ;
        this.timeRowing = timeR;
        this.timeFC = timeFC;
        this.timeSL = timeSL;
        this.timeWallBall = timeWB;
        this.sumTimeRuns = sumTimeRuns;
    }

    // EFFECTS: calculates the total time of the attempt
    public int totalTime() {
        return timeSkiErg + timeSledPush + timeSledPull + timeBBJ
                + timeRowing + timeFC + timeSL + timeWallBall + sumTimeRuns;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTimeSkiErg() {
        return this.timeSkiErg;
    }

    public int getTimeSledPush() {
        return this.timeSledPush;
    }

    public int getTimeSledPull() {
        return this.timeSledPull;
    }

    public int getTimeBurpeeBoardJump() {
        return this.timeBBJ;
    }

    public int getTimeRowing() {
        return this.timeRowing;
    }

    public int getTimeFarmersCarry() {
        return this.timeFC;
    }

    public int getTimeSandbagLounges() {
        return this.timeSL;
    }

    public int getTimeWallBall() {
        return this.timeWallBall;
    }

    public int getSumTimeRuns() {
        return this.sumTimeRuns;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("timeSkiErg", timeSkiErg);
        json.put("timeSledPush", timeSledPush);
        json.put("timeSledPull", timeSledPull);
        json.put("timeBBJ", timeBBJ);
        json.put("timeRowing", timeRowing);
        json.put("timeFC", timeFC);
        json.put("timeSL", timeSL);
        json.put("timeWallBall", timeWallBall);
        json.put("sumTimeRuns", sumTimeRuns);

        return json;
    }
}
