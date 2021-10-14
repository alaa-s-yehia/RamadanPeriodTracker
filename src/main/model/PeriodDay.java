package model;


//Represents a period tracker tracking days to fast,how long the period lasts
// and the mood of the user
public class PeriodDay {
    protected boolean fast; // Whether the  user fasted or not
    protected boolean period; // Whether the user is on their period or not
    protected String mood; // The mood of the user

    //REQUIRES: days of period, days of
    //EFFECTS: period tracker has


    public PeriodDay(boolean period, boolean fasting, String mood) {
        this.fast = fasting;
        this.period = period;
        this.mood = mood;
    }

    public boolean getFast() {
        return fast;
    }

    public boolean getPeriod() {
        return period;
    }

    public String getMood() {
        return mood;
    }


    public void setFast(boolean fast) {
        this.fast = fast;
    }

    public void setPeriod(boolean period) {
        this.period = period;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }


}