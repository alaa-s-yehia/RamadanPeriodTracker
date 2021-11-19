package ui;

import javax.swing.*;
import java.util.Stack;

public class PanelStack extends Stack {

    private final JFrame mainFrame;

    public PanelStack(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    //EFFECTS: Creates the main frame
    public JFrame getMainFrame() {
        return mainFrame;
    }

    //EFFECTS: loads the panel
    public void loadPanel(JPanel panel) {
        this.add(panel);
        mainFrame.setContentPane(panel);
        mainFrame.revalidate();
    }

}
