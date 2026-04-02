import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main {
    public static int playerNamesSizeComparison;
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

        PlayerAmountButtons.TwoPlayerButton();
        PlayerAmountButtons.ThreePlayerButton();
        PlayerAmountButtons.FourPlayerButton();

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

        JLabel player1 = new JLabel();
        player1.setBounds(600, 600, 200, 50);
        player1.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(player1);

        JLabel player2 = new JLabel();
        player2.setBounds(600, 550, 200, 50);
        player2.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(player2);

        JLabel player3 = new JLabel();
        player3.setBounds(600, 500, 200, 50);
        player3.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(player3);

        JLabel player4 = new JLabel();
        player4.setBounds(600, 450, 200, 50);
        player4.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(player4);



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

                if(!playerNames.isEmpty()) {
                    player1.setText("Naam speler 1: " + playerNames.getFirst());
                }
                if(playerNames.size() >= 2) {
                    player2.setText("Naam speler 2: " + playerNames.get(1));
                }
                if(playerNames.size() >= 3) {
                    player3.setText("Naam speler 3: " + playerNames.get(2));
                }
                if(playerNames.size() >= 4) {
                    player4.setText("Naam speler 4: " + playerNames.get(3));
                }
            }
        });

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
            if(playerNames.size() < PlayerNamesSize()) { //if the size of the ArrayList playerNames is less than 2
                return;
            }
            Player[] players = new Player[PlayerNamesSize()];   // Makes a player Array
            //adds new player the Array Player at index 0 with the attributes: String name, ImageIcon cardImage, ImageIcon card2Image
            players[0] = new Player(playerNames.get(0));
            //adds new player the Array Player at index 1 with the attributes: String name, ImageIcon cardImage, ImageIcon card2Image
            players[1] = new Player(playerNames.get(1));
            if(PlayerNamesSize() >= 3){
                players[2] = new Player(playerNames.get(2));
            }
            if(PlayerNamesSize() >= 4) {
                players[3] = new Player(playerNames.get(3));
            }

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
        if(playerNames.size() < playerNamesSizeComparison) {
            label.setText("Vul namen in.");
        }
        else{
            label.setText("De namen zijn ingevuld!");
        }
    }

    public static int PlayerNamesSize(){
        if (PlayerAmountListener.getFourPlayers()){
            playerNamesSizeComparison = 4;
        } else if (PlayerAmountListener.getThreePlayers()) {
            playerNamesSizeComparison = 3;
        } else {playerNamesSizeComparison = 2;}
        return playerNamesSizeComparison;
    }
}