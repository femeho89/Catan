import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MarketActionListener implements ActionListener{
    ImageIcon cardORE = new ImageIcon("Kaart Erts.png");
    ImageIcon cardGRAIN = new ImageIcon("Kaart Graan.png");
    ImageIcon cardWOOD = new ImageIcon("Kaart Hout.png");
    ImageIcon cardSHEEP = new ImageIcon("Kaart Schaap.png");
    ImageIcon cardROCK = new ImageIcon("Kaart Steen.png");
    public MarketActionListener() {
    }
    GrondstofKaart grondstofCard1 = new GrondstofKaart(0,
            100,
            cardORE.getIconWidth(),
            cardORE.getIconHeight(),
            cardORE);

    @Override
    public void actionPerformed(ActionEvent e) {
        StartButtonActionListener.timer.stop();

        JFrame marketFrame = new JFrame(Main.file1);
        marketFrame.setSize(1366, 720);
        marketFrame.setLayout(null);
        StartButtonActionListener.getPlayingFrame().setVisible(false);
        marketFrame.setVisible(true);
        JLabel grondstofKaart = new JLabel();
        GrondstofKaart grondstofCard1 = new GrondstofKaart(0,
                100,
                cardORE.getIconWidth(),
                cardORE.getIconHeight(),
                cardORE);

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
