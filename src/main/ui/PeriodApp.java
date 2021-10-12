package ui;

import model.PeriodTracker;

import java.util.Scanner;

public class PeriodApp {
    private PeriodTracker period;
    private Scanner input;

    public PeriodApp() {
        runPeriod();
        period = new PeriodTracker();
    }

    private void runPeriod() {
        System.out.println("Welcome to your PeriodTracker!");
    }

    private void printPeriod() {
        String command = null;
        System.out.println("Are you on your Period?");
        command = input.next();
        command = command.toLowerCase();
        if (command == "yes") {
            period.addPeriod();
        } else if (command == "no") {
            period.endPeriod();
        } else {
            System.out.println("Not a valid Response!");
            printPeriod();
        }

    }

    private void printMood() {

    }

    private void printFast() {

    }


}
