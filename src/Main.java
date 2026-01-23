import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static String file1 = "Catan";
    public static JFrame frame = new JFrame(file1);     // Makes the frame for the game

    public static void main(String[] args) {

        frame.setSize(1366, 720);     // Sets the frame size
        frame.setLayout(null);

        ImageIcon cardTownA = new ImageIcon("Kaart Dorp.png");
        Kaart townA = new Kaart(100, 100, cardTownA.getIconWidth(), cardTownA.getIconHeight(), Kaart.Type.TOWN, cardTownA);

        ImageIcon cardTownB = new ImageIcon("Kaart Stad.png");
        Kaart townB = new Kaart(townA.getX(), townA.getY(), cardTownB.getIconWidth(), cardTownB.getIconHeight(), Kaart.Type.CITY, cardTownB);

        JButton startButton = new JButton("Start Catan");
        startButton.setBounds(100, 100, 200, 50);
        startButton.setBackground(new Color(200, 0, 0));
        frame.add(startButton);

        Player[] players = new Player[2];   // Makes a player Array
        players[0] = new Player("Jens", cardTownA, cardTownB);
        players[1] = new Player("Feltse", cardTownA, cardTownB);

        Game game = new Game(players);

        Player current = game.getCurrentPlayer();
        current.addCard(Kaart.Type.TOWN);

        ActionListener listener = new StartButtonActionListener(game);

        startButton.addActionListener(listener);

        Color colorBackground = new Color(255, 255, 255);    // Makes a white color
        frame.getContentPane().setBackground(colorBackground);

        frame.setVisible(true);     // Makes the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Makes the game close when the cross is pressed
    }
}