import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bouwen implements ActionListener {
    ImageIcon cardBack = new ImageIcon("Achterkant Kaart Catan.png");
    static ImageIcon bouwStraatKaart = new ImageIcon("Straat Kaart catan 2.png");
    BouwKaart straatBouwenKaart = new BouwKaart(250, 260, bouwStraatKaart.getIconHeight(), bouwStraatKaart.getIconWidth(), BouwKaart.BouwType.STREET, bouwStraatKaart, cardBack);
    static ImageIcon bouwDorpKaart = new ImageIcon("Kaart Dorp 2.png");
    BouwKaart dorpBouwenKaart = new BouwKaart(500, 260, bouwDorpKaart.getIconHeight(), bouwDorpKaart.getIconWidth(), BouwKaart.BouwType.TOWN, bouwDorpKaart, cardBack);
    static ImageIcon bouwStadKaart = new ImageIcon("Kaart Stad 2.png");
    BouwKaart stadBouwenKaart = new BouwKaart(750, 260, bouwStadKaart.getIconHeight(), bouwStadKaart.getIconWidth(), BouwKaart.BouwType.CITY, bouwStadKaart, cardBack);
    static ImageIcon bouwStadsUitbreidingKaart = new ImageIcon("Stadsuitbreiding Kaart catan 2.png");
    BouwKaart stadsuitbreidingBouwenKaart = new BouwKaart(1000, 260, bouwStadsUitbreidingKaart.getIconHeight(), bouwStadsUitbreidingKaart.getIconWidth(), BouwKaart.BouwType.CITY_EXTENSION, bouwStadsUitbreidingKaart, cardBack); //x-coordinate 1250 gives card on right wall
    //Omnes Optant Mundum Regere

    static int streets;
    static int towns;
    static int cities;
    static int cityExtensions;


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
            BouwKaart nieuweStraatKaart = new BouwKaart(100, 400, bouwStraatKaart.getIconHeight(), bouwStraatKaart.getIconWidth(), BouwKaart.BouwType.STREET, bouwStraatKaart, cardBack);
            streets++;
            StartButtonActionListener.streets.setText("Je hebt " + Bouwen.getStreets() + " straten");
            StartButtonActionListener.getPlayingFrame().add(nieuweStraatKaart);
        };
        ActionListener dorpBuildListener = event -> {
            BouwKaart nieuweDorpKaart = new BouwKaart(220, 400, bouwDorpKaart.getIconHeight(), bouwDorpKaart.getIconWidth(), BouwKaart.BouwType.TOWN, bouwDorpKaart, cardBack);
            towns++;
            StartButtonActionListener.towns.setText("Je hebt " + Bouwen.getTowns() + " dorpen");
            StartButtonActionListener.getPlayingFrame().add(nieuweDorpKaart);
        };
        ActionListener stadBuildListener = event -> {
            BouwKaart nieuweStadKaart = new BouwKaart(340, 400, bouwStadKaart.getIconHeight(), bouwStadKaart.getIconWidth(), BouwKaart.BouwType.CITY, bouwStadKaart, cardBack);
            cities++;
            StartButtonActionListener.cities.setText("Je hebt " + Bouwen.getCities() + " steden");
            StartButtonActionListener.getPlayingFrame().add(nieuweStadKaart);
        };
        ActionListener stadsuitbreidingBuildListener = event -> {
            BouwKaart nieuweStadsuitbreidingKaart = new BouwKaart(460, 400, bouwStadsUitbreidingKaart.getIconHeight(), bouwStadsUitbreidingKaart.getIconWidth(), BouwKaart.BouwType.CITY_EXTENSION, bouwStadsUitbreidingKaart, cardBack);
            cityExtensions++;
            StartButtonActionListener.cityExtensions.setText("Je hebt " + Bouwen.getCityExtensions() + " stadsuitbreidingen");
            StartButtonActionListener.getPlayingFrame().add(nieuweStadsuitbreidingKaart);
        };

        //trying to get it so that players can press on the card they want to build

        //Straat
        buildFrame.add(straatBouwenKaart);
        JButton straatBuildCard = new JButton(bouwStraatKaart);
        straatBuildCard.setBounds(250, 260, 100, 156);
        straatBuildCard.setBackground(new Color(255, 0, 255));
        buildFrame.add(straatBuildCard);
        straatBuildCard.addActionListener(straatBuildListener);

        //Dorp
        buildFrame.add(dorpBouwenKaart);
        JButton dorpBuildCard = new JButton(bouwDorpKaart);
        dorpBuildCard.setBounds(500, 260, 100, 156);
        dorpBuildCard.setBackground(new Color(255, 0, 255));
        buildFrame.add(dorpBuildCard);
        dorpBuildCard.addActionListener(dorpBuildListener);

        //Stad
        buildFrame.add(stadBouwenKaart);
        JButton stadBuildCard = new JButton(bouwStadKaart);
        stadBuildCard.setBounds(750, 260, 100, 156);
        stadBuildCard.setBackground(new Color(255, 0, 255));
        buildFrame.add(stadBuildCard);
        stadBuildCard.addActionListener(stadBuildListener);

        //Stadsuitbreiding
        buildFrame.add(stadsuitbreidingBouwenKaart);
        JButton stadsuitbreidingBuildCard = new JButton(bouwStadsUitbreidingKaart);
        stadsuitbreidingBuildCard.setBounds(1000, 260, 100, 156);
        stadsuitbreidingBuildCard.setBackground(new Color(255, 0, 255));
        buildFrame.add(stadsuitbreidingBuildCard);
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

    /**
     * A getter for the attribute streets
     * @return the amount of streets a player has
     */
    public static int getStreets() {
        return streets;
    }

    /**
     * A getter for the attribute towns
     * @return the amount of towns a player has
     */
    public static int getTowns() {
        return towns;
    }

    /**
     * A getter for the attribute cities
     * @return the amount of cities a player has
     */
    public static int getCities() {
        return cities;
    }

    /**
     * A getter for the attribute cityExtensions
     * @return the amount of cityExtensions a player has
     */
    public static int getCityExtensions() {
        return cityExtensions;
    }
}

