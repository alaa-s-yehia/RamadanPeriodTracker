package ui;

import model.PeriodDay;
import model.PeriodTracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// Represents the Period Tracker application
public class PeriodApp {
    protected PeriodDay period;
    protected PeriodTracker periodTracker;
    protected int fast;
    protected Scanner input;
    private static final String PERIOD_TRACK = "./data/periodTracker.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;

    // EFFECTS:runs the Period Application
    public PeriodApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        periodTracker = new PeriodTracker("My Tracker");
        jsonWriter = new JsonWriter(PERIOD_TRACK);
        jsonReader = new JsonReader(PERIOD_TRACK);
        init();
        runPeriod();
    }

    // MODIFIES: this
    //EFFECTS:processes user input
    public void runPeriod() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);
        System.out.println("Welcome to your Ramadan PeriodTracker!");

        while (keepGoing) {
            for (int i = 0; i < 30; i++) {
                System.out.println("\n");
                System.out.println("---------------------------------");
                displayMenu();
                System.out.println("Welcome to day: " + (i + 1));
                command = input.next();
                command = command.toLowerCase();
                processCommand(command);
                periodTracker.addPeriodDay(period);

            }
        }
    }

    //EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> log in period ");
        System.out.println("\tr -> previous period ");
        System.out.println("\ts -> save period tracker to file");
        System.out.println("\tl -> load period tracker from file");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            printPeriod();
            printFast();
            printMood();
        } else if (command.equals("s")) {
            saveFile();
        } else if (command.equals("l")) {
            loadExistingFile();
        } else if (command.equals("r")) {
            printPreviousPeriod();
        } else if (command.equals("q")) {
            System.exit(0);
        } else {
            System.out.println("Selection not valid...");
        }

    }

    private void printPreviousPeriod() {
        List<PeriodDay> days = periodTracker.getPeriod();

        for (PeriodDay p : days) {
            System.out.println(p);
        }
    }

    // MODIFIES: this
    //EFFECTS:Initializes period day
    public void init() {
        period = new PeriodDay(false, false, "", "");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    public void loadExistingFile() {
        try {
            periodTracker = jsonReader.read();
            System.out.println("Loaded " + periodTracker.getName() + " from " + PERIOD_TRACK);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + PERIOD_TRACK);
        }

    }


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

    //EFFECTS:Prints summary of question in regard to user's period
    public void printPeriod() {
        String command = "";

        System.out.println("Are you on your Period? (yes/no)");

        while (true) {
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("yes")) {
                period.setPeriod(true);
                break;

            } else if (command.equals("no")) {
                period.setPeriod(false);
                break;

            } else {
                System.out.println("Not a valid Response!");
            }
        }

    }

    //EFFECTS: prints summary of question in regard to the user fasting
    public void printFast() {
        String command = "";

        System.out.println("Did you fast today? (yes/no)");


        while (true) {
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("yes")) {
                period.setFast(true);
                System.out.println("You have " + periodTracker.getDaysLeftToFast() + " days left to fast.");
                break;

            } else if (command.equals("no")) {
                System.out.println("That's alright!");
                period.setFast(false);
                System.out.println("You have " + periodTracker.getDaysLeftToFast() + " days left to fast.");
                break;

            } else {
                System.out.println("Not a valid response");

            }

        }
        periodTracker.getDaysLeftToFast();
        periodTracker.addDay(new PeriodDay(period.getPeriod(), period.getFast(), "mood", "user"));

    }

    //EFFECTS:print summary of user's potential moods
    public void printMood() {
        String command = "";
        System.out.println("How are you feeling today? (happy/sad/angry)");

        while (true) {
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("happy")) {
                System.out.println("That's good to hear!");
                period.setMood("happy");
                break;

            } else if (command.equals("sad")) {
                System.out.println("I hope your day gets better!");
                period.setMood("sad");
                break;

            } else if (command.equals("angry")) {
                System.out.println("I hope your day gets better!");
                period.setMood("angry");
                break;

            } else {
                System.out.println("Selection not valid...");

            }
        }
    }


}
