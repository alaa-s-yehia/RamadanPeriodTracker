package ui;

import model.PeriodDay;
import model.PeriodTracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;


public class SaveSystem {
    protected PeriodTracker periodTracker;
    private static final String PERIOD_TRACK = "./data/periodTracker.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public SaveSystem() {
        periodTracker = new PeriodTracker("My Tracker");
        jsonWriter = new JsonWriter(PERIOD_TRACK);
        jsonReader = new JsonReader(PERIOD_TRACK);

    }


    // EFFECTS: saves the periodTracker to file
    public void saveFile() {
        try {
            jsonWriter.open();
            jsonWriter.write(periodTracker);
            jsonWriter.close();
            System.out.println("saved" + periodTracker.getPeriod() + "to" + PERIOD_TRACK);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + PERIOD_TRACK);

        }
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
