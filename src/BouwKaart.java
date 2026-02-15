import javax.swing.*;

public class BouwKaart extends Kaart{

    private final BouwType type;

    public enum BouwType {
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

    public BouwKaart(int x, int y, int height, int width, ImageIcon image, BouwType type) {
        super(x, y, height, width, image);
        this.type = type;
    }

    /**
     * A getter for the attribute type
     * @return the type of card
     */
    public BouwType getBouwType() {
        return type;
    }
}
