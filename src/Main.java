import javax.swing.*;
import java.awt.*;

public class Main {

    public static String file1 = "Catan";
    public static int xKnight = 100;

    public static void main(String[] args) {

        JFrame frame = new JFrame(file1);    // makes the frame for the game
        frame.setSize(1366, 720);     // sets the frame size

        ImageIcon cardKnight = new ImageIcon("Kaart Ridder.png");
        JLabel knight = new JLabel(cardKnight);
        frame.setLayout(null);

        knight.setBounds(xKnight, 100, cardKnight.getIconWidth(), cardKnight.getIconHeight());
        frame.add(knight);

        Timer timerKnight = new Timer(9, e -> {
            xKnight += 3;
            knight.setLocation(xKnight, 100);
        });

        timerKnight.start();

        Color colorBackground = new Color(255, 255, 255);    // makes a white color
        frame.getContentPane().setBackground(colorBackground);

        frame.setVisible(true);     // makes the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // makes the game close when the cross is pressed
    }
}