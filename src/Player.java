import javax.swing.*;

public class Player {

    private int victorypoints = 0;
    private int towns;
    private int cities;
    private int cityExtensions;
    private final String name;
    private final Kaart card;
    private final Kaart card2;

    public Player(String name, ImageIcon cardImage, ImageIcon card2Image) {
        this.name = name;

        card = new Kaart(0, 100, cardImage.getIconWidth(), cardImage.getIconHeight(), Kaart.Type.TOWN, cardImage);
        card2 = new Kaart(0, 100, card2Image.getIconWidth(), card2Image.getIconHeight(), Kaart.Type.CITY, card2Image);
        addCard(Kaart.Type.TOWN);
    }

    public int getVictorypoints() {
        return victorypoints;
    }

    public void setVictorypoints(int victorypoints) {
        this.victorypoints = victorypoints;
    }

    public void addCard(Kaart.Type type) {
        switch(type) {
            case TOWN -> {
                towns++;
                victorypoints += 1;
            }
            case CITY -> {
                cities++;
                victorypoints += 2;
            }
            case CITY_EXTENSION -> {
                cityExtensions++;
                victorypoints += 3;
            }
        }
    }

    public void removeCard(Kaart.Type type) {
        switch(type) {
            case TOWN -> {
                towns--;
                victorypoints -= 1;
            }
            case CITY -> {
                cities--;
                victorypoints -= 2;
            }
            case CITY_EXTENSION -> {
                cityExtensions--;
                victorypoints -= 3;
            }
        }
    }

    public int getCardX() {
        return card.getX();
    }

    public int getCardY() {
        return card.getY();
    }

    public Kaart getCard() {
        return card;
    }

    public Kaart getCard2() {
        return card2;
    }

    public String getName() {
        return name;
    }
}
