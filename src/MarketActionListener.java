import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MarketActionListener implements ActionListener{

    static JLabel confirmLabel = new JLabel("Je hebt een kaart getrokken.");
    static ImageIcon stockPile = new ImageIcon("Kaart Achterkant.png");

    public MarketActionListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StartButtonActionListener.timer.stop();

        JFrame marketFrame = new JFrame(Main.file1);
        marketFrame.setSize(1366, 720);
        marketFrame.setLayout(null);
        StartButtonActionListener.getPlayingFrame().setVisible(false);
        marketFrame.setVisible(true);

        ActionListener newCardListener = event -> {
            GrondstofKaart grondstofKaart1 = GrondstofKaart.getRandom();
            grondstofKaart1.setLocation(60, 600);
            StartButtonActionListener.getPlayingFrame().add(grondstofKaart1); //?
            marketFrame.add(grondstofKaart1);
            Player.addCardToOwned(grondstofKaart1);

            confirmLabel.setLocation(60, 400);
            marketFrame.add(confirmLabel);
            confirmLabel.setVisible(true);
            MarketTimer.timer.start();

            marketFrame.setVisible(true);
        };
        JButton drawCard = new JButton(stockPile);
        drawCard.setBounds(505, 232, stockPile.getIconWidth(), stockPile.getIconHeight());
        marketFrame.add(drawCard);
        drawCard.setVisible(true);
        drawCard.addActionListener(newCardListener);

        ActionListener marketBackListener = back -> {
            StartButtonActionListener.getPlayingFrame().setVisible(true);
            marketFrame.setVisible(false);
            StartButtonActionListener.timer.start();
        };

        JButton marketExitButton = new JButton("Terug naar het spel!");
        marketExitButton.setBounds(50, 550, 200, 50);
        marketExitButton.setBackground(new Color(200, 0, 0));
        marketFrame.add(marketExitButton);
        marketExitButton.addActionListener(marketBackListener);

        marketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
