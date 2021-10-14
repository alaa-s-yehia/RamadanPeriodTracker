package model;

import java.util.ArrayList;
import java.util.List;

//Represents a list of period days
public class PeriodTracker {

    protected List<PeriodDay> periodDays;
    protected int fast = 0; // Number of days fasted so far
    protected int period = 0; // Number of days user has been on their period
    protected int numMonths = 30; // Number of days in a month
    int fastsLeftAfter = 0; // Number of days left to fast

    //REQUIRES: Period Day
    //EFFECTS: creates a list of the inputs of a period day .
    // tracking user's input
    public PeriodTracker() {
        this.periodDays = new ArrayList<>();
    }

    //EFFECTS: If user is on their period , one is added to the number
    // of days they're on their period and one is added to the number of
    // days needed to fast
    public void addPeriodDay(PeriodDay day) {

        if (day.getPeriod()) {
            period++;
            fastsLeftAfter++;
        }

        if (day.getFast()) {
            fast++;
        }

        periodDays.add(day);
    }


    //EFFECTS: returns the number of days fasted so far
    public int getFast() {
        return fast;
    }

    //EFFECTS: returns the number of days left to fast
    public int getDaysLeftToFast() {
        return fastsLeftAfter;
    }


    //EFFECTS: returns the number of days user has had period for
    public int getPeriod() {
        return period;
    }
}