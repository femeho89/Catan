import javax.swing.*;
import java.util.Random;

public class GrondstofKaart extends Kaart{

    private final GrondType type;

    public enum GrondType {
        ORE,
        GRAIN,
        WOOD,
        SHEEP,
        ROCK;

        public static GrondType getRandom() {
            Random rng = new Random();
            switch(rng.nextInt(0, 4)) {
                case 1 -> {return ORE;}
                case 2 -> {return GRAIN;}
                case 3 -> {return WOOD;}
                case 4 -> {return SHEEP;}
                case 5 -> {return ROCK;}
            }
            return getRandom();
        }
    }

    public GrondstofKaart(int x, int y, int height, int width, ImageIcon image, GrondType type) {
        super(x, y, height, width, image);
        this.type = type;
    }

    /**
     * A getter for the attribute type
     * @return the type of a card
     */
    public GrondType getGrondType() {
        return type;
        //this.type = type;
    }
}

