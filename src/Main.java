import javax.swing.*;
import java.io.File;
import java.util.*;
import javax.swing.*;

public class Main {

    public static String file1 = "Catan";

    public static void main(String[] args) {

        JFrame frame = new JFrame(file1);    // makes the frame for the game
        frame.setSize(1400, 600);     // sets the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // makes the game close when the cross is pressed
        frame.setVisible(true);     // makes the frame visible


    }
}