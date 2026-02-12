import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class EndListener implements ActionListener {
    //initialises JFrame 'endFrame'
    private static JFrame endFrame;
    //initialises ActionListener 'backListener'
    private static ActionListener backListener;
    //initialises ActionListener 'endListener' and declares it as ActionEvent g, to:
    private static final ActionListener endListener = g -> {
        //declares endFrame as a new JFrame from file1 from Main
        endFrame = new JFrame(Main.file1);
        //sets size of endFrame
        endFrame.setSize(1366, 720);
        //sets endFrame visible
        endFrame.setVisible(true);
        //sets playingFrame from StartButtonActionListener Class invisible
        StartButtonActionListener.getPlayingFrame().setVisible(false);
        //playingFrame from StartButtonActionListener Class is destroyed and cleaned up
        StartButtonActionListener.getPlayingFrame().dispose();
        //sets endFrame layout to null
        endFrame.setLayout(null);

        //declares backListener as ActionEvent h to:
        ActionListener backListener = h -> {
            //sets frame from Main Class to visible
            Main.frame.setVisible(true);
            //sets endFrame invisible
            endFrame.setVisible(false);
        };

        //initialises 'backButton' & declares it as a new JButton with the text "Terug naar start"
        JButton backButton = new JButton("Terug naar start");
        //sets the position & size of GUI component backButton
        backButton.setBounds(600, 200, 200, 50);
        //sets the background colour of GUI component backButton
        backButton.setBackground(new Color(200, 0, 0));
        //adds backButton to endFrame
        endFrame.add(backButton);
        //assigns ActionListener 'endListener' to backButton
        backButton.addActionListener(backListener);
    };

    /**
     * A getter for the endFrame
     * @return the endFrame
     */
    public static JFrame getEndFrame() {
      return endFrame;
    }
    /**
     * A getter for the endListener
     * @return the endListener
     */
    public static ActionListener getEndListener() {
        return endListener;
    }
    /**
     * A getter for the backListener
     * @return the backListener
     */
    public static ActionListener getBackListener() {
        return backListener;
    }

    //overrides something
    @Override
    //ends code upon clicking the X in the game tab
    public void actionPerformed(ActionEvent e) {
        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
