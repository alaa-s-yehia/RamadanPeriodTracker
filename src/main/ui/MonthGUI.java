package ui;

import model.PeriodDay;
import model.PeriodTracker;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.*;
import java.awt.*;
import java.util.List;

//Represents the Panel that pastes the user's input
public class MonthGUI {

    private final PeriodTracker periodTracker;
    private PeriodDay periodDay;
    private final PanelStack panelStack;
    private final JLabel titleLabel = new JLabel("Period Log");
    private final JLabel programTitleJLabel = new JLabel("Ramadan Period Tracker");
    private JLabel previousPeriodLabel = new JLabel();
    private DefaultListModel<String> periodListModel = new DefaultListModel<>();
    private JList<String> periodJList;
    private final JPanel monthPanel = new JPanel();
    private final LoginPanelBuilder panelBuilder = new LoginPanelBuilder(monthPanel);
    private final JButton backButton = new JButton("back");


    //EFFECTS: creates a panel that displays the users data
    public MonthGUI(PeriodTracker periodTracker, PanelStack panelStack, PeriodDay periodDay) {
        this.periodTracker = periodTracker;
        this.periodDay = periodDay;
        this.panelStack = panelStack;
        backButtonListen();
    }


    //EFFECTS: builds the page that displays the user's input
    public JPanel mainPage() {
        panelBuilder.buildMainPanel();
        // PROGRAM TITLE:
        panelBuilder.buildPanelLabel(programTitleJLabel, 32, 40, 10, 500, 60);
        panelBuilder.buildButton(backButton, 10, 410, 80, 25);
        // LOG
        monthPanel.add(displayCurrPeriods());

        return monthPanel;

    }

    private String formatPeriod(String period, int index) {
        String[] tokens = period.split("!");
        return "Day " + (index + 1) + " \n period: " + tokens[0] + "\n fasted: " + tokens[1] + "\n mood: " + tokens[2];
    }

    // EFFECTS: prints all the days fasted in periodTracker to the console
    private JScrollPane displayCurrPeriods() {
        periodListModel.clear();
        for (PeriodDay p : periodTracker.getPeriod()) {
            String formatted = formatPeriod(p.toString(), periodTracker.getPeriod().indexOf(p));
            periodListModel.addElement(formatted);
        }
        periodJList = buildJList(periodListModel);
        return buildMainPane(new JScrollPane(periodJList));
    }

    public JScrollPane buildMainPane(JScrollPane scrollPane) {
        scrollPane.setBounds(120, 80, 300, 340);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setVisible(true);
        monthPanel.add(scrollPane);
        return scrollPane;
    }

    //EFFECTS: Builds a Jlist
    private JList<String> buildJList(DefaultListModel<String> list) {
        JList<String> justList = new JList<>(list);
        justList.setBounds(120, 80, 220, 300);
        justList.setFixedCellHeight(40);
        justList.setFixedCellWidth(100);
        justList.setSelectionBackground(Color.cyan);
        justList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        justList.setLayoutOrientation(JList.VERTICAL);
        justList.setVisibleRowCount(0);
        monthPanel.add(justList);
        return justList;
    }


    //EFFECTS: the listener for the back button, it takes the user back to the opening screen
    private void backButtonListen() {
        backButton.addActionListener(e -> {
            panelStack.pop();
            JPanel panel = (JPanel) panelStack.pop();
            panelStack.loadPanel(panel);
        });
    }
}





