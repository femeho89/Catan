import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Player {

    //initialises integer 'victorypoints' and declares it as 0
    private int victorypoints = 0;
    //initialises integer 'towns'
    private int towns;
    //initialises integer 'cities'
    private int cities;
    //initialises integer 'cityExtensions'
    private int cityExtensions;
    private final String name;
    //initialises BouwKaart 'card'
    private final BouwKaart card;
    //initialises BouwKaart 'card2'
    private final BouwKaart card2;
    private static ArrayList<Kaart> OwnedCards = new ArrayList<>();
    private Kaart addingCard;

    //?
    public Player(String name, ImageIcon cardImage, ImageIcon card2Image) {
        this.name = name;

        //declares card as a new BouwKaart with the attributes int x, int y, int height, int width, ImageIcon Image, BouwType type from BouwKaart Class
        card = new BouwKaart(0, 100, cardImage.getIconHeight(), cardImage.getIconWidth(), cardImage, BouwKaart.BouwType.TOWN);
        //declares card2 as a new BouwKaart with the attributes int x, int y, int height, int width, ImageIcon Image, BouwType type from BouwKaart Class
        card2 = new BouwKaart(0, 100, card2Image.getIconHeight(), card2Image.getIconWidth(), card2Image, BouwKaart.BouwType.CITY);
        //calls addCard function
        addCard(BouwKaart.BouwType.TOWN);
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
     * A getter for the victorypoints
     * @return the victorypoints of a player
     */
    public int getVictorypoints() {
        return victorypoints;
    }

    /**
     * A setter for the attribute victorypoints
     *
     * @param victorypoints of the player
     * @return
     */
    public ActionListener setVictorypoints(int victorypoints) {
        this.victorypoints = victorypoints;
        return null;
    }

    /**
     * A method for adding cards to acquire victorypoints
     * @param type of the card that has to be added
     */
    public void addCard(BouwKaart.BouwType type) {
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
    public void removeCard(BouwKaart.BouwType type) {
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
    public BouwKaart getCard() {
        return card;
    }

    /**
     * A getter for card2
     * @return the Kaart card2
     */
    public BouwKaart getCard2() {
        return card2;
    }

    /**
     * A getter for the attribute name
     * @return the name of a player
     */
    public String getName() {
        return name;
    }

    /**
     * A getter for the attribute OwnedCards
     * @return the owned cards of a player
     */
    public ArrayList<Kaart> getOwnedCards() {
        return OwnedCards;
    }
    /**
     * A method for adding a card to the OwnedCards ArrayList
     */
    public static void addCardToOwned(Kaart addingCard){
        OwnedCards.add(addingCard);
    }

}
