package ui;

import model.PeriodDay;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LoginPanelBuilder {
    private final JPanel panel;
    private JLabel title;
    private final Font infoFont;
    private final Font titleFont;

//    /**
//     * Sets the panel of this builder class
//     *
//     * @param panel the panel that is used throughout this builder class
//     */
    public LoginPanelBuilder(JPanel panel) {
        this.panel = panel;
        this.title = new JLabel("");
        titleFont = new Font(Font.MONOSPACED, Font.BOLD, 40);
        infoFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    }

//
//    /**
//     * @return the font used in this program
//     */
    public Font getInfoFont() {
        return infoFont;
    }

    public void buildMainPanel() {
        this.panel.setSize(500, 500);
        this.panel.setLayout(null);
    }

//
//    public void buildCalendar() {
//
//    }


//    /**
//     * Builds the JLabel of the panel
//     *
//     * @param justLabel represents the title of the panel
//     * @param size      of the text font of the justLabel
//     * @param x         represents the x coordinate of the justLabel
//     * @param y         represents the y coordinate of the justLabel
//     * @param width     of the justLabel
//     * @param height    of the justLabel
//     */
    public void buildPanelLabel(JLabel justLabel, int size, int x, int y, int width, int height) {
        justLabel.setFont(new Font(Font.MONOSPACED, Font.TYPE1_FONT, size));
        justLabel.setBounds(x, y, width, height);
        this.panel.add(justLabel);
    }

    public JScrollPane buildMessagePreview(JScrollPane messagePreview) {
        messagePreview.setBounds(300, 80, 130, 160);
        messagePreview.setFont(infoFont);
        panel.add(messagePreview);
        return messagePreview;
    }

    public JButton makeBackButton() {
        JButton backButton = new JButton("back");
        backButton.setFont(infoFont);
        backButton.setBounds(350, 22, 75, 30);
        return backButton;
    }


//    /**
//     * Builds a component that is added to the panel
//     *
//     * @param component represents the component that is added to the panel
//     * @param x         represents the x coordinate of the component
//     * @param y         represents the y coordinate of the component
//     * @param width     of the component
//     * @param height    of the component
//     */
    public void buildComponent(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height);
        panel.add(component);
    }

    /**
     * Builds a JList with the input list model and formats it.
     *
     * @param list the input DefaultListModel
     * @return the built JList
     */
    public JList<PeriodDay> buildJList(DefaultListModel<PeriodDay> list) {
        JList<PeriodDay> justList = new JList<>(list);
        justList.setBounds(50, 80, 220, 300);
        justList.setFixedCellHeight(40);
        justList.setFixedCellWidth(100);
        justList.setFont(infoFont);
        justList.setSelectionBackground(Color.cyan);
        justList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        justList.setLayoutOrientation(JList.VERTICAL);
        justList.setVisibleRowCount(0);
        panel.add(justList);
        return justList;
    }

//    /**
//     * Builds a list of buttons with a set x coordinate, width and height, using
//     * the input parameters.
//     *
//     * @param options a String[] containing the button texts
//     * @param startY  the starting y coordinate of the set of buttons
//     * @return a list of JButton containing the built buttons
//     */
    public java.util.List<JButton> buildOptions(String[] options, int startY) {
        List<JButton> buttons = new ArrayList<>();
        int y = startY;
        for (String option : options) {
            JButton button = new JButton(option);
            button.setFont(infoFont);
            button.setBounds(305, y, 120, 30);
            y += 40;
            buttons.add(button);
            panel.add(button);
        }
        return buttons;
    }

    public JScrollPane buildMainPane(JScrollPane justScroll, String title) {
        this.title.setVisible(true);
        this.title.setText(title);
        justScroll.setBounds(50, 80, 225, 340);
        justScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        justScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        justScroll.setVisible(true);
        panel.add(justScroll);
        panel.add(this.title);
        return justScroll;
    }





//    /**
//     * Builds a button that is added to the panel
//     *
//     * @param button represents the component that is added to the panel
//     * @param x      represents the x coordinate of the button
//     * @param y      represents the y coordinate of the button
//     * @param width  of the button
//     * @param height of the button
//     */
    public void buildButton(JButton button, int x, int y, int width, int height) {
        button.setFont(infoFont);
        button.setBounds(x, y, width, height);
        panel.add(button);
    }

}
