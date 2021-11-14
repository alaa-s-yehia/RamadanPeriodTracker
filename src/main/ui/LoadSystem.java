package ui;

import model.PeriodDay;
import model.PeriodTracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoadSystem {
    protected PeriodDay period;
    protected PeriodTracker periodTracker;
    protected int fast;
    protected Scanner input;
    private static final String PERIOD_TRACK = "./data/periodTracker.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;


    public LoadSystem() {
        periodTracker = new PeriodTracker("My Tracker");
        jsonWriter = new JsonWriter(PERIOD_TRACK);
        jsonReader = new JsonReader(PERIOD_TRACK);
    }

    // MODIFIES: this
    // EFFECTS: loads periodTracker from file
    public void loadExistingFile() {
        try {
            periodTracker = jsonReader.read();
            System.out.println("Loaded " + periodTracker.getName() + " from " + PERIOD_TRACK);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + PERIOD_TRACK);
        }

    }


}
