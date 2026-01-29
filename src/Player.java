import javax.swing.*;

public class Player {

    private int towns;
    private int cities;
    private int cityExtensions;
    private final String name;
    private final Kaart card;
    private final Kaart card2;

    private int cardX = 0;
    private int cardY = 100;

    public Player(String name, ImageIcon cardImage, ImageIcon card2Image) {
        this.name = name;

        card = new Kaart(0, 100, cardImage.getIconWidth(), cardImage.getIconHeight(), Kaart.Type.TOWN, cardImage);
        card2 = new Kaart(0, 100, card2Image.getIconWidth(), card2Image.getIconHeight(), Kaart.Type.CITY, card2Image);
        addCard(Kaart.Type.TOWN);
    }

    public int getVictoryPoints() {
        return towns + 2 * cities + 3 * cityExtensions;
    }

    public void addCard(Kaart.Type type) {
        switch(type) {
            case TOWN -> towns++;
            case CITY -> cities++;
            case CITY_EXTENSION -> cityExtensions++;
        }
    }

    public void removeCard(Kaart.Type type) {
        switch(type) {
            case TOWN -> towns--;
            case CITY -> cities--;
            case CITY_EXTENSION -> cityExtensions--;
        }
    }

    public int getCardX() {
        return cardX;
    }

    public int getCardY() {
        return cardY;
    }

    public void setCardCoordinates(int x, int y) {
        this.cardX = x;
        this.cardY = y;
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
