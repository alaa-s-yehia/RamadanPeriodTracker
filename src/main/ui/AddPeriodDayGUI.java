package ui;

import model.PeriodDay;
import model.PeriodTracker;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


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
    private final JButton enterButton = new JButton("enter");
    private final LoginPanelBuilder panelBuilder = new LoginPanelBuilder(loginPanel);


    public AddPeriodDayGUI(AddPeriodDaySystem addPeriodDay, PeriodTracker periodTracker, PanelStack panelStack) {
        this.panelStack = panelStack;
        this.addPeriodDay = addPeriodDay;
        this.periodTracker = periodTracker;
        enterButtonListen();
        confirmButton.addActionListener(this);
    }


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
        panelBuilder.buildButton(enterButton, 10, 410, 80, 25);

        panelBuilder.buildButton(confirmButton, 70, 410, 80, 25);


        onPeriodJLabel.setFont(panelBuilder.getInfoFont());
        fastJLabel.setFont(panelBuilder.getInfoFont());
        return loginPanel;
    }

    private void enterButtonListen() {
        enterButton.addActionListener(e -> {
            addPeriodDay.addToTracker(periodTracker);
            panelStack.pop();
            JPanel panel = (JPanel) panelStack.pop();
            panelStack.loadPanel(panel);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addPeriodDay.setPeriod((String) typeComboBox.getSelectedItem());
        addPeriodDay.setFast((String) typeComboBox2.getSelectedItem());
        addPeriodDay.setMood((String) typeComboBox3.getSelectedItem());
//        if (Objects.equals(typeComboBox.getSelectedItem(), "yes")) {
//            addPeriodDay.printPeriodGUI();
//
//        } else if (Objects.equals(typeComboBox.getSelectedItem(), "no")) {
//            addPeriodDay.printPeriodGUI();
//
//        }
//        if (Objects.equals(typeComboBox2.getSelectedItem(), "yes")) {
//            addPeriodDay.printFastGUI();
//
//        } else if (Objects.equals(typeComboBox2.getSelectedItem(), "no")) {
//            addPeriodDay.printFastGUI();
//        }
//        if (Objects.equals(typeComboBox3.getSelectedItem(), "sad")) {
//            addPeriodDay.printMoodGUI();
//        } else if (Objects.equals(typeComboBox3.getSelectedItem(), "happy")) {
//            addPeriodDay.printMoodGUI();
//        } else if (Objects.equals(typeComboBox3.getSelectedItem(), "angry")) {
//            addPeriodDay.printMoodGUI();
//        }
    }
}

