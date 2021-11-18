package ui;

import model.PeriodDay;
import model.PeriodTracker;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.*;
import java.util.List;


public class MonthGUI {

    private final PeriodTracker periodTracker;
    private PeriodDay periodDay;
    private final PanelStack panelStack;
    private final PanelHelper panelHelper = new PanelHelper();
    private final JLabel titleLabel = new JLabel("Period Log");
    private final JLabel programTitleJLabel = new JLabel("Ramadan Period Tracker");
    private JLabel previousPeriodLabel = new JLabel();
    private final JPanel monthPanel = new JPanel();
    private final LoginPanelBuilder panelBuilder = new LoginPanelBuilder(monthPanel);
    private final JButton backButton = new JButton("back");


    //trackerPanel elements
    private JList<String> periodDayJList;
    private final DefaultListModel<String> trackerListModel = new DefaultListModel<>();
    private PeriodDay currTrackerDay;


    public MonthGUI(PeriodTracker periodTracker, PanelStack panelStack, PeriodDay periodDay, LoadSystem loadSystem) {
        this.periodTracker = periodTracker;
        this.periodDay = periodDay;
        this.panelStack = panelStack;
        backButtonListen();
    }

    public void updatePeriod() {
        this.previousPeriodLabel.setText("past period" + periodTracker.getPeriod());
        // trackerListModel.addElement(this.previousPeriodLabel.setText("previous periods" + periodTracker.getPeriod());
        // this.previousPeriodLabel. (periodTracker.getPeriod());

    }


    public JPanel mainPage() {
        panelBuilder.buildMainPanel();
        panelBuilder.buildPanelLabel(titleLabel, 20, 180, 100, 200, 30);
        // PROGRAM TITLE:
        panelBuilder.buildPanelLabel(programTitleJLabel, 32, 40, 10, 500, 60);
        panelBuilder.buildButton(backButton, 10, 410, 80, 25);
//        JScrollPane periodLog = new JScrollPane(previousPeriodTracker());
//        periodLog.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        periodLog.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        updatePeriod();
        panelBuilder.buildPanelLabel(previousPeriodLabel, 10, 80, 200, 500, 60);

//        monthPanel.setVisible(true);
        return monthPanel;

    }

    //    //  EFFECTS: prints all the days fasted in periodTracker to the console
    public JPanel printPreviousPeriod() {
        List<PeriodDay> days = periodTracker.getPeriod();
        for (PeriodDay p : days) {
            this.previousPeriodLabel.setText("Your past Periods" + p);
        }
        return monthPanel;

    }

    //  EFFECTS: prints all the days fasted in periodTracker to the console
    private JTextArea previousPeriodTracker() {
        List<PeriodDay> days = periodTracker.getPeriod();
        String s = "";

        for (PeriodDay p : days) {
            s += p.toString() + ("\n");
        }
        JTextArea textArea = new JTextArea(s);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);
        return textArea;

    }

    private void backButtonListen() {
        backButton.addActionListener(e -> {
            panelStack.pop();
            JPanel panel = (JPanel) panelStack.pop();
            panelStack.loadPanel(panel);
        });
    }
}





