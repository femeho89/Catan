import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bouwen implements ActionListener {
    static ImageIcon bouwStraatKaart = new ImageIcon("Kaart Straat.png");
    BouwKaart StraatBouwenKaart = new BouwKaart(100, 100, bouwStraatKaart.getIconHeight(), bouwStraatKaart.getIconWidth(), bouwStraatKaart, BouwKaart.BouwType.STREET);

        @Override
        public void actionPerformed(ActionEvent e) {
            StartButtonActionListener.timer.stop();

            JFrame buildFrame = new JFrame(Main.file1);
            buildFrame.setSize(1366, 720);
            buildFrame.setLayout(null);
            buildFrame.getContentPane().setBackground(new Color(237, 140, 98));
            StartButtonActionListener.getPlayingFrame().setVisible(false);
            buildFrame.setVisible(true);

            //initialises question Label & declares it a new JLabel with the text "wat wil je bouwen?"
            JLabel questionLabel = new JLabel("wat wil je bouwen?");
            //sets the position & size of GUI component questionLabel
            questionLabel.setBounds(633, 100, 200, 50);
            //sets font for questionLabel
            questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
            //adds questionLabel to frame
            buildFrame.add(questionLabel);

            ActionListener straatBuildListener = event -> {
                StartButtonActionListener.getPlayingFrame().add(StraatBouwenKaart);
            };

            JButton straatBuildCard = new JButton((StraatBouwenKaart);
            straatBuildCard.setBounds(60, 600, bouwStraatKaart.getIconHeight(), bouwStraatKaart.getIconWidth());
            buildFrame.add(straatBuildCard);
            straatBuildCard.setVisible(true);
            straatBuildCard.addActionListener(straatBuildListener);

            ActionListener buildBackListener = event -> {
                StartButtonActionListener.getPlayingFrame().setVisible(true);
                buildFrame.setVisible(false);
                StartButtonActionListener.timer.start();
            };

            JButton buildExitButton = new JButton("Terug naar het spel");
            buildExitButton.setBounds(50, 50, 200, 50);
            buildExitButton.setBackground(new Color(200, 0, 0));
            buildFrame.add(buildExitButton);
            buildExitButton.addActionListener(buildBackListener);
        }
    }

