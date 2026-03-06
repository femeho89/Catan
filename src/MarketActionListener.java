import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MarketActionListener implements ActionListener{

    static JLabel confirmLabel = new JLabel("Je hebt een kaart getrokken.");
    static ImageIcon stockPile = new ImageIcon("Kaart Achterkant.png");

    static int ore;
    static int grain;
    static int wood;
    static int sheep;
    static int rock;


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
            if(grondstofKaart1.getGrondType().equals(GrondstofKaart.GrondType.ORE)){
                grondstofKaart1.setLocation(60, 600);
                ore++;
                StartButtonActionListener.ore.setText("Je hebt " + ore + " kilo erts");
                StartButtonActionListener.getPlayingFrame().add(grondstofKaart1);
            }
            if(grondstofKaart1.getGrondType().equals(GrondstofKaart.GrondType.GRAIN)){
                grondstofKaart1.setLocation(120, 600);
                grain++;
                StartButtonActionListener.grain.setText("Je hebt " + grain + " graan balen");
                StartButtonActionListener.getPlayingFrame().add(grondstofKaart1);
            }
            if(grondstofKaart1.getGrondType().equals(GrondstofKaart.GrondType.WOOD)){
                grondstofKaart1.setLocation(180, 600);
                wood++;
                StartButtonActionListener.wood.setText("Je hebt " + wood + " boomstammen");
                StartButtonActionListener.getPlayingFrame().add(grondstofKaart1);
            }
            if(grondstofKaart1.getGrondType().equals(GrondstofKaart.GrondType.SHEEP)){
                grondstofKaart1.setLocation(240, 600);
                sheep++;
                StartButtonActionListener.sheep.setText("Je hebt " + sheep + " schapen");
                StartButtonActionListener.getPlayingFrame().add(grondstofKaart1);
            }
            if(grondstofKaart1.getGrondType().equals(GrondstofKaart.GrondType.ROCK)){
                grondstofKaart1.setLocation(300, 600);
                rock++;
                StartButtonActionListener.rock.setText("Je hebt " + rock + " kilo steen");
                StartButtonActionListener.getPlayingFrame().add(grondstofKaart1);
            }
            else{
                grondstofKaart1.setLocation(60, 600);
                StartButtonActionListener.getPlayingFrame().add(grondstofKaart1);
            }
            //marketFrame.add(grondstofKaart1);
            //Player.addCardToOwned(grondstofKaart1);

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

    /**
     * A getter for the attribute Ore
     * @return the amount of ores a player has
     */
    public static int getOres() {return ore;}
    /**
     * A getter for the attribute Grain
     * @return the amount of grains a player has
     */
    public static int getGrains() {
        return grain;
    }
    /**
     * A getter for the attribute Wood
     * @return the amount of woods a player has
     */
    public static int getWoods() {
        return wood;
    }
    /**
     * A getter for the attribute Sheep
     * @return the amount of sheeps a player has
     */
    public static int getSheeps() {
        return sheep;
    }
    /**
     * A getter for the attribute Rock
     * @return the amount of rocks a player has
     */
    public static int getRocks() {return rock;}

    /**
     * subtracts resources necessary to build street
     */
    public static void straatGebouwd(){
        wood--;
        rock--;
        StartButtonActionListener.wood.setText("Je hebt " + wood + " boomstammen");
        StartButtonActionListener.rock.setText("Je hebt " + rock + " kilo steen");
    }

    /**
     * subtracts resources necessary to build town
     */
    public static void dorpGebouwd(){
        wood--;
        rock--;
        grain--;
        sheep--;
        StartButtonActionListener.wood.setText("Je hebt " + wood + " boomstammen");
        StartButtonActionListener.rock.setText("Je hebt " + rock + " kilo steen");
        StartButtonActionListener.grain.setText("Je hebt " + grain + " graan balen");
        StartButtonActionListener.sheep.setText("Je hebt " + sheep + " schapen");
    }

    /**
     * subtracts resources necessary to build city
     */
    public static void stadGebouwd(){
        grain = grain-2;
        ore = ore-3;
        StartButtonActionListener.grain.setText("Je hebt " + grain + " graan balen");
        StartButtonActionListener.ore.setText("Je hebt " + ore + " kilo erts");
    }

    /**
     * subtracts resources necessary to build city expansions
     */
    public static void stadsUitbreidingGebouwd(){
        sheep = sheep-3;
        ore--;
        StartButtonActionListener.sheep.setText("Je hebt " + sheep + " schapen");
        StartButtonActionListener.ore.setText("Je hebt " + ore + " kilo erts");
    }
}
