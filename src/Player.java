import java.util.ArrayList;

public class Player {

    private final String name;
    private final ArrayList<BouwKaart> bouwKaarten = new ArrayList<>();
    private final ArrayList<GrondstofKaart> grondstofKaarten = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    /**
     * A getter for the victorypoints
     * @return the victorypoints of a player
     */
    public int getVictorypoints() {
        int points = 0;

        for (BouwKaart card : bouwKaarten) {
                switch (card.getBouwType()) {
                    case TOWN -> points += 1;
                    case CITY -> points += 2;
                    case CITY_EXTENSION -> points += 3;
                }
        }
        return points;
    }

    /**
     * A method for adding cards to acquire victorypoints
     * @param card of the card that has to be added
     */
    public void addCard(BouwKaart card) {
        bouwKaarten.add(card);
    }

    /**
     * A method for removing cards from a player to acquire victorypoints
     * @param card that has to be removed
     */
    public void removeCard(BouwKaart card) {
        bouwKaarten.remove(card);
    }

    public ArrayList<BouwKaart> getBouwKaarten() {
        return bouwKaarten;
    }

    public Kaart getCard(int index) {
        return bouwKaarten.get(index);
    }

    public int getCardX(int index) {
        return bouwKaarten.get(index).getX();
    }

    public void addGrondstofCard(GrondstofKaart card) {
        grondstofKaarten.add(card);
    }

    public void removeGrondstofCard(GrondstofKaart card) {
        grondstofKaarten.remove(card);
    }

    public ArrayList<GrondstofKaart> getGrondstofKaarten() {
        return grondstofKaarten;
    }

    /**
     * A getter for the attribute name
     * @return the name of a player
     */
    public String getName() {
        return name;
    }

    public void setBouwCardsVisible(boolean visible) {
        for(BouwKaart card : bouwKaarten) {
            card.setVisible(visible);
        }
    }

    public void setGrondstofCardsVisible(boolean visible) {
        for(GrondstofKaart card : grondstofKaarten) {
            card.setVisible(visible);
        }
    }
}
