package ui;

import model.PeriodDay;
import model.PeriodTracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.util.Scanner;

public class AddPeriodDaySystem {
    protected PeriodDay period;
    private PeriodTracker periodTracker;
    protected int fast;
    protected Scanner input;
    private static final String PERIOD_TRACK = "./data/periodTracker.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;


    public AddPeriodDaySystem() {
        periodTracker = new PeriodTracker("My Tracker");

    }

    public void printPeriodGUI() {
        String command = null;
        command = command.toLowerCase();
        if (command.equals("yes")) {
            period.setPeriod(true);

        } else if (command.equals("no")) {
            period.setPeriod(false);
        }


    }

    public void printFastGUI() {
        String command = "";
        if (command.equals("yes")) {
            period.setFast(true);
        } else if (command.equals("no")) {
            System.out.println("That's alright!");
            period.setFast(false);

        }
    }

    public void printMoodGUI() {
        String command = "";
        if (command.equals("happy")) {
            System.out.println("That's good to hear!");
            period.setMood("happy");


        } else if (command.equals("sad")) {
            System.out.println("I hope your day gets better!");
            period.setMood("sad");

        } else if (command.equals("angry")) {
            System.out.println("I hope your day gets better!");
            period.setMood("angry");
        }
    }

}
