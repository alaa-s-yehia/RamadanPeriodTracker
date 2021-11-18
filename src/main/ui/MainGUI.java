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
    protected Scanner input;
    private JButton exitButton = new JButton("exit");
    private PanelStack panelStack = new PanelStack(mainFrame);
    private SaveSystem saveSystem = new SaveSystem();
    private LoadSystem loadSystem = new LoadSystem();
    private AddPeriodDaySystem addPeriodDaySystem = new AddPeriodDaySystem();
    private PeriodTracker periodTracker = new PeriodTracker("My Tracker");
    private PeriodDay periodDay = new PeriodDay();
    private ViewDaysFastedGUI viewDaysFastedGUI = new ViewDaysFastedGUI(periodTracker, panelStack);
    private AddPeriodDayGUI addPeriodDayGUI = new AddPeriodDayGUI(addPeriodDaySystem, periodTracker, panelStack);
    private MonthGUI monthGUI = new MonthGUI(periodTracker, panelStack, periodDay, loadSystem);
    private OpeningGui openingGui = new OpeningGui(saveSystem, loadSystem, addPeriodDayGUI, viewDaysFastedGUI,
            monthGUI, panelStack
    );
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
