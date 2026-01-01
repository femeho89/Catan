import javax.swing.*;
import java.awt.*;

public class Main {

    public static String file1 = "Catan";

    public static void main(String[] args) {

        JFrame frame = new JFrame(file1);    // makes the frame for the game
        frame.setSize(1366, 720);     // sets the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // makes the game close when the cross is pressed

        while(playing) {

            Color colorBackground = new Color(255, 255, 255);    // makes a white color
            frame.getContentPane().setBackground(colorBackground);

            ImageIcon cardKnight = new ImageIcon("Kaart Ridder.png");
            JLabel knight = new JLabel(cardKnight);

            knight.setBounds(100, 100, cardKnight.getIconWidth(), cardKnight.getIconHeight());
            frame.add(knight);
            frame.setVisible(true);     // makes the frame visible

            frame.revalidate();
        }
    }
}