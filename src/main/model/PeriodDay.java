package model;


import org.json.JSONObject;
import persistence.Writable;

//Represents a single day which represents whether the user got their period,
// fasted and the mood of the user
public class PeriodDay implements Writable {
    protected boolean fast; // Whether the  user fasted or not
    protected boolean period; // Whether the user is on their period or not
    protected String mood; // The mood of the user
    protected String name; // name of user

    //EFFECTS: period day is composed of fasting,period and mood
    public PeriodDay(boolean period, boolean fasting, String mood,String name) {
        this.fast = fasting;
        this.period = period;
        this.mood = mood;
        this.name = name;
    }

    //EFFECTS: returns true if user fasted
    public boolean getFast() {
        return fast;
    }

    //EFFECTS: returns true if user is on their period
    public boolean getPeriod() {
        return period;
    }

    public String getName() {
        return name;
    }

    //EFFECTS:returns the mood of the user which can be "happy, Sad, angry"
    public String getMood() {
        return mood;
    }


    // EFFECTS: Updates the value of the fast variable
    public void setFast(boolean fast) {
        this.fast = fast;
    }

    //EFFECTS: Updates the value of the period variable
    public void setPeriod(boolean period) {
        this.period = period;
    }

    //EFFECTS:Updates the Mood of the User
    public void setMood(String mood) {
        this.mood = mood;
    }
    //  EFFECTS: returns string representation of the days fasted

    public String toString() {
        return fast + "!";

    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("mood",mood);
        json.put("period",period);
        json.put("fast",fast);
        return json;
    }


}