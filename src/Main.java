import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Main {

    public static String file1 = "Catan";

    public static void main(String[] args) {

        JFrame frame = new JFrame(file1);    // makes the frame for the game
        frame.setSize(1366, 720);     // sets the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // makes the game close when the cross is pressed
        frame.setVisible(true);     // makes the frame visible

        Color colorBackground = new Color(255, 255, 255);    // makes a white color
        frame.getContentPane().setBackground(colorBackground);


    }
}