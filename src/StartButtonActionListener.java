import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartButtonActionListener implements ActionListener {
    public static Timer timer;
    private final Game game;
    private Player currentPlayer;
    private static JFrame playingFrame;
    public static JLabel streets;
    public static JLabel towns;
    public static JLabel cities;
    public static JLabel cityExtensions;
    public static JLabel points;
    //initialises ActionListener 'step1Listener'
    private static ActionListener step1Listener;
    //initialises ActionListener 'buildListener'
    private static ActionListener buildListener;
    //initialises ActionListener 'step3Listener'
    private static ActionListener step3Listener;
    //initialises ActionListener 'ownedCardListener'
    private static ActionListener ownedCardListener;


    public static JFrame getPlayingFrame() {
        return playingFrame;
    }

    public StartButtonActionListener(Game game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {

        currentPlayer = game.getCurrentPlayer();

        if (playingFrame == null) {
            //The playing screen
            playingFrame = new JFrame(Main.file1);
            //Playing screen size
            playingFrame.setSize(1366, 720);
            //Sets layout to null
            playingFrame.setLayout(null);
            playingFrame.getContentPane().setBackground(new Color(237, 140, 98));
            playingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        if (playingFrame != null) {
            playingFrame.getContentPane().removeAll();
        }

        //Array of attributes 'player'
        Player[] players = game.getPlayers();

        //for loop of players in Player[]
        for (Player p : players) {
            for(BouwKaart card : p.getBouwKaarten()) {
                playingFrame.add(card);
                card.setVisible(false);
            }
        }

        //sets text for amount of points a player
        points = new JLabel(currentPlayer.getName() + " heeft: " + currentPlayer.getVictorypoints() + " overwinningspunt(en)");
        //sets font for text
        points.setFont(new Font("Arial", Font.BOLD, 12));
        //sets position & size for text
        points.setBounds(60, 40, 200, 60);
        //shows text on playingFrame
        playingFrame.add(points);

        //timer to move cards
        timer = new Timer(9, event -> {
            for(BouwKaart card : currentPlayer.getBouwKaarten()) {
                card.moveX(1);
            }
        });

        //starts timer to move cards
        timer.start();

        for(BouwKaart kaart : currentPlayer.getBouwKaarten()) {
            kaart.setVisible(true);
        }

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
                //if-statement, relying on if something(the mouse click from MouseListener) is the right mouse button?
                if (SwingUtilities.isRightMouseButton(e)) {
                    for(BouwKaart card : currentPlayer.getBouwKaarten()) {
                        if(card.contains(e.getPoint())) {
                            card.turn();
                            //updates the text for the amount of points a player
                            points.setText(currentPlayer.getName() + " heeft: " + currentPlayer.getVictorypoints() + " overwinningspunt(en)");
                            break;
                        }
                    }
                }
            }
        });
        //makes ActionListener 'nextListener' to switch players
        ActionListener nextListener = h -> {
            //sets card from currentPlayer invisible
            currentPlayer.setBouwCardsVisible(false);
            currentPlayer.setGrondstofCardsVisible(false);

            //switches player
            game.switchPlayer();
            //sets currenttPlayer to new current player after switch
            currentPlayer = game.getCurrentPlayer();
            currentPlayer.setBouwCardsVisible(true);
            currentPlayer.setGrondstofCardsVisible(true);

            if (10 <= currentPlayer.getVictorypoints()) {
                new Win();
            }

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

        //initialises 'step1Button' & declares it a new JButton with the text "1. Grondstofkaarten ruilen"
        JButton step1Button = new JButton("1. Grondstofkaarten ruilen");
        //sets the position & size of GUI component step1Button
        step1Button.setBounds(1100, 450, 200, 50);
        //sets the background colour of GUI component step1Button
        step1Button.setBackground(new Color(200, 0, 100));
        //adds step1Button to playingFrame
        playingFrame.add(step1Button);
        //assigns ActionListener 'step1Button' to set1Button
        step1Button.addActionListener(step1Listener);

        //initialises 'step2Button' & declares it a new JButton with the text "2. Bouwkaarten bouwen"
        JButton step2Button = new JButton("2. Bouwkaarten bouwen");
        //sets the position & size of GUI component step2Button
        step2Button.setBounds(1100, 500, 200, 50);
        //sets the background colour of GUI component step2Button
        step2Button.setBackground(new Color(200, 0, 100));
        //adds step2Button to playingFrame
        playingFrame.add(step2Button);
        ActionListener buildListener = new Bouwen();
        //assigns ActionListener 'step2Listener' to step2Button
        step2Button.addActionListener(buildListener);

        //initialises 'step3Button' & declares it a new JButton with the text "3. nieuwe grondstoffen"
        JButton step3Button = new JButton("3. nieuwe grondstoffen");
        //sets the position & size of GUI component step3Button
        step3Button.setBounds(1100, 550, 200, 50);
        //sets the background colour of GUI component step3Button
        step3Button.setBackground(new Color(200, 0, 100));
        //adds step3Button to playingFrame
        playingFrame.add(step3Button);
        //assigns ActionListener 'step3Listener' to step3Button
        step3Button.addActionListener(step3Listener);

        JButton winButtonTemp = new JButton("win");
        winButtonTemp.setBounds(1100, 400, 200, 50);
        winButtonTemp.setBackground(new Color(200, 150, 200));
        playingFrame.add(winButtonTemp);
        //initializes listener & declares it a new StartButtonActionListener with the variable game
        ActionListener Winlistener = new Win();
        //assigns listener to startButton
        winButtonTemp.addActionListener(Winlistener);

        //initialises 'ownedCardButton' & declares it a new JButton with the text "Jouw kaaten zien"
        JButton ownedCardButton = new JButton("Jouw kaarten zien");
        //sets the position & size of GUI component ownedCardButton
        ownedCardButton.setBounds(550, 550, 200, 50);
        //sets the background colour of GUI component ownedCardButton
        ownedCardButton.setBackground(new Color(200, 0, 0));
        //adds ownedCardButton to playingFrame
        playingFrame.add(ownedCardButton);
        //assigns ActionListener 'ownedCardListener' to ownedCardButton
        ownedCardButton.addActionListener(ownedCardListener);

        //initialises 'backButton' & declares it a new JButton with the text "Terug naar start"
        JButton backButton = new JButton("Terug naar start");
        //sets the position & size of GUI component backButton
        backButton.setBounds(600, 200, 200, 50);
        //sets the background colour of GUI component backButton
        backButton.setBackground(new Color(200, 0, 0));

        streets = new JLabel("Je hebt " + Bouwen.getStreets() + " streets");
        streets.setBounds(100, 360, 100, 20);
        playingFrame.add(streets);

        towns = new JLabel("Je hebt " + Bouwen.getTowns() + " towns");
        towns.setBounds(220, 360, 100, 20);
        playingFrame.add(towns);

        cities = new JLabel("Je hebt " + Bouwen.getCities() + " cities");
        cities.setBounds(340, 360, 100, 20);
        playingFrame.add(cities);

        cityExtensions = new JLabel("Je hebt " + Bouwen.getCityExtensions() + " cityExtensions");
        cityExtensions.setBounds(460, 360, 100, 20);
        playingFrame.add(cityExtensions);

        //if-statement to return something, relying on:
        if (EndListener.getEndFrame() == null) { //if the endFrame in EndListener Class equals null
            //returns something
            return;
        }
        //adds backButton to endFrame in EndListener Class
        EndListener.getEndFrame().add(backButton);
        //assigns ActionListener 'endListener' from EndListener Class to backButton
        backButton.addActionListener(EndListener.getBackListener());

        for (Player p : players) {
            for(BouwKaart card : currentPlayer.getBouwKaarten()) {
                card.setLocation(0, card.getY());
                card.setVisible(false);
            }
            timer.stop();
        }
    }
}
