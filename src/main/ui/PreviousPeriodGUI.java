//package ui;
//
//import model.PeriodDay;
//import model.PeriodTracker;
//
//import javax.swing.*;
//import java.util.List;
//
//public class PreviousPeriodGUI {
//    private final PanelStack panelStack;
//    private final PeriodTracker periodTracker;
//    private final JPanel logPanel = new JPanel();
//    private final JLabel previousPeriodLabel = new JLabel();
//    private final JLabel titleLabel = new JLabel("Previous Periods ");
//    private final JLabel programTitleJLabel = new JLabel("Ramadan Period Tracker");
//    private final JButton backButton = new JButton("back");
//    private final LoginPanelBuilder panelBuilder = new LoginPanelBuilder(logPanel);
//
//    //EFFECTS: creates a panel that informs the user how many days they need to make up their fast
//    public PreviousPeriodGUI(PeriodTracker periodTracker, PanelStack panelStack) {
//        this.panelStack = panelStack;
//        this.periodTracker = periodTracker;
//        backButtonListen();
//    }
//
//    public void pastPeriodLogs() {
//        List<PeriodDay> days = periodTracker.getPeriod();
//
//        for (PeriodDay p : days) {
//            this.previousPeriodLabel.setText("previous period" + (p));
//        }
//    }
//
//
//    //EFFECTS: builds the view days fasted panel
//    public JPanel previousPeriodPage() {
//        // PANEL:
//        panelBuilder.buildMainPanel();
//        // SIGNUP TITLE:
//        panelBuilder.buildPanelLabel(titleLabel, 20, 180, 100, 200, 30);
//        // PROGRAM TITLE:
//        panelBuilder.buildPanelLabel(programTitleJLabel, 32, 40, 10, 500, 60);
//        //NUMBER OF DAYS FASTED TITLE:
//        pastPeriodLogs();
//        panelBuilder.buildPanelLabel(previousPeriodLabel, 20, 80, 200, 500, 60);
//        // BACK BUTTON:
//        panelBuilder.buildButton(backButton, 10, 400, 80, 25);
//
//        return logPanel;
//    }
//
//    //EFFECTS: builds the back button that takes the user back to the opening Page
//    private void backButtonListen() {
//        backButton.addActionListener(e -> {
//            panelStack.pop();
//            JPanel panel = (JPanel) panelStack.pop();
//            panelStack.loadPanel(panel);
//        });
//    }
//
//}
//
//
