import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static String file1 = "Catan";
    public static JFrame frame = new JFrame(file1);     // Makes the frame for the game

    public static void main(String[] args) {

        frame.setSize(1366, 720);     // Sets the frame size
        frame.setLayout(null);

        ImageIcon cardKnightA = new ImageIcon("Kaart Ridder.png");
        Kaart knightA = new Kaart(100, 100, cardKnightA.getIconWidth(), cardKnightA.getIconHeight(), "Knight", cardKnightA);

        ImageIcon cardKnightB = new ImageIcon("Kaart Stad.png");
        Kaart knightB = new Kaart(knightA.getX(), knightA.getY(), cardKnightB.getIconWidth(), cardKnightB.getIconHeight(), "Knight", cardKnightB);

        JButton startButton = new JButton("Start Catan");
        startButton.setBounds(100, 100, 200, 50);
        startButton.setBackground(new Color(200, 0, 0));
        frame.add(startButton);

        ActionListener listener = new StartButtonActionListener(knightA, knightB);

        startButton.addActionListener(listener);

        Color colorBackground = new Color(255, 255, 255);    // Makes a white color
        frame.getContentPane().setBackground(colorBackground);

        frame.setVisible(true);     // Makes the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Makes the game close when the cross is pressed
    }
}