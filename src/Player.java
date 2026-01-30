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

    /**
     * A setter for the attribute towns
     * @param towns of the player
     */
    public void setTowns(int towns) {
        this.towns = towns;
    }

    /**
     * A setter for the attribute cities
     * @param cities of the player
     */
    public void setCities(int cities) {
        this.cities = cities;
    }

    /**
     * A getter for cityExtensions
     * @return the cityExtensions of a player
     */
    public void setCityExtensions(int cityExtensions) {
        this.cityExtensions = cityExtensions;
    }

    /**
     * A getter for victorypoints
     * @return the victorypoints of a player
     */
    public int getVictorypoints() {
        return victorypoints;
    }

    /**
     * A setter for the attribute victorypoints
     * @param victorypoints of the player
     */
    public void setVictorypoints(int victorypoints) {
        this.victorypoints = victorypoints;
    }

    /**
     * A method for adding cards to acquire vitorypoints
     * @param type of the card that has to be added
     */
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

    /**
     * A method for removing cards from a player to acquire victorypoints
     * @param type of the card that has to be removed
     */
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

    /**
     * A getter for the attribute cardX
     * @return the x-coordinate of card
     */
    public int getCardX() {
        return card.getX();
    }

    /**
     * A getter for the attribute cardY
     * @return the y-coordinate of card
     */
    public int getCardY() {
        return card.getY();
    }

    /**
     * A getter for card
     * @return the Kaart card
     */
    public Kaart getCard() {
        return card;
    }

    /**
     * A getter for card2
     * @return the Kaart card2
     */
    public Kaart getCard2() {
        return card2;
    }

    /**
     * A getter for the attribute name
     * @return the name of a player
     */
    public String getName() {
        return name;
    }
}
