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

        //The playing screen
        playingFrame = new JFrame(Main.file1);
        //Playing screen size
        playingFrame.setSize(1366, 720);
        //Sets layout to null
        playingFrame.setLayout(null);

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
            //function to ...
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                BouwKaart mainCard = currentPlayer.getCard();
                BouwKaart backCard = currentPlayer.getCard2();

                if (SwingUtilities.isRightMouseButton(e)) {
                    int mouseX = e.getX();
                    int mouseY = e.getY();

                    if (mouseX <= mainCard.getX() + mainCard.image.getIconWidth() && mouseX >= mainCard.getX() && mouseY <= mainCard.getY() + mainCard.image.getIconHeight() && mouseY >= mainCard.getY()) {    // Makes the card turn when the right mouse button is pressed
                        turns += 1;

                        if (turns % 2 == 1) {
                            mainCard.setVisible(false);
                            backCard.setVisible(true);
                            currentPlayer.addCard(backCard.getBouwType());
                            currentPlayer.removeCard(mainCard.getBouwType());
                        } else if (turns % 2 == 0) {
                            mainCard.setVisible(true);
                            backCard.setVisible(false);
                            currentPlayer.addCard(mainCard.getBouwType());
                            currentPlayer.removeCard(backCard.getBouwType());
                        }
                    }
                    points.setText(currentPlayer.getName() + " heeft: " + currentPlayer.getVictorypoints() + " overwinningspunt(en)");
                }
            }
        });
        ActionListener nextListener = h -> {
            currentPlayer.getCard().setVisible(false);
            currentPlayer.getCard2().setVisible(false);

            game.switchPlayer();
            currentPlayer = game.getCurrentPlayer();

            card = currentPlayer.getCard();
            card2 = currentPlayer.getCard2();

            if(turns % 2 == 0) {
                card.setVisible(true);
                card2.setVisible(false);
            } else{
                card.setVisible(false);
                card2.setVisible(true);
            }
            turns = 0;
            points.setText(currentPlayer.getName() + " heeft: " + currentPlayer.getVictorypoints() + " overwinningspunt(en)");
        };

        JButton nextButton = new JButton("Volgende ronde");
        nextButton.setBounds(890, 50, 200, 50);
        nextButton.setBackground(new Color(200, 0, 0));
        playingFrame.add(nextButton);
        nextButton.addActionListener(nextListener);

        JButton endButton = new JButton("Stop Catan");
        endButton.setBounds(1100, 50, 200, 50);
        endButton.setBackground(new Color(200, 0, 0));
        playingFrame.add(endButton);
        endButton.addActionListener(EndListener.getEndListener());

        JButton marketButton = new JButton("Naar de markt!");
        marketButton.setBounds(50, 550, 200, 50);
        marketButton.setBackground(new Color(200, 0, 0));
        playingFrame.add(marketButton);
        ActionListener marketListener = new MarketActionListener();
        marketButton.addActionListener(marketListener);

        JButton backButton = new JButton("Terug naar start");
        backButton.setBounds(600, 200, 200, 50);
        backButton.setBackground(new Color(200, 0, 0));

        if(EndListener.getEndFrame() == null) {
            return;
        }
        EndListener.getEndFrame().add(backButton);
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

        playingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
