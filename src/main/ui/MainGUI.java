package ui;


import model.PeriodDay;
import model.PeriodTracker;

import javax.swing.*;
import java.util.Scanner;

//Represents the class that makes calls to every GUI
public class MainGUI {
    private JFrame mainFrame = new JFrame();
    protected Scanner input;
    private JButton exitButton = new JButton("exit");
    private PanelStack panelStack = new PanelStack(mainFrame);
    private SaveSystem saveSystem = new SaveSystem();
    private AddPeriodDaySystem addPeriodDaySystem = new AddPeriodDaySystem();
    private PeriodTracker periodTracker = new PeriodTracker("My Tracker");
    private PeriodDay periodDay = new PeriodDay();
    private ViewDaysFastedGUI viewDaysFastedGUI = new ViewDaysFastedGUI(periodTracker, panelStack);
    private AddPeriodDayGUI addPeriodDayGUI = new AddPeriodDayGUI(addPeriodDaySystem, periodTracker, panelStack);
    private MonthGUI monthGUI = new MonthGUI(periodTracker, panelStack, periodDay);
    private OpeningGui openingGui = new OpeningGui(saveSystem, addPeriodDayGUI, viewDaysFastedGUI,
            monthGUI, panelStack
    );
    private JPanel currentJPanel = new JPanel();

//EFFECTS: creates the frame of the period Tracker
    public MainGUI() {
        input = new Scanner(System.in);
        currentJPanel.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setResizable(false);
        mainFrame.setTitle("Ramadan Period Tracker");
        run();
        exitButtonListen();
    }

    //EFFECTS:creates the listener for the exit button to take the user back to the Main frame (opening panel)
    public void exitButtonListen() {
        exitButton.addActionListener(e -> {
            panelStack.getMainFrame().dispose();
            System.exit(0);

        });
    }

//EFFECTS: runs the application
    public void run() {
        panelStack.loadPanel(openingGui.welcomePage());
    }
}
