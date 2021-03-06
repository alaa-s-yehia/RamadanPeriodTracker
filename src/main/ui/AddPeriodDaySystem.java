package ui;

import model.PeriodDay;
import model.PeriodTracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.util.Objects;


//Represents the system that processes user input in the ADD PERIOD DAY GUI
public class AddPeriodDaySystem {
    protected PeriodDay period;

    //EFFECTS: the mechanisms in regard to the AddPeriodDayGUI are created here
    public AddPeriodDaySystem() {
        period = new PeriodDay(false, false, "sad", "My Tracker");

    }

    //EFFECTS: Updates the value of the period variable based on user input
    public void setPeriod(String ans) {
        period.setPeriod(Objects.equals(ans, "yes"));
    }

    //EFFECTS: Updates the value of the fast variable depending on user input
    public void setFast(String ans) {
        period.setFast(Objects.equals(ans, "yes"));
    }

    //EFFECTS: Updates the value of the mood variable depending on user input
    public void setMood(String ans) {
        period.setMood(ans);
    }

    //EFFECTS: Adds day to period tracker
    public void addToTracker(PeriodTracker periodTracker) {
        periodTracker.addPeriodDay(period);
    }

}
