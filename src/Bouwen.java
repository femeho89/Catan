import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bouwen implements ActionListener {
    static ImageIcon bouwStraatKaart = new ImageIcon("Straat Kaart catan 2.png");
    BouwKaart StraatBouwenKaart = new BouwKaart(100, 100, bouwStraatKaart.getIconHeight(), bouwStraatKaart.getIconWidth(), bouwStraatKaart, BouwKaart.BouwType.STREET);
    static ImageIcon bouwDorpKaart = new ImageIcon("Kaart Dorp.png");
    BouwKaart DorpBouwenKaart = new BouwKaart(100, 100, bouwDorpKaart.getIconHeight(), bouwDorpKaart.getIconWidth(), bouwDorpKaart, BouwKaart.BouwType.TOWN);
    static ImageIcon bouwStadKaart = new ImageIcon("Kaart Stad.png");
    BouwKaart StadBouwenKaart = new BouwKaart(100, 100, bouwStadKaart.getIconHeight(), bouwStadKaart.getIconWidth(), bouwStadKaart, BouwKaart.BouwType.CITY);
    static ImageIcon bouwStadsUitbreidingKaart = new ImageIcon("Stadsuitbreiding Kaart catan2.png");
    BouwKaart StadsuitbreidingBouwenKaart = new BouwKaart(100, 100, bouwStadsUitbreidingKaart.getIconHeight(), bouwStadsUitbreidingKaart.getIconWidth(), bouwStadsUitbreidingKaart, BouwKaart.BouwType.CITY);


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
            ActionListener dorpBuildListener = event -> {
               StartButtonActionListener.getPlayingFrame().add(DorpBouwenKaart);
            };
            ActionListener stadBuildListener = event -> {
                StartButtonActionListener.getPlayingFrame().add(StadBouwenKaart);
            };
            ActionListener stadsuitbreidingBuildListener = event -> {
                StartButtonActionListener.getPlayingFrame().add(StadsuitbreidingBouwenKaart);
            };

            //trying to get it so that players can press on the card they wanna build

            //Straat
            JButton straatBuildCard = new JButton(bouwStraatKaart);
            straatBuildCard.setBounds(50, 300, bouwStraatKaart.getIconHeight(), bouwStraatKaart.getIconWidth());
            buildFrame.add(straatBuildCard);
            straatBuildCard.setVisible(true);
            straatBuildCard.addActionListener(straatBuildListener);

            //Dorp
            JButton dorpBuildCard = new JButton(bouwDorpKaart);
            dorpBuildCard.setBounds(250, 300, bouwDorpKaart.getIconHeight(), bouwDorpKaart.getIconWidth());
            buildFrame.add(dorpBuildCard);
            dorpBuildCard.setVisible(true);
            dorpBuildCard.addActionListener(dorpBuildListener);

            //Stad
            JButton stadBuildCard = new JButton(bouwStadKaart);
            stadBuildCard.setBounds(500, 300, bouwStadKaart.getIconHeight(), bouwStadKaart.getIconWidth());
            buildFrame.add(stadBuildCard);
            stadBuildCard.setVisible(true);
            stadBuildCard.addActionListener(stadBuildListener);

            //Stadsuitbreiding
            JButton stadsuitbreidingBuildCard = new JButton(bouwStadsUitbreidingKaart);
            stadsuitbreidingBuildCard.setBounds(750, 300, bouwStadsUitbreidingKaart.getIconHeight(), bouwStadsUitbreidingKaart.getIconWidth());
            buildFrame.add(stadsuitbreidingBuildCard);
            stadsuitbreidingBuildCard.setVisible(true);
            stadsuitbreidingBuildCard.addActionListener(stadsuitbreidingBuildListener);

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

