package model;

import java.util.ArrayList;
import java.util.List;

public class PeriodTracker {

    protected List<PeriodDay> periodDays;
    protected int fast = 0; // Number of days fasted so far
    protected int period = 0; // Whether the user is on their period or not
    protected int numMonths = 30; // Number of days in a month
    int fastsLeftAfter = 0; // Number of days left to fast

    public PeriodTracker() {
        this.periodDays = new ArrayList<>();
    }


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


    //EFFECTS: returns the number of periods had so far
    public int getPeriod() {
        return period;
    }
}