package ui;

import model.PeriodDay;
import model.PeriodTracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

//Represents the save and load system
public class SaveSystem {
    protected PeriodTracker periodTracker;
    private static final String PERIOD_TRACK = "./data/periodTracker.json";
    private JLabel previousPeriodLogLabel = new JLabel();
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
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + PERIOD_TRACK);

        }
    }

    // MODIFIES: this
    // EFFECTS: loads periodTracker from file
    public PeriodTracker loadExistingFile() {
        try {
            JsonReader jsonReader = new JsonReader(PERIOD_TRACK);
            periodTracker = jsonReader.read();
            System.out.println("Loaded " + periodTracker.getName() + " from " + PERIOD_TRACK);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + PERIOD_TRACK);
        }
        return periodTracker;

    }


}
