import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerAmountButtons {

    public static void TwoPlayerButton() {
        JButton twoPlayerButton = new JButton("2 spelers");   //makes button to start game
        //sets the position & size of GUI component StartButton
        twoPlayerButton.setBounds(0, 600, 200, 50);
        //sets the background colour of GUI component startButton
        twoPlayerButton.setBackground(new Color(200, 0, 0));
        ActionListener Player2Listener = two -> {
            PlayerAmountListener.setTwoPlayers();
        };
        twoPlayerButton.addActionListener(Player2Listener);
        //adds startButton to frame
        Main.frame.add(twoPlayerButton);
    }
    public static void ThreePlayerButton() {
        JButton threePlayerButton = new JButton("3 spelers");   //makes button to start game
        //sets the position & size of GUI component StartButton
        threePlayerButton.setBounds(0, 550, 200, 50);
        //sets the background colour of GUI component startButton
        threePlayerButton.setBackground(new Color(200, 0, 0));
        ActionListener Player3Listener = two -> {
            PlayerAmountListener.setThreePlayers();
        };
        threePlayerButton.addActionListener(Player3Listener);
        //adds startButton to frame
        Main.frame.add(threePlayerButton);
    }
    public static void FourPlayerButton() {
        JButton fourPlayerButton = new JButton("4 spelers");   //makes button to start game
        //sets the position & size of GUI component StartButton
        fourPlayerButton.setBounds(0, 500, 200, 50);
        //sets the background colour of GUI component startButton
        fourPlayerButton.setBackground(new Color(200, 0, 0));
        ActionListener Player4Listener = two -> {
            PlayerAmountListener.setFourPlayers();
        };
        fourPlayerButton.addActionListener(Player4Listener);
        //adds startButton to frame
        Main.frame.add(fourPlayerButton);
    }
}
