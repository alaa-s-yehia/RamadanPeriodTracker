package ui;

import model.PeriodDay;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Represents the panel of this builder class
public class LoginPanelBuilder {
    private final JPanel panel;
    private JLabel title;
    private final Font infoFont;
    private final Font titleFont;


//EFFECTS: the panel that is used throughout this builder class

    public LoginPanelBuilder(JPanel panel) {
        this.panel = panel;
        this.title = new JLabel("");
        titleFont = new Font(Font.MONOSPACED, Font.BOLD, 40);
        infoFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    }


//EFFECTS: return the font used in this program

    public Font getInfoFont() {
        return infoFont;
    }

    //EFFECTS: builds the Main Panel for whichever GUI it's called for
    public void buildMainPanel() {
        this.panel.setSize(500, 500);
        this.panel.setLayout(null);
    }

    //EFFECTS: builds labels that are used within panels
    public void buildPanelLabel(JLabel justLabel, int size, int x, int y, int width, int height) {
        justLabel.setFont(new Font(Font.MONOSPACED, Font.TYPE1_FONT, size));
        justLabel.setBounds(x, y, width, height);
        this.panel.add(justLabel);
    }

    // EFFECTS: builds components that can be present on panels
    public void buildComponent(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height);
        panel.add(component);
    }


//EFFECTS:Builds a button that is added to the panel

    public void buildButton(JButton button, int x, int y, int width, int height) {
        button.setFont(infoFont);
        button.setBounds(x, y, width, height);
        panel.add(button);
    }

}
