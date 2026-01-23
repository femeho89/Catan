import javax.swing.*;

public class Player {

    private int towns;
    private int cities;
    private int cityExtensions;
    private final String name;
    private Kaart card;
    private Kaart card2;

    private int cardX;
    private int cardY;
    private int card2X;
    private int card2Y;

    public Player(String name, ImageIcon cardImage, ImageIcon card2Image) {
        this.name = name;

        card = new Kaart(0, 100, cardImage.getIconWidth(), cardImage.getIconHeight(), Kaart.Type.TOWN, cardImage);
        card2 = new Kaart(0, 100, card2Image.getIconWidth(), card2Image.getIconHeight(), Kaart.Type.CITY, card2Image);

        cardX = card.getX();
        cardY = card.getY();
        card2X = card2.getX();
        card2Y = card2.getY();
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

    public Kaart getCard() {
        return card;
    }

    public Kaart getCard2() {
        return card2;
    }

    public void refreshCardCoordinates() {
        card.setX(card.getX());
        card.setY(card.getY());
        card2.setX(card2.getX());
        card2.setY(card2.getY());
    }

    public String getName() {
        return name;
    }
}
