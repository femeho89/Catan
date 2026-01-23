import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartButtonActionListener implements ActionListener {
    private final Game game;
    private int turns;
    private int victoryPoints;

    public StartButtonActionListener(Game game) {
        victoryPoints = 0;
        turns = 0;
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        victoryPoints = 0;
        turns = 0;

        Player currentPlayer = game.getCurrentPlayer();
        Kaart card = currentPlayer.getCard();
        Kaart card2 = currentPlayer.getCard2();

        JFrame playingFrame = new JFrame(Main.file1);    // The playing screen
        playingFrame.setSize(1366, 720);
        playingFrame.setLayout(null);
        playingFrame.add(card);
        playingFrame.add(card2);

        JLabel points = new JLabel(currentPlayer.getName() + " heeft: " + currentPlayer.getVictoryPoints() + " overwinningspunt(en)");
        points.setFont(new Font("Arial", Font.BOLD, 12));
        points.setBounds(60, 40, 200, 60);
        playingFrame.add(points);

        Timer timer = new Timer(9, event -> {
            card.setX(card.getX() + 1);
            card2.setX(card2.getX() + 1);
            card.setLocation(card.getX(), card.getY());
            card2.setLocation(card2.getX(), card2.getY());
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

                if (SwingUtilities.isRightMouseButton(e)) {
                    int mouseX = e.getX();
                    int mouseY = e.getY();

                    if (mouseX <= card.getX() + card.image.getIconWidth() && mouseX >= card.getX() && mouseY <= card.getY() + card.image.getIconHeight() && mouseY >= card.getY()) {    // Makes the card turn when the right mouse button is pressed
                        turns += 1;

                        if (turns % 2 == 1) {
                            card.setVisible(false);
                            card2.setVisible(true);
                            currentPlayer.addCard(card2.getType());
                            currentPlayer.removeCard(card.getType());
                        } else if (turns % 2 == 0) {
                            card.setVisible(true);
                            card2.setVisible(false);
                            currentPlayer.addCard(card.getType());
                            currentPlayer.removeCard(card2.getType());
                        }
                    }
                    points.setText(currentPlayer.getName() + " heeft: " + currentPlayer.getVictoryPoints() + " overwinningspunt(en)");
                }
            }
        });
        ActionListener nextListener = h -> {
            game.getCurrentPlayer().refreshCardCoordinates();

            game.switchPlayer();
            currentPlayer = game.getCurrentPlayer();
            card = currentPlayer.getCard();
            card2 = currentPlayer.getCard2();

            card.setVisible(true);
            card2.setVisible(false);

            card.setLocation(card.getX(), card.getY());
            card2.setLocation(card2.getX(), card2.getY());

            turns = 0;
            points.setText(currentPlayer.getName() + " heeft: " + currentPlayer.getVictoryPoints() + " overwinningspunt(en)");
        };

        JButton nextButton = new JButton("Volgende ronde");
        nextButton.setBounds(890, 50, 200, 50);
        nextButton.setBackground(new Color(200, 0, 0));
        playingFrame.add(nextButton);
        nextButton.addActionListener(nextListener);

        ActionListener endListener = g -> {
            Main.frame.setVisible(true);
            playingFrame.setVisible(false);
            card.setVisible(false);
            card.setX(0);
            card2.setVisible(false);
            card2.setX(0);
            timer.stop();
        };

        JButton endButton = new JButton("Stop Catan");
        endButton.setBounds(1100, 50, 200, 50);
        endButton.setBackground(new Color(200, 0, 0));
        playingFrame.add(endButton);
        endButton.addActionListener(endListener);


        playingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
