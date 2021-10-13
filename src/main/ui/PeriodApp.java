package ui;

import model.PeriodTracker;

import java.util.Scanner;

// Period Tracker application
public class PeriodApp {
    private PeriodTracker period;
    private int fast;
    private Scanner input;


    public PeriodApp() {
        runPeriod();
    }

    private void runPeriod() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        for (int i = 0; i < 30; i++) {
            System.out.println("Welcome to your PeriodTracker!");
            printPeriod();
            printFast();
            printMood();
        }
    }


    private void printPeriod() {
        String command = null;
        System.out.println("Are you on your Period? (yes/no)");
        command = input.next();
        command = command.toLowerCase();
        if (command.equals("yes")) {
            period.addPeriod();
        } else if (command.equals("no")) {
            period.endPeriod();
        } else {
            System.out.println("Not a valid Response!");
        }

    }

    private void printMood() {
        String command = null;
        System.out.print("How are you feeling today? (happy/sad/angry)");
        command = input.next();
        command = command.toLowerCase();
        if (command.equals("happy")) {
            System.out.println("That's good to hear!");
            period.getMood();
        } else if (command.equals("sad")) {
            System.out.println("I hope your day gets better!");
            period.getMood();
        } else if (command.equals("angry")) {
            System.out.println("I hope your day gets better!");
            period.getMood();
        } else {
            System.out.println("Selection not valid...");

        }
    }

    private void printFast() {
        String command = null;
        System.out.print("Did you fast today? (yes/no)");
        command = input.next();
        command = command.toLowerCase();
        if (command.equals("yes")) {
            fast = period.fasting();
            System.out.printf("You have ", fast, " days left to fast.");
        } else if (command.equals("no")) {
            System.out.println("That's alright!");
            fast = period.getFast();
            System.out.printf("You have ", fast, " days left to fast.");
        } else {
            System.out.println("Not a valid response");

        }
    }

}
