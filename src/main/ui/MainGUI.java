package ui;


import model.PeriodDay;
import model.PeriodTracker;
import ui.SaveSystem;
import ui.LoadSystem;
import ui.AddPeriodDaySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.util.Scanner;

public class MainGUI {
    private JFrame mainFrame = new JFrame();
    private PeriodTracker periodTracker;
    protected Scanner input;
    private JButton exitButton = new JButton("exit");
    private PanelStack panelStack = new PanelStack(mainFrame);
    private SaveSystem saveSystem = new SaveSystem();
    private LoadSystem loadSystem = new LoadSystem();
    private RamadanCalendar ramadanCalendar;
    private AddPeriodDaySystem addPeriodDaySystem = new AddPeriodDaySystem();
    private ViewDaysFastedGUI viewDaysFastedGUI;
    private AddPeriodDayGUI addPeriodDayGUI;
    private OpeningGui openingGui = new OpeningGui(saveSystem, loadSystem,
            addPeriodDayGUI, viewDaysFastedGUI, ramadanCalendar,panelStack);
    private JPanel currentJPanel = new JPanel();


    public MainGUI() {
        input = new Scanner(System.in);
        currentJPanel.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setResizable(false);
        mainFrame.setTitle("Ramadan Period Tracker");
        periodTracker = new PeriodTracker("My Tracker");
        viewDaysFastedGUI = new ViewDaysFastedGUI(periodTracker, panelStack);
        addPeriodDayGUI = new AddPeriodDayGUI(addPeriodDaySystem, periodTracker, panelStack);
        ramadanCalendar = new RamadanCalendar(0, 0, panelStack);
        run();
        exitButtonListen();
    }

    public void exitButtonListen() {
        exitButton.addActionListener(e -> {
            panelStack.getMainFrame().dispose();
            System.exit(0);

        });
    }


    public void run() {
        panelStack.loadPanel(openingGui.welcomePage());
    }
}
