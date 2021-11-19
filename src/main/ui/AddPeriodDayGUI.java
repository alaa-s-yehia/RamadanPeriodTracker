package ui;

import model.PeriodTracker;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents the Add Period Day Panel
public class AddPeriodDayGUI implements ActionListener {
    private final PanelStack panelStack;
    private final AddPeriodDaySystem addPeriodDay;
    private final PeriodTracker periodTracker;
    private final JPanel loginPanel = new JPanel();
    private final JLabel titleLabel = new JLabel("Ramadan Tracker");
    private final JLabel onPeriodJLabel = new JLabel("Are you on your period?");
    private final JLabel fastJLabel = new JLabel("Did you fast?");
    private final JLabel moodJLabel = new JLabel("How are you feeling today? (sad/happy/angry)");
    private final JLabel programTitleJLabel = new JLabel("Ramadan Period Tracker");
    private final String[] onPeriodTypes = {"yes", "no"};
    private final String[] onFastTypes = {"yes", "no"};
    private final String[] moodTypes = {"happy", "sad", "angry"};
    private final JComboBox typeComboBox = new JComboBox(onPeriodTypes);
    private final JComboBox typeComboBox2 = new JComboBox(onFastTypes);
    private final JComboBox typeComboBox3 = new JComboBox(moodTypes);
    private final JButton confirmButton = new JButton("Confirm");
    private final JButton backButton = new JButton("back");
    private final LoginPanelBuilder panelBuilder = new LoginPanelBuilder(loginPanel);

//EFFECTS: creates a panel that prompts the user to input data related to their period
    public AddPeriodDayGUI(AddPeriodDaySystem addPeriodDay, PeriodTracker periodTracker, PanelStack panelStack) {
        this.panelStack = panelStack;
        this.addPeriodDay = addPeriodDay;
        this.periodTracker = periodTracker;
        backButtonListen();
        confirmButton.addActionListener(this);
    }

//EFFECTS: builds the page where the user inputs data related to their period
    public JPanel addPeriodDayPage() {
        // PANEL:
        panelBuilder.buildMainPanel();
        // PROGRAM TITLE:
        panelBuilder.buildPanelLabel(programTitleJLabel, 32, 40, 10, 500, 60);
        // ON PERIOD:
        panelBuilder.buildComponent(onPeriodJLabel, 140, 200, 200, 25);
        panelBuilder.buildComponent(typeComboBox, 150, 225, 165, 25);
        // FASTING?:
        panelBuilder.buildComponent(fastJLabel, 170, 264, 200, 25);
        panelBuilder.buildComponent(typeComboBox2, 150, 289, 165, 25);
        //MOOD?:
        panelBuilder.buildComponent(moodJLabel, 120, 330, 300, 25);
        panelBuilder.buildComponent(typeComboBox3, 150, 355, 165, 25);
        // BACK BUTTON:
        panelBuilder.buildButton(backButton, 10, 410, 80, 25);
        // CONFIRM BUTTON:
        panelBuilder.buildButton(confirmButton, 350, 410, 100, 25);
        // Sets the font of the period and mood labels
        onPeriodJLabel.setFont(panelBuilder.getInfoFont());
        fastJLabel.setFont(panelBuilder.getInfoFont());
        return loginPanel;
    }

    //EFFECTS: the listener for the back button, it takes the user back to the opening screen
    private void backButtonListen() {
        backButton.addActionListener(e -> {
            addPeriodDay.addToTracker(periodTracker);
            panelStack.pop();
            JPanel panel = (JPanel) panelStack.pop();
            panelStack.loadPanel(panel);
        });
    }

    //EFFECTS: processes the item selected by the user from the drop-down menu
    @Override
    public void actionPerformed(ActionEvent e) {
        addPeriodDay.setPeriod((String) typeComboBox.getSelectedItem());
        addPeriodDay.setFast((String) typeComboBox2.getSelectedItem());
        addPeriodDay.setMood((String) typeComboBox3.getSelectedItem());

    }
}

