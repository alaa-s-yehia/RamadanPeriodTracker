package ui;

import java.io.FileNotFoundException;

import javax.swing.*;

public class Main {
    public Main() {
        new MainGUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
//        SwingUtilities.invokeLater(new RamadanCalendarFrame());
        try {
            new PeriodApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }

    }
}
