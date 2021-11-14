package ui;


import javax.swing.*;
import java.awt.event.WindowAdapter;


public class OpeningGui {
    private final PanelStack panelStack;
    private final JPanel welcomePanel = new JPanel();
    private final SaveSystem saveSystem;
    private final LoadSystem loadSystem;
    private final JLabel welcomeJLabel = new JLabel("Ramadan Period Tracker");
    private final JButton loadButton = new JButton("Load");
    private final JButton saveButton = new JButton("Save");
    private final JButton addPeriodDayButton = new JButton("Add Period Day");
    private final JButton viewDaysFastedButton = new JButton("View Days Fasted ");
    private final AddPeriodDayGUI addPeriodGUI;
    private final ViewDaysFastedGUI viewDaysGUI;
    private final LoginPanelBuilder panelBuilder = new LoginPanelBuilder(welcomePanel);


    public OpeningGui(SaveSystem saveSystem, LoadSystem loadSystem,
                      AddPeriodDayGUI addPeriodDayGUI, ViewDaysFastedGUI viewDaysFastedGUI,
                      PanelStack panelStack) {
        this.panelStack = panelStack;
        this.addPeriodGUI = addPeriodDayGUI;
        this.viewDaysGUI = viewDaysFastedGUI;
        this.saveSystem = saveSystem;
        this.loadSystem = loadSystem;
        loadButtonListen();
        saveButtonListen();
        addPeriodDayButtonListener();
        viewDaysFastedButtonListener();

    }

    public JPanel welcomePage() {
        panelBuilder.buildMainPanel();
        panelBuilder.buildPanelLabel(welcomeJLabel, 32, 65, 10, 500, 60);
        panelBuilder.buildButton(loadButton, 190, 250, 100, 25);
        panelBuilder.buildButton(saveButton, 190, 275, 100, 25);
        panelBuilder.buildButton(addPeriodDayButton, 150, 250, 100, 25);
        panelBuilder.buildButton(viewDaysFastedButton, 130, 220, 100, 25);

        return welcomePanel;
    }




    private void loadButtonListen() {
        loadButton.addActionListener(e -> {
            panelStack.getMainFrame().dispose();
            loadSystem.loadExistingFile();
            new MainGUI();
        });
    }


    private void saveButtonListen() {
        saveButton.addActionListener(e -> {
            panelStack.getMainFrame().dispose();
            saveSystem.saveFile();
            new MainGUI();
        });
    }

    private void addPeriodDayButtonListener() {
        addPeriodDayButton.addActionListener(e -> this.panelStack.loadPanel(this.addPeriodGUI.addPeriodDayPage()));
    }

    private void viewDaysFastedButtonListener() {
        viewDaysFastedButton.addActionListener(e -> this.panelStack.loadPanel(this.viewDaysGUI.viewDaysFastedPage()));
    }
}


