package ui;

import model.PeriodTracker;

import javax.swing.*;

// Represent the number of days the user needs to make up their fast

public class ViewDaysFastedGUI {
    private final PanelStack panelStack;
    private final PeriodTracker periodTracker;
    private final JPanel fastPanel = new JPanel();
    private final JLabel daysFastedLabel = new JLabel();
    private final JLabel titleLabel = new JLabel("Days Fasted");
    private final JLabel programTitleJLabel = new JLabel("Ramadan Period Tracker");
    private final JButton backButton = new JButton("back");
    private final LoginPanelBuilder panelBuilder = new LoginPanelBuilder(fastPanel);

    //EFFECTS: creates a panel that informs the user how many days they need to make up their fast
    public ViewDaysFastedGUI(PeriodTracker periodTracker, PanelStack panelStack) {
        this.panelStack = panelStack;
        this.periodTracker = periodTracker;
        backButtonListen();
    }

    //EFFECTS: updates the number of days the user needs to make up their fast
    public void updatePeriodDays() {
        this.daysFastedLabel.setText("You have " + periodTracker.getDaysLeftToFast()
                + " days left to fast.");
    }

    //EFFECTS: builds the view days fasted panel
    public JPanel viewDaysFastedPage() {
        // PANEL:
        panelBuilder.buildMainPanel();
        // SIGNUP TITLE:
        panelBuilder.buildPanelLabel(titleLabel, 20, 180, 100, 200, 30);
        // PROGRAM TITLE:
        panelBuilder.buildPanelLabel(programTitleJLabel, 32, 40, 10, 500, 60);
        //NUMBER OF DAYS FASTED TITLE:
        updatePeriodDays();
        panelBuilder.buildPanelLabel(daysFastedLabel, 20, 80, 200, 500, 60);
        // BACK BUTTON:
        panelBuilder.buildButton(backButton, 10, 400, 80, 25);

        return fastPanel;
    }

    //EFFECTS: builds the back button that takes the user back to the opening Page
    private void backButtonListen() {
        backButton.addActionListener(e -> {
            panelStack.pop();
            JPanel panel = (JPanel) panelStack.pop();
            panelStack.loadPanel(panel);
        });
    }

}
