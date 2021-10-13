package model;

import java.util.ArrayList;
import java.util.List;

//Represents a period tracker tracking days to fast,how long the period lasts
// and the mood of the user
public class PeriodTracker {
    private int fast; // The current number of days left to fast
    private int period; // The number of days user has had period for
    private String mood; // The mood of the user


    //EFFECTS: period tracker has
    public PeriodTracker(int daysOfPeriod, int daysOfFast, String getMood) {
        mood = getMood;
        if (period >= 0) {
            period = daysOfPeriod;
        } else {
            period = 0;
        }
        fast = daysOfFast;
    }

    public String getMood() {
        return mood;
    }


    public void addPeriod() {
        if (period >= 0) {
            period++;
            fast++;
        }
    }


    public void endPeriod() {
        if (period > 0) {
            period = 0;
        }
    }


    public int getFast() {
        return fast;
    }

    public int fasting() {
        if (fast >= 1) {
            fast -= 1;
        }
        return fast;
    }

}