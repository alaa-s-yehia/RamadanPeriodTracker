package ui;

import model.PeriodDay;
import model.PeriodTracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.util.Objects;
import java.util.Scanner;

public class AddPeriodDaySystem {
    protected PeriodDay period;
    protected int fast;
    protected Scanner input;
    private static final String PERIOD_TRACK = "./data/periodTracker.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;


    public AddPeriodDaySystem() {
        period = new PeriodDay(false, false, "sad", "My Tracker");

    }


    public void setPeriod(String ans) {
        period.setPeriod(Objects.equals(ans, "yes"));
    }

    public void setFast(String ans) {
        period.setFast(Objects.equals(ans, "yes"));
    }

    public void setMood(String ans) {
        period.setMood(ans);
    }

    public void addToTracker(PeriodTracker periodTracker) {
        periodTracker.addPeriodDay(period);
    }

}
