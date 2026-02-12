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

    public StartButtonActionListener(Game game) {
        turns = 0;
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        turns = 0;

        currentPlayer = game.getCurrentPlayer();
        card = currentPlayer.getCard();
        card2 = currentPlayer.getCard2();

        playingFrame = new JFrame(Main.file1);    // The playing screen
        playingFrame.setSize(1366, 720);
        playingFrame.setLayout(null);

        Player[] players = game.getPlayers();

        for(Player p : players) {
            playingFrame.add(p.getCard());
            playingFrame.add(p.getCard2());
            p.getCard().setVisible(false);
            p.getCard2().setVisible(false);
        }

        card.setBounds(currentPlayer.getCardX(), currentPlayer.getCardY(), card.getWidth(), card.getHeight());
        card2.setBounds(currentPlayer.getCardX(), currentPlayer.getCardY(), card2.getWidth(), card2.getHeight());

        JLabel points = new JLabel(currentPlayer.getName() + " heeft: " + currentPlayer.getVictorypoints() + " overwinningspunt(en)");
        points.setFont(new Font("Arial", Font.BOLD, 12));
        points.setBounds(60, 40, 200, 60);
        playingFrame.add(points);

        timer = new Timer(9, event -> {
            game.getCurrentPlayer().getCard().moveX(1);
            game.getCurrentPlayer().getCard2().moveX(1);
        });

        timer.start();

        card.setVisible(true);
        card2.setVisible(false);
        Main.frame.setVisible(false);
        playingFrame.setVisible(true);

        playingFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Kaart mainCard = currentPlayer.getCard();
                Kaart backCard = currentPlayer.getCard2();

                if (SwingUtilities.isRightMouseButton(e)) {
                    int mouseX = e.getX();
                    int mouseY = e.getY();

                    if (mouseX <= mainCard.getX() + mainCard.image.getIconWidth() && mouseX >= mainCard.getX() && mouseY <= mainCard.getY() + mainCard.image.getIconHeight() && mouseY >= mainCard.getY()) {    // Makes the card turn when the right mouse button is pressed
                        turns += 1;

                        if (turns % 2 == 1) {
                            mainCard.setVisible(false);
                            backCard.setVisible(true);
                            currentPlayer.addCard(backCard.getBouwType());
                            currentPlayer.removeCard(mainCard.getType());
                        } else if (turns % 2 == 0) {
                            mainCard.setVisible(true);
                            backCard.setVisible(false);
                            currentPlayer.addCard(mainCard.getType());
                            currentPlayer.removeCard(backCard.getType());
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
