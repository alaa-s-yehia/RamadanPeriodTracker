package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Represents a list of period days
public class PeriodTracker implements Writable {
    protected List<PeriodDay> periodDays;
    protected int fast = 0; // Number of days fasted so far
    protected int period = 0; // Number of days user has been on their period
    protected int numMonths = 30; // Number of days in a month
    int fastsLeftAfter = 0; // Number of days left to fast
    private String name;

    //REQUIRES: Period Day
    //EFFECTS: creates a list of the inputs of a period day .
    // tracking user's input
    public PeriodTracker(String name) {
        periodDays = new ArrayList<>();
        this.name = name;
    }


    //EFFECTS: If user is on their period , one is added to the number
    // of days they're on their period and one is added to the number of
    // days needed to fast
    public void addPeriodDay(PeriodDay day) {

        if (day.getPeriod()) {
            period++;
            fastsLeftAfter++;
            periodDays.add(day);
        }

        if (day.getFast()) {
            fast++;
        }

    }

//    // MODIFIES: this
//    // EFFECTS: adds day to this PeriodTracker
//    public void addDay(PeriodDay day) {
//        periodDays.add(day);
//    }


    //EFFECTS: returns the number of days fasted so far
    public int getFast() {
        return fast;
    }

    //EFFECTS: returns the number of days left to fast
    public int getDaysLeftToFast() {
        return fastsLeftAfter;
    }


    //EFFECTS: returns an unmodifiable list of days in this periodtracker
    public List<PeriodDay> getPeriod() {
        return Collections.unmodifiableList(periodDays);
    }

    public String getName() {
        return name;
    }

    // EFFECTS: returns number of days in the periodtracker
    public int numDays() {
        return periodDays.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("days", periodDaysToJson());
        return json;
    }

    // EFFECTS: returns days in this periodTracker as a JSON array
    private JSONArray periodDaysToJson() {
        JSONArray jsonArray = new JSONArray();

        for (PeriodDay t : periodDays) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}