package ui;

import model.PeriodDay;
import model.PeriodTracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;

public class SaveGUI {
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;

    public SaveGUI{
        private JsonReader jsonReader;
        private JsonWriter jsonWriter;

    }


    // EFFECTS: saves the periodTracker to file
    public void saveFile() {
        try {
            jsonWriter.open();
            jsonWriter.write(periodTracker);
            jsonWriter.close();
            System.out.println("saved" + periodTracker.getDaysLeftToFast() + "to" + PERIOD_TRACK);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + PERIOD_TRACK);

        }
    }
}
