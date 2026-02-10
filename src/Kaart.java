import javax.swing.*;

public class Kaart extends JLabel {

    public enum Type{
        KNIGHT,
        TOWN,
        CITY,
        STREET,
        CITY_EXTENSION;

        public ImageIcon getImage() {
            switch(this) {
                case KNIGHT -> {return new ImageIcon("Kaart Ridder.png");}
                case TOWN -> {return new ImageIcon("Kaart Dorp");}
                case CITY -> {return new ImageIcon("Kaart Stad");}
                case STREET -> {return new ImageIcon("Kaart Straat");}
                case CITY_EXTENSION -> {return new ImageIcon("Kaart Stadsuitbreiding");}
            }
            return new ImageIcon("error");
        }
    }

    private int turns = 0;
    private final Type type;
    public ImageIcon image;

    public Kaart(int x, int y, int height, int width, Type type, ImageIcon image) {
        this.type = type;
        this.image = image;
        this.setIcon(image);
        setBounds(x, y, width, height);
    }

    /**
     * A method to move the x-coordinate of a card
     * @param pixels that the card has to move
     */
    public void moveX(int pixels) {
        setLocation(getX() + pixels, getY());
    }

    /**
     * A getter for the attribute turns
     * @return the turns of a card
     */
    public int getTurns() {
        return turns;
    }

    /**
     * A setter for the attribute turns
     * @param turns of a card
     */
    public void setTurns(int turns) {
        this.turns = turns;
    }

    /**
     * A getter for the attribute type
     * @return the type of a card
     */
    public Type getType() {
        return type;
    }
}
