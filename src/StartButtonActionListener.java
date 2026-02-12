import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartButtonActionListener implements ActionListener {
    public static Timer timer;
    private final Game game;
    private int turns;
    private Player currentPlayer;
    private BouwKaart card;
    private BouwKaart card2;
    private static JFrame playingFrame;

    public static JFrame getPlayingFrame() {
        return playingFrame;
    }

    public StartButtonActionListener(Game game) {   //Purpose: unknown
        turns = 0;                                  //Variable: game
        this.game = game;                           //Return: None
    }

    public void actionPerformed(ActionEvent e) {
        turns = 0;

        currentPlayer = game.getCurrentPlayer();
        card = currentPlayer.getCard();
        card2 = currentPlayer.getCard2();

        if(playingFrame == null) {
            //The playing screen
            playingFrame = new JFrame(Main.file1);
            //Playing screen size
            playingFrame.setSize(1366, 720);
            //Sets layout to null
            playingFrame.setLayout(null);
            playingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        if(playingFrame != null) {
            playingFrame.getContentPane().removeAll();
        }

        //Array of attributes 'player'
        Player[] players = game.getPlayers();

        //for loop of players in Player[]
        for(Player p : players) {
            //adds Card to playingFrame
            playingFrame.add(p.getCard());
            //adds Card2 to playingFrame
            playingFrame.add(p.getCard2());
            //sets Card invisible
            p.getCard().setVisible(false);
            //sets Card2 invisible
            p.getCard2().setVisible(false);
        }

        //sets position & size of GUI component 'card'
        card.setBounds(currentPlayer.getCardX(), currentPlayer.getCardY(), card.getWidth(), card.getHeight());
        //sets position & size of GUI component 'card2'
        card2.setBounds(currentPlayer.getCardX(), currentPlayer.getCardY(), card2.getWidth(), card2.getHeight());

        //sets text for amount of points a player
        JLabel points = new JLabel(currentPlayer.getName() + " heeft: " + currentPlayer.getVictorypoints() + " overwinningspunt(en)");
        //sets font for text
        points.setFont(new Font("Arial", Font.BOLD, 12));
        //sets position & size for text
        points.setBounds(60, 40, 200, 60);
        //shows text on playingFrame
        playingFrame.add(points);

        //timer to move cards
        timer = new Timer(9, event -> {
            //adds 1 pixel to X position of card
            game.getCurrentPlayer().getCard().moveX(1);
            //adds 1 pizel to X position of card2
            game.getCurrentPlayer().getCard2().moveX(1);
        });

        //starts timer to move cards
        timer.start();

        //sets card to visible
        card.setVisible(true);
        //sets card2 to invisible
        card2.setVisible(false);
        //sets frame to invisible
        Main.frame.setVisible(false);
        //sets playingFrame to visible
        playingFrame.setVisible(true);

        //adds MouseListener to playing Frame
        playingFrame.addMouseListener(new MouseAdapter() {
            //overrides something
            @Override
            //function to executean action when the mouse clicks (somewhere?)
            public void mouseClicked(MouseEvent e) {
                //takes variable mouseClicked(e) from somewhere
                super.mouseClicked(e);
                //initialises variable maincard & declares it as currentPlayer.getCard()
                BouwKaart mainCard = currentPlayer.getCard();
                //initialises variable backcard & declares it as currentPlayer.getCard2()
                BouwKaart backCard = currentPlayer.getCard2();

                //if-statement, relying on if something(the mouse click from MouseListener) is the right mouse button?
                if (SwingUtilities.isRightMouseButton(e)) {
                    //initialises variable mouseX & declares it as the X-coordinate of the mouse if the right mouse button is pressed
                    int mouseX = e.getX();
                    //initialises variable mouseY & declares it as the Y-coordinate of the mouse if the right mouse button is pressed
                    int mouseY = e.getY();

                    //if-statement that Makes the card turn when the right mouse button is pressed, relying on:
                    if (mouseX <= mainCard.getX() + mainCard.image.getIconWidth() && //if the X-coordinate of the mouse when pressed is smaller than or equal to the X-coordinate of the mainCard + the image width of the mainCard and
                            mouseX >= mainCard.getX() && //if the X-coordinate of the mouse when pressed is larger than or equal to the X-coordinate of the mainCard and
                            mouseY <= mainCard.getY() + mainCard.image.getIconHeight() && // if the Y-coordinate of the mouse when pressed is smaller than or equal to the Y-coordinate of the mainCard + the image height of the mainCard and
                            mouseY >= mainCard.getY()) { //if the Y-coordinate of the mouse when pressed is larger than or equal to the Y-coordinate of the mainCard
                        //adds 1 to the Int variable 'turns'
                        turns += 1;

                        //if-statement that turns the card from the front side to the back side, relying on:
                        if (turns % 2 == 1) { //if the turns modulus of 2 equals 1
                            //sets mainCard invisible
                            mainCard.setVisible(false);
                            //sets backCard visible
                            backCard.setVisible(true);
                            //adds bouwType of backCard to object? currentPlayer
                            currentPlayer.addCard(backCard.getBouwType());
                            //removes bouwType of mainCard from object? currentPlayer
                            currentPlayer.removeCard(mainCard.getBouwType());
                        }
                        //else if-statement that turns the card from the back side tp the front side, relying on:
                        else if (turns % 2 == 0) { //if the turns modulus of 2 equals 0
                            //sets the mainCard visible
                            mainCard.setVisible(true);
                            //sets the backCard invisible
                            backCard.setVisible(false);
                            //adds bouwType of mainCard to object? currentPlayer
                            currentPlayer.addCard(mainCard.getBouwType());
                            //removes bouwType of backCard from object? currentPlayer
                            currentPlayer.removeCard(backCard.getBouwType());
                        }
                    }
                    //updates the text for the amount of points a player
                    points.setText(currentPlayer.getName() + " heeft: " + currentPlayer.getVictorypoints() + " overwinningspunt(en)");
                }
            }
        });
        //makes ActionListener 'nextListener' to switch players
        ActionListener nextListener = h -> {
            //sets card from currentPlayer invisible
            currentPlayer.getCard().setVisible(false);
            //set card2 from currentPlayer invisible
            currentPlayer.getCard2().setVisible(false);

            //switches player
            game.switchPlayer();
            //sets currenttPlayer to new current player after switch
            currentPlayer = game.getCurrentPlayer();

            //gets card for from new currentPlayer
            card = currentPlayer.getCard();
            //gets card2 for from new currentPlayer
            card2 = currentPlayer.getCard2();

            //if-statement to check and make which card side to show when switching player, relying on:
            if(turns % 2 == 0) {    //if turns modulus of 2 equals 0
                //sets card visible
                card.setVisible(true);
                //sets card2 invisible
                card2.setVisible(false);
            }
            //else-statement to show card2
            else{
                //sets card invisible
                card.setVisible(false);
                //sets card2 visible
                card2.setVisible(true);
            }
            //sets variable 'turns' to 0
            turns = 0;
            //updates text to for the amount of points a player
            points.setText(currentPlayer.getName() + " heeft: " + currentPlayer.getVictorypoints() + " overwinningspunt(en)");
        };

        //initialises 'nextButton' & declares it a new JButton with the text "Volgende ronde"
        JButton nextButton = new JButton("Volgende ronde");
        //sets the position & size of GUI component nextButton
        nextButton.setBounds(890, 50, 200, 50);
        //sets the background colour of GUI component nextButton
        nextButton.setBackground(new Color(200, 0, 0));
        //adds nextButton to playingFrame
        playingFrame.add(nextButton);
        //assigns ActionListener 'nextListener' to nextButton
        nextButton.addActionListener(nextListener);

        //initialises 'endButton' & declares it a new JButton with the text "Stop Catan"
        JButton endButton = new JButton("Stop Catan");
        //sets the position & size of GUI component endButton
        endButton.setBounds(1100, 50, 200, 50);
        //sets the background colour of GUI component endButton
        endButton.setBackground(new Color(200, 0, 0));
        //adds endButton to playingFrame
        playingFrame.add(endButton);
        //assigns ActionListener 'endListener' from EndListener Class to endButton
        endButton.addActionListener(EndListener.getEndListener());

        //initialises 'marketButton' & declares it a new JButton with the text "Naar de markt!"
        JButton marketButton = new JButton("Naar de markt!");
        //sets the position & size of GUI component marketButton
        marketButton.setBounds(50, 550, 200, 50);
        //sets the background colour of GUI component marketButton
        marketButton.setBackground(new Color(200, 0, 0));
        //adds marketButton to playingFrame
        playingFrame.add(marketButton);
        //initialises ActionListener 'marketListener' & declares it as a new MarketActionListener (?)
        ActionListener marketListener = new MarketActionListener();
        //assigns ActionListener 'marketListener' to marketButton
        marketButton.addActionListener(marketListener);

        //initialises 'backButton' & declares it a new JButton with the text "Terug naar start"
        JButton backButton = new JButton("Terug naar start");
        //sets the position & size of GUI component backButton
        backButton.setBounds(600, 200, 200, 50);
        //sets the background colour of GUI component backButton
        backButton.setBackground(new Color(200, 0, 0));

        //if-statement to return something, relying on:
        if(EndListener.getEndFrame() == null) { //if the endFrame in EndListener Class equals null
            //returns something
            return;
        }
        //adds backButton to endFrame in EndListener Class
        EndListener.getEndFrame().add(backButton);
        //assigns ActionListener 'endListener' from EndListener Class to backButton
        backButton.addActionListener(EndListener.getBackListener());

        for(Player p : players) {
            p.getCard().setLocation(0, card.getY());
            p.getCard2().setLocation(0, card2.getY());
            p.getCard().setVisible(false);
            p.getCard2().setVisible(false);
            timer.stop();
            p.setTowns(0);
            p.setCities(0);
            p.setCityExtensions(0);
        }
    }
}
