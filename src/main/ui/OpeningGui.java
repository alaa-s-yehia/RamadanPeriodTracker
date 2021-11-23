package ui;


import model.EventLog;
import model.PeriodDay;
import model.Event;
import model.PeriodTracker;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Collection;


//Represents the Welcome Panel
public class OpeningGui extends JFrame {
    private final PanelStack panelStack;
    private final JPanel welcomePanel = new JPanel();
    private final SaveSystem saveSystem;
    private final JLabel welcomeJLabel = new JLabel("Ramadan Period Tracker");
    private final JButton loadButton = new JButton("Load");
    private final JButton saveButton = new JButton("Save");
    private final JButton quitButton = new JButton("Quit");
    private final JLabel photo = new JLabel();
    private final JButton addPeriodDayButton = new JButton("Add Period Day");
    private final JButton viewDaysFastedButton = new JButton("View Days Fasted ");
    private final JButton previousPeriodButton = new JButton("Previous Period ");
    private final JButton monthButton = new JButton("View Period Logs ");
    private AddPeriodDayGUI addPeriodGUI;
    private EventLog eventLog;
  //  private Event events;
    private ViewDaysFastedGUI viewDaysGUI;
    private MonthGUI monthGUI;
    private PeriodTracker periodTracker = new PeriodTracker("My Tracker");
    private PeriodDay periodDay = new PeriodDay();
    //private final PreviousPeriodGUI logPeriodGUI;
    private final LoginPanelBuilder panelBuilder = new LoginPanelBuilder(welcomePanel);


    public OpeningGui(SaveSystem saveSystem, PanelStack panelStack) {
        this.panelStack = panelStack;
        this.saveSystem = saveSystem;
        instantiateElements(periodTracker);
        imageAdder();
        loadButtonListen();
        saveButtonListen();
        exitButtonListen();
    }

    public void instantiateElements(PeriodTracker periodTracker) {
        this.viewDaysGUI = new ViewDaysFastedGUI(periodTracker, panelStack);
        this.addPeriodGUI = new AddPeriodDayGUI(periodTracker, panelStack);
        this.monthGUI = new MonthGUI(periodTracker, panelStack, new PeriodDay());
        addPeriodDayButtonListener();
        viewDaysFastedButtonListener();
        monthButtonListener();
    }


    ///EFFECTS: adds an image to the main page
    public void imageAdder() {
        photo.setIcon(new ImageIcon("C:\\Users\\asyeh\\Documents\\Audacity\\ramadanmoon.jpg"));
        welcomePanel.add(photo);
        add(welcomePanel);

    }

    ///EFFECTS: builds the buttons and panel in which the options are displayed
    public JPanel welcomePage() {
        panelBuilder.buildMainPanel();
        panelBuilder.buildPanelLabel(welcomeJLabel, 32, 45, 10, 500, 60);
        panelBuilder.buildButton(loadButton, 190, 325, 100, 25);
        panelBuilder.buildButton(quitButton, 190, 375, 100, 25);
        panelBuilder.buildButton(saveButton, 190, 350, 100, 25);
        panelBuilder.buildButton(addPeriodDayButton, 130, 275, 240, 25);
        panelBuilder.buildButton(viewDaysFastedButton, 130, 300, 240, 25);
        //   panelBuilder.buildButton(previousPeriodButton, 130, 200, 240, 25);
        panelBuilder.buildButton(monthButton, 130, 250, 240, 25);
        panelBuilder.buildPanelLabel(photo, 200, 200, 5, 500, 300);


        return welcomePanel;
    }

    //EFFECTS: Loads the users data
    private void loadButtonListen() {
        loadButton.addActionListener(e -> {
            panelStack.getMainFrame();
            instantiateElements(saveSystem.loadExistingFile());
        });
    }

    //EFFECTS: Quits the application
    private void exitButtonListen() {
        quitButton.addActionListener(e -> {

            for (Event l : EventLog.getInstance()) {
                System.out.println(l);
            }
            System.exit(0);
        });
    }

    //EFFECTS: saves the state of the application
    private void saveButtonListen() {
        saveButton.addActionListener(e -> {
            panelStack.getMainFrame();
            saveSystem.saveFile();
        });
    }

    //EFFECTS: takes the user to the ADD PERIOD DAY panel
    private void addPeriodDayButtonListener() {
        addPeriodDayButton.addActionListener(e -> this.panelStack.loadPanel(this.addPeriodGUI.addPeriodDayPage()));
    }

    //EFFECTS: Takes the user to the month panel that tracks the user input
    private void monthButtonListener() {
        monthButton.addActionListener(e -> this.panelStack.loadPanel(this.monthGUI.mainPage()));
    }

    //EFFECTS: Takes the user to the panel that tells them how many days they need to make up their fast
    private void viewDaysFastedButtonListener() {
        viewDaysFastedButton.addActionListener(e -> this.panelStack.loadPanel(this.viewDaysGUI.viewDaysFastedPage()));
    }

//    //EFFECTS: Takes the user to the panel that tells them how many days they need to make up their fast
//    private void previousPeriodButtonListener() {
//    previousPeriodButton.addActionListener(e -> this.panelStack.loadPanel(this.logPeriodGUI.previousPeriodPage()));
//    }


}


