package ui;

import model.PeriodDay;
import model.PeriodTracker;

import java.util.Scanner;

// Period Tracker application
public class PeriodApp {
    protected PeriodDay period;
    protected PeriodTracker periodTracker;
    protected int fast;
    protected Scanner input;

    public PeriodApp() {
        init();
        runPeriod();
    }

    public void runPeriod() {
        periodTracker = new PeriodTracker();
        System.out.println("Welcome to your Ramadan PeriodTracker!");
        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
            System.out.println("---------------------------------");
            System.out.println("Welcome to day: " + (i + 1));
            printPeriod();
            printFast();
            printMood();
            periodTracker.addPeriodDay(period);
        }
    }


    public void init() {
        period = new PeriodDay(false, false, "");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }


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
    }


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
