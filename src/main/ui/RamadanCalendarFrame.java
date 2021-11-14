package ui;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//cite:
public class RamadanCalendarFrame implements Runnable {
    private JFrame  frame;
//    private final PanelStack panelStack;

    @Override
    public void run() {
//        // Month is zero based
//        RamadanCalendar panel = new RamadanCalendar(4, 2022);

        frame = new JFrame();
        frame.setTitle("Calendar");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        frame.setLayout(new FlowLayout());
//        frame.add(panelStack);
        frame.pack();
        // frame.setBounds(100, 100, 400, 200);
        frame.setVisible(true);
    }

    public void exitProcedure() {
        frame.dispose();
        System.exit(0);
    }


}

