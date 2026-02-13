import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main {
    //initialises String 'file1' & declares it as "Catan"
    public static String file1 = "Catan";
    //initialises JFrame 'frame' & declares it as a new JFrame(file1)
    public static JFrame frame = new JFrame(file1);     // Makes the frame for the game
    //initialises ArrayList<String> 'playerNames' & declares it as a new ArrayList
    static ArrayList<String> playerNames = new ArrayList<>();
    //initialises ArrayList<Integer> 'cardTextStreet' & declares it as a new ArrayList
    static ArrayList<Integer> cardTextsStreet = new ArrayList<>();
    //initialises ArrayList<Integer> 'cardTextKnight' & declares it as a new ArrayList
    static ArrayList<Integer> cardTextsKnight = new ArrayList<>();
    //initialises ArrayList<Integer> 'cardTextTown' & declares it as a new ArrayList
    static ArrayList<Integer> cardTextsTown = new ArrayList<>();
    //initialises ArrayList<Integer> 'cardTextCity' & declares it as a new ArrayList
    static ArrayList<Integer> cardTextsCity = new ArrayList<>();
    //initialises ArrayList<Integer> 'cardTextCityExtension' & declares it as a new ArrayList
    static ArrayList<Integer> cardTextsCityExtension = new ArrayList<>();

    public static void main(String[] args) {
        frame.setSize(1366, 720);     // Sets the frame size
        //sets layout to null
        frame.setLayout(null);

        /*
        Er moet een informatieButton komen op elke frame. Dat moet een nieuwe class worden.
         */

        //initialises 'infoButton' & declares it a new JButton with the text "i"
        JButton infoButton = new JButton("i");
        //sets the position & size of GUI component infoButton
        infoButton.setBounds(1200, 50, 50, 50);
        //sets the background colour of GUI component endButton
        infoButton.setBackground(new Color(255, 255, 255));
        //initialises Actionlistener 'infoActionListener' & declares it a new InfoActionListener
        ActionListener infoActionListener = new InfoActionListener();
        //assigns ActionListener 'infoActionListener' to endButton
        infoButton.addActionListener(infoActionListener);
        //adds infoButton to frame
        frame.add(infoButton);

        //intialises JTextField 'textField' & declares it a new JTextField wit 20 comlums
        JTextField textField = new JTextField(20);
        //sets the position & size of GUI component textField
        textField.setBounds(400, 600, 200, 50);
        //initialises 'textButton' & declares it a new JButton with the text "Voer in"
        JButton textButton = new JButton("Voer in");
        //sets the position & size of GUI component textButton
        textButton.setBounds(200, 600, 200, 50);
        //initialises outputLabel & declares it a new JLabel
        JLabel outputLabel = new JLabel("Vul namen in.");
        //sets the position & size of GUI component outputLabel
        outputLabel.setBounds(200, 400, 200, 50);
        //sets font for outputLabel
        outputLabel.setFont(new Font("Arial", Font.BOLD, 16));

        //adds textField to frame
        frame.add(textField);
        //adds textButton to frame
        frame.add(textButton);
        //adds outputLabel to frame
        frame.add(outputLabel);

        //assigns & declares ActionListener ActionEvent e to textButton?
        textButton.addActionListener(e -> {
            //gets the input text from textField
            String input = textField.getText().trim();
            //if-statement to respond if textField is empty, relying on:
            if(input.isEmpty()) {
                outputLabel.setText("Vul namen in.");
            }
            //else-statement to respond when textField not empty
            else{
                //adds input from textField to ArrayList playerNames
                playerNames.add(input);
                //sets textfield empty
                textField.setText("");

                updateLabel(outputLabel);
                JLabel player1 = new JLabel("Naam speler 1:" + playerNames.get(0));
                player1.setBounds(600, 600, 200, 50);
                player1.setFont(new Font("Arial", Font.BOLD, 16));

                JLabel player2 = new JLabel("Naam speler 2:" + playerNames.get(1));
                player2.setBounds(600, 660, 200, 50);
                player2.setFont(new Font("Arial", Font.BOLD, 16));
            }
        });

        //initialises cardTownA & declares it a new ImageIcon of file "Kaart Dorp.png"
        ImageIcon cardTownA = new ImageIcon("Kaart Dorp.png");
        //initialises townA declares it a new BouwKaart, with input variables being: int x, int y, int height, int width, ImageIcon image, BouwType type
        Kaart townA = new BouwKaart(0, 100, cardTownA.getIconHeight(), cardTownA.getIconWidth(), cardTownA, BouwKaart.BouwType.TOWN);

        //initialises cardTownB & declares it a new ImageIcon of file "Kaart stad.png"
        ImageIcon cardTownB = new ImageIcon("Kaart Stad.png");
        //initialises townB declares it a new BouwKaart, with input variables being: int x, int y, int height, int width, ImageIcon image, BouwType type
        Kaart townB = new BouwKaart(0, 100, cardTownB.getIconHeight(), cardTownB.getIconWidth(), cardTownB, BouwKaart.BouwType.CITY);

        JButton startButton = new JButton("Start Catan");   //makes button to start game
        //sets the position & size of GUI component StartButton
        startButton.setBounds(100, 100, 200, 50);
        //sets the background colour of GUI component startButton
        startButton.setBackground(new Color(200, 0, 0));
        //adds startButton to frame
        frame.add(startButton);

        //assigns & declares ActionListener ActionEvent e to StartButton?
        startButton.addActionListener(e -> {
            //if-statement to return something, relying on:
            if(playerNames.size() < 2) { //if the size of the ArrayList playerNames is less than 2
                return;
            }
            Player[] players = new Player[2];   // Makes a player Array
            //adds new player the Array Player at index 0 with the attributes: String name, ImageIcon cardImage, ImageIcon card2Image
            players[0] = new Player(playerNames.get(0), cardTownA, cardTownB);
            //adds new player the Array Player at index 1 with the attributes: String name, ImageIcon cardImage, ImageIcon card2Image
            players[1] = new Player(playerNames.get(1), cardTownA, cardTownB);

            //initialises game & declares it a new Game with the variable players
            Game game = new Game(players);

            //initializes listener & declares it a new StartButtonActionListener with the variable game
            ActionListener listener = new StartButtonActionListener(game);

            //assigns listener to startButton
            startButton.addActionListener(listener);
        });

        Color backgroundColour = new Color(255, 255, 255);    // Makes a white color
        //gets contentPane for frame & sets the background colour to variable backgroundColour
        frame.getContentPane().setBackground(backgroundColour);

        frame.setVisible(true);     // Makes the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Makes the game close when the cross is pressed
    }
    public static void updateLabel(JLabel label) {
        if(playerNames.size() < 2) {
            label.setText("Vul namen in.");
        }
        else{
            label.setText("De namen zijn ingevuld!");
        }
    }
}