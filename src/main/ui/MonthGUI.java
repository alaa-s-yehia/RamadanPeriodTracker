package ui;

import model.PeriodDay;
import model.PeriodTracker;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.*;
import java.util.List;

//Represents the Panel that pastes the user's input
public class MonthGUI {

    private final PeriodTracker periodTracker;
    private PeriodDay periodDay;
    private final PanelStack panelStack;
    private final JLabel titleLabel = new JLabel("Period Log");
    private final JLabel programTitleJLabel = new JLabel("Ramadan Period Tracker");
    private JLabel previousPeriodLabel = new JLabel();
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

    //EFFECTS: updates the information on the panel depending on the user input
    public void updatePeriod() {
        this.previousPeriodLabel.setText("past period" + periodTracker.getPeriod());
    }

    //EFFECTS: builds the page that displays the user's input
    public JPanel mainPage() {
        panelBuilder.buildMainPanel();
        panelBuilder.buildPanelLabel(titleLabel, 20, 180, 100, 200, 30);
        // PROGRAM TITLE:
        panelBuilder.buildPanelLabel(programTitleJLabel, 32, 40, 10, 500, 60);
        panelBuilder.buildButton(backButton, 10, 410, 80, 25);
        updatePeriod();
        panelBuilder.buildPanelLabel(previousPeriodLabel, 10, 5, 200, 500, 60);
        return monthPanel;

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





