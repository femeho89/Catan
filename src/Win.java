import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win implements ActionListener {
    //makes a win frame for when a player has won the game
    private static JFrame winFrame = new JFrame(Main.file1);

    @Override
    public void actionPerformed(ActionEvent e) {
        //sets the size of GUI component winFrame
        winFrame.setSize(1366, 720);
        //sets background colour of GUI component winFrame
        winFrame.setBackground(new Color(200, 50, 150));
        //sets the layout of GUI component winFrame
        winFrame.setLayout(null);

        //sets playingFrame to invisible
        StartButtonActionListener.getPlayingFrame().setVisible(false);
        //sets winFrame to visible
        winFrame.setVisible(true);

        JLabel winText = new JLabel(" Gefeliciteerd!!! \s Je hebt Catan gewonnen!!!");
        winText.setBounds(633, 360, 500, 250);
        winText.setFont(new Font("Arial", Font.BOLD, 16));
        winText.setBackground(new Color(255, 50, 150));

        winFrame.add(winText);
    }

    public static JFrame getWinFrame() {
        return winFrame;
    }

}
