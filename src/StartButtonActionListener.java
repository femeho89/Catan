import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartButtonActionListener implements ActionListener {

    private final Kaart card;
    private final Kaart card2;
    private int turns;
    private int victoryPoints;
    private int towns = 0;
    private int cities = 0;
    private int cityExtensions = 0;

    public StartButtonActionListener(Kaart card, Kaart card2) {
        victoryPoints = 0;
        turns = 0;
        this.card = card;
        this.card2 = card2;
    }

    public void actionPerformed(ActionEvent e) {
        towns = 0;
        cities = 0;
        cityExtensions = 0;
        victoryPoints = 0;

        JFrame playingFrame = new JFrame(Main.file1);    // The playing screen
        playingFrame.setSize(1366, 720);
        playingFrame.setLayout(null);
        card.setBounds(card.getX(), card.getY(), card.image.getIconWidth(), card.image.getIconHeight());
        playingFrame.add(card);

        card2.setBounds(card.getX(), card.getY(), card2.image.getIconWidth(), card2.image.getIconHeight());
        playingFrame.add(card2);

        JLabel points = new JLabel("Je hebt: " + victoryPoints + " overwinningspunten");
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
        addCard(card.getType());

        victoryPoints = towns + 2 * cities + 3 * cityExtensions;
        points.setText("Je hebt: " + victoryPoints + " overwinningspunten");

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
                            addCard(card2.getType());
                            removeCard(card.getType());
                        } else if (turns % 2 == 0) {
                            card.setVisible(true);
                            card2.setVisible(false);
                            addCard(card.getType());
                            removeCard(card2.getType());
                        }
                    }
                    victoryPoints = towns + 2 * cities + 3 * cityExtensions;
                    points.setText("Je hebt: " + victoryPoints + " overwinningspunten");
                }
            }
        });

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

    public void addCard(Kaart.Type type) {
        switch(type) {
            case Kaart.Type.TOWN -> towns++;
            case Kaart.Type.CITY -> cities++;
            case Kaart.Type.CITY_EXTENSION -> cityExtensions++;
        }
    }

    public void removeCard(Kaart.Type type) {
        switch(type) {
            case Kaart.Type.TOWN -> towns--;
            case Kaart.Type.CITY -> cities--;
            case Kaart.Type.CITY_EXTENSION -> cityExtensions--;
        }
    }
}
