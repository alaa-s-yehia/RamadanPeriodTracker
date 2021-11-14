package ui;

import model.PeriodDay;
import model.PeriodTracker;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewDaysFastedGUI {
    private final PanelStack panelStack;
    private final PeriodTracker periodTracker;
    private final JPanel fastPanel = new JPanel();
    private final JLabel daysFastedLabel;
    private final JLabel titleLabel = new JLabel("Days Fasted");
    private final JLabel programTitleJLabel = new JLabel("Ramadan Period Tracker");
    private final JButton backButton = new JButton("back");
    private final LoginPanelBuilder panelBuilder = new LoginPanelBuilder(fastPanel);

    public ViewDaysFastedGUI(PeriodTracker periodTracker, PanelStack panelStack) {
        this.panelStack = panelStack;
        this.periodTracker = periodTracker;
        this.daysFastedLabel = new JLabel("You have " + periodTracker.getDaysLeftToFast()
                + " days left to fast.");
        viewDaysFastedPage();
        backButtonListen();
    }

    public JPanel viewDaysFastedPage() {
        // PANEL:
        panelBuilder.buildMainPanel();
        // SIGNUP TITLE:
        panelBuilder.buildPanelLabel(titleLabel, 20, 200, 164, 200, 30);
        // PROGRAM TITLE:
        panelBuilder.buildPanelLabel(programTitleJLabel, 32, 65, 10, 500, 60);
        //NUMBER OF DAYS FASTED TITLE:
        panelBuilder.buildPanelLabel(daysFastedLabel, 50, 80, 10, 500, 60);
        // BACK BUTTON:
        panelBuilder.buildButton(backButton, 10, 430, 80, 25);
        return fastPanel;
    }

    private void backButtonListen() {
        backButton.addActionListener(e -> {
            panelStack.pop();
            JPanel panel = (JPanel) panelStack.pop();
            panelStack.loadPanel(panel);
        });
    }

}
