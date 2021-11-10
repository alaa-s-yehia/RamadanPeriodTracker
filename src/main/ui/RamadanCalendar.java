package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

// cite:

public class RamadanCalendar extends JPanel {

    private static final long serialVersionUID = 1L;

    protected int month;
    protected int year;

    protected String[] monthNames = {"Ramadan"};

    protected String[] dayNames = {"S", "M", "T", "W",
            "T", "F", "S"};

    public RamadanCalendar(int month, int year) {
        this.month = month;
        this.year = year;

        this.add(createGUI());
    }

    protected JPanel createGUI() {
        JPanel monthPanel = new JPanel(true);
        monthPanel.setBorder(BorderFactory
                .createLineBorder(SystemColor.activeCaption));
        monthPanel.setLayout(new BorderLayout());
        monthPanel.setBackground(Color.WHITE);
        monthPanel.setForeground(Color.BLACK);
        monthPanel.add(createTitleGUI(), BorderLayout.NORTH);
        monthPanel.add(createDaysGUI(), BorderLayout.SOUTH);

        return monthPanel;
    }

    protected JPanel createTitleGUI() {
        JPanel titlePanel = new JPanel(true);
        titlePanel.setBorder(BorderFactory
                .createLineBorder(SystemColor.activeCaption));
        titlePanel.setLayout(new FlowLayout());
        titlePanel.setBackground(Color.WHITE);

        JLabel label = new JLabel(monthNames[month] + " " + year);
        label.setForeground(SystemColor.activeCaption);

        titlePanel.add(label, BorderLayout.CENTER);

        return titlePanel;
    }

    protected JPanel createDaysGUI() {
        JPanel dayPanel = new JPanel(true);
        dayPanel.setLayout(new GridLayout(0, dayNames.length));

        Calendar today = Calendar.getInstance();
        int oneMonth = today.get(Calendar.MONTH);
        int oneYear = today.get(Calendar.YEAR);
        int oneDay = today.get(Calendar.DAY_OF_MONTH);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Calendar iterator = (Calendar) calendar.clone();
        iterator.add(Calendar.DAY_OF_MONTH,
                -(iterator.get(Calendar.DAY_OF_WEEK) - 1));

        Calendar maximum = (Calendar) calendar.clone();
        maximum.add(Calendar.MONTH, +1);

        for (int i = 0; i < dayNames.length; i++) {
            JPanel thePanel = new JPanel(true);
            thePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel theLabel = new JLabel(dayNames[i]);
            thePanel.add(theLabel);
            dayPanel.add(thePanel);
        }

        int count = 0;
        int limit = dayNames.length * 6;

        while (iterator.getTimeInMillis() < maximum.getTimeInMillis()) {
            int theMonth = iterator.get(Calendar.MONTH);
            int theYear = iterator.get(Calendar.YEAR);

            JPanel anotherPanel = new JPanel(true);
            anotherPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel dayLabel = new JLabel();

            if ((theMonth == month) && (theYear == year)) {
                int singleDay = iterator.get(Calendar.DAY_OF_MONTH);
                dayLabel.setText(Integer.toString(singleDay));
                if ((oneMonth == month) && (oneYear == year) && (oneDay == singleDay)) {
                    anotherPanel.setBackground(Color.ORANGE);
                } else {
                    anotherPanel.setBackground(Color.WHITE);
                }
            } else {
                dayLabel.setText(" ");
                anotherPanel.setBackground(Color.WHITE);
            }
            anotherPanel.add(dayLabel);
            dayPanel.add(anotherPanel);
            iterator.add(Calendar.DAY_OF_YEAR, +1);
            count++;
        }

        for (int i = count; i < limit; i++) {
            JPanel secondPanel = new JPanel(true);
            secondPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel dayLabel = new JLabel();
            dayLabel.setText(" ");
            secondPanel.setBackground(Color.WHITE);
            secondPanel.add(dayLabel);
            dayPanel.add(secondPanel);
        }

        return dayPanel;
    }

}

