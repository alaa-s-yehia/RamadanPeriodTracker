package ui;


import javax.swing.*;
import javax.swing.ImageIcon;

public class OpeningGui extends JFrame {
    private final PanelStack panelStack;
    private final JPanel welcomePanel = new JPanel();
    private final SaveSystem saveSystem;
    private final LoadSystem loadSystem;
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


    public OpeningGui(SaveSystem saveSystem, LoadSystem loadSystem,
                      AddPeriodDayGUI addPeriodDayGUI, ViewDaysFastedGUI viewDaysFastedGUI,
                      MonthGUI monthGUI,
                      PanelStack panelStack) {
        this.panelStack = panelStack;
        this.addPeriodGUI = addPeriodDayGUI;
        this.viewDaysGUI = viewDaysFastedGUI;
        this.monthGUI = monthGUI;
        this.saveSystem = saveSystem;
        this.loadSystem = loadSystem;
        imageAdder();
        addPeriodDayButtonListener();
        viewDaysFastedButtonListener();
        monthButtonListener();
        loadButtonListen();
        saveButtonListen();
        //previousPeriodButtonListener();


    }

    public void imageAdder() {
        photo.setIcon(new ImageIcon("C:\\Users\\asyeh\\Documents\\Audacity\\ramadanmoon.jpg"));
        welcomePanel.add(photo);
        add(welcomePanel);

    }

    public JPanel welcomePage() {
        panelBuilder.buildMainPanel();
        panelBuilder.buildPanelLabel(welcomeJLabel, 32, 45, 10, 500, 60);
        panelBuilder.buildButton(loadButton, 190, 325, 100, 25);
        panelBuilder.buildButton(saveButton, 190, 350, 100, 25);
        panelBuilder.buildButton(addPeriodDayButton, 130, 275, 240, 25);
        panelBuilder.buildButton(viewDaysFastedButton, 130, 300, 240, 25);
     //   panelBuilder.buildButton(previousPeriodButton, 130, 100, 240, 25);
        panelBuilder.buildButton(monthButton, 130, 250, 240, 25);
        panelBuilder.buildPanelLabel(photo, 200, 200, 5, 500, 300);


        return welcomePanel;
    }


    private void loadButtonListen() {
        loadButton.addActionListener(e -> {
            panelStack.getMainFrame();
           // panelStack.getMainFrame().dispose();
            saveSystem.loadExistingFile();
           // new MainGUI();
        });
    }


    private void saveButtonListen() {
        saveButton.addActionListener(e -> {
          //  panelStack.getMainFrame().dispose();
            panelStack.getMainFrame();
            saveSystem.saveFile();
          //  new MainGUI();
        });
    }

    private void addPeriodDayButtonListener() {
        addPeriodDayButton.addActionListener(e -> this.panelStack.loadPanel(this.addPeriodGUI.addPeriodDayPage()));
    }

    private void monthButtonListener() {
        monthButton.addActionListener(e -> this.panelStack.loadPanel(this.monthGUI.mainPage()));
    }

    private void viewDaysFastedButtonListener() {
        viewDaysFastedButton.addActionListener(e -> this.panelStack.loadPanel(this.viewDaysGUI.viewDaysFastedPage()));
    }


//    private void previousPeriodButtonListener() {
//        viewDaysFastedButton.addActionListener(e -> this.panelStack.loadPanel(this.monthGUI.printPreviousPeriod()));
//    }
//

}


