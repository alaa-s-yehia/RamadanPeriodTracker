package ui;


import javax.swing.*;
import javax.swing.ImageIcon;


//Represents the Welcome Panel
public class OpeningGui extends JFrame {
    private final PanelStack panelStack;
    private final JPanel welcomePanel = new JPanel();
    private final SaveSystem saveSystem;
    private final JLabel welcomeJLabel = new JLabel("Ramadan Period Tracker");
    private final JButton loadButton = new JButton("Load");
    private final JButton saveButton = new JButton("Save");
    private final JLabel photo = new JLabel();
    private final JButton addPeriodDayButton = new JButton("Add Period Day");
    private final JButton viewDaysFastedButton = new JButton("View Days Fasted ");
    private final JButton previousPeriodButton = new JButton("Previous Period ");
    private final JButton monthButton = new JButton("View Period Logs ");
    private final AddPeriodDayGUI addPeriodGUI;
    private final ViewDaysFastedGUI viewDaysGUI;
    private final MonthGUI monthGUI;
    private final LoginPanelBuilder panelBuilder = new LoginPanelBuilder(welcomePanel);

    //EFFECTS: displays the various buttons on the welcome page
    public OpeningGui(SaveSystem saveSystem,
                      AddPeriodDayGUI addPeriodDayGUI, ViewDaysFastedGUI viewDaysFastedGUI,
                      MonthGUI monthGUI,
                      PanelStack panelStack) {
        this.panelStack = panelStack;
        this.addPeriodGUI = addPeriodDayGUI;
        this.viewDaysGUI = viewDaysFastedGUI;
        this.monthGUI = monthGUI;
        this.saveSystem = saveSystem;
        imageAdder();
        addPeriodDayButtonListener();
        viewDaysFastedButtonListener();
        monthButtonListener();
        loadButtonListen();
        saveButtonListen();


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
        panelBuilder.buildButton(saveButton, 190, 350, 100, 25);
        panelBuilder.buildButton(addPeriodDayButton, 130, 275, 240, 25);
        panelBuilder.buildButton(viewDaysFastedButton, 130, 300, 240, 25);
        panelBuilder.buildButton(monthButton, 130, 250, 240, 25);
        panelBuilder.buildPanelLabel(photo, 200, 200, 5, 500, 300);


        return welcomePanel;
    }

    //EFFECTS: Loads the users data
    private void loadButtonListen() {
        loadButton.addActionListener(e -> {
            panelStack.getMainFrame();
            saveSystem.loadExistingFile();
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


}


