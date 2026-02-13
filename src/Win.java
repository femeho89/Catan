import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Win {
    //makes a win frame for when a player has won the game
    private static JFrame winFrame = new JFrame(Main.file1);
    public void actionPerformed(ActionEvent e){
        //sets the size of GUI component winFrame
        winFrame.setSize(1366, 720);
        //sets the layout of GUI component winFrame
        winFrame.setLayout(null);
        //sets background colour of GUI component winFrame
        winFrame.setBackground(new Color(200, 50, 150));
        //sets playingFrame to invisible
        StartButtonActionListener.getPlayingFrame().setVisible(false);
        //sets winFrame to visible
        winFrame.setVisible(true);

        JTextArea winText = new JTextArea("""
                Gefeliciteer!!! \s
                Je hebt Catan gewonnen!!!""");
        winText.setEditable(false);
        winText.setWrapStyleWord(true);
        winText.setBackground(new Color(255,50,150));
    }

    public static JFrame getWinFrame() {
        return winFrame;
    }
}
