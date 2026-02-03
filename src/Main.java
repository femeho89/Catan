import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {

    public static String file1 = "Catan";
    public static JFrame frame = new JFrame(file1);     // Makes the frame for the game
    static ArrayList<String> playerNames = new ArrayList<>();

    public static void main(String[] args) {

        frame.setSize(1366, 720);     // Sets the frame size
        frame.setLayout(null);

        /*
        Er moet een informatieButton komen op elke frame. Dat moet een nieuwe class worden.
         */

        JButton infoButton = new JButton("i");
        infoButton.setBounds(1200, 50, 50, 50);
        infoButton.setBackground(new Color(255, 255, 255));
        frame.add(infoButton);

        JTextField textField = new JTextField(20);
        textField.setBounds(400, 600, 200, 50);
        JButton textButton = new JButton("Voer in");
        textButton.setBounds(200, 600, 200, 50);
        JLabel outputLabel = new JLabel();
        outputLabel.setBounds(200, 400, 200, 50);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 16));

        frame.add(textField);
        frame.add(textButton);
        frame.add(outputLabel);

        textButton.addActionListener(e -> {
            String input = textField.getText().trim();
            if(input.isEmpty()) {
                outputLabel.setText("Vul namen in.");
            }
            else{
                outputLabel.setText("De namen zijn ingevuld!");
                playerNames.add(input);
                textField.setText("");
            }
        });

        ImageIcon cardTownA = new ImageIcon("Kaart Dorp.png");
        Kaart townA = new Kaart(0, 100, cardTownA.getIconWidth(), cardTownA.getIconHeight(), Kaart.Type.TOWN, cardTownA);

        ImageIcon cardTownB = new ImageIcon("Kaart Stad.png");
        Kaart townB = new Kaart(0, 100, cardTownB.getIconWidth(), cardTownB.getIconHeight(), Kaart.Type.CITY, cardTownB);

        JButton startButton = new JButton("Start Catan");   //makes button to start game
        startButton.setBounds(100, 100, 200, 50);
        startButton.setBackground(new Color(200, 0, 0));
        frame.add(startButton);

        startButton.addActionListener(e -> {
            if(playerNames.size() < 2) {
                return;
            }
            Player[] players = new Player[2];   // Makes a player Array
            players[0] = new Player(playerNames.get(0), cardTownA, cardTownB);
            players[1] = new Player(playerNames.get(1), cardTownA, cardTownB);

            Game game = new Game(players);

            ActionListener listener = new StartButtonActionListener(game);

            startButton.addActionListener(listener);
        });

        Color colorBackground = new Color(255, 255, 255);    // Makes a white color
        frame.getContentPane().setBackground(colorBackground);

        frame.setVisible(true);     // Makes the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Makes the game close when the cross is pressed
    }
}