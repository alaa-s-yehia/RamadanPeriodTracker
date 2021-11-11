package ui;

import ui.PanelBuilder.LoginPanelBuilder;

import javax.swing.*;


public class OpeningGui {
    private final PanelStack panelStack;
    private final JPanel welcomePanel = new JPanel();
    private final JLabel welcomeJLabel = new JLabel("Ramadan Period Tracker");
    private final JButton loadButton = new JButton("Load");
    private final JButton saveButton = new JButton("Save");
    private final JButton addPeriodDayButton = new JButton("Add Period Day");
    private final JButton viewDaysFastedButton = new JButton("View Days Fasted ");
    private final AddPeriodDayGUI addPeriodGUI;
    private final LoadGUI loadGUI;
    private final SaveGUI saveGUI;
    private final ViewDaysFastedGUI viewDaysGUI;
    private final LoginPanelBuilder panelBuilder = new LoginPanelBuilder(welcomePanel);



    public OpeningGui(LoadGUI loadGUI, SaveGUI saveGUI,AddPeriodDayGUI addPeriodGUI,ViewDaysFastedGUI viewDaysGUI,
                      PanelStack panelStack) {
        this.loadGUI = loadGUI;
        this.panelStack = panelStack;
        this.saveGUI = saveGUI;
        this.addPeriodGUI = addPeriodGUI;
        this.viewDaysGUI = viewDaysGUI;
        loadButtonListener();
        saveButtonListener();
        addPeriodDayButtonListener();
        viewDaysFastedButtonListener();

    }

    public JPanel welcomePage() {
        panelBuilder.buildMainPanel();
        panelBuilder.buildPanelLabel(welcomeJLabel, 32, 65, 10, 500, 60);
        panelBuilder.buildButton(loadButton, 190, 250, 100, 25);
        panelBuilder.buildButton(saveButton, 190, 275, 100, 25);
        panelBuilder.buildButton(addPeriodDayButton,150,250,100,25);
        panelBuilder.buildButton(viewDaysFastedButton,130,220,100,25);

        return welcomePanel;
    }

//    private void loadButtonListener() {
//        loadButton.addActionListener(e -> this.panelStack.loadPanel(this.loadGUI.logInPage()));
//    }
//
//    private void saveButtonListener() {
//        saveButton.addActionListener(e -> this.panelStack.loadPanel(this.saveGUI.signUpPage()));
//    }

    private void addPeriodDayButtonListener() {
        addPeriodDayButton.addActionListener(e -> this.panelStack.loadPanel(this.addPeriodGUI.addPeriodDayPage()));
    }

    private void viewDaysFastedButtonListener() {
        viewDaysFastedButton.addActionListener(e -> this.panelStack.loadPanel(this.viewDaysGUI.signUpPage()));
    }
}


