import javax.swing.*;
import java.util.Random;

public class GrondstofKaart extends Kaart{

    public enum GrondType {
        ORE,
        GRAIN,
        WOOD,
        SHEEP,
        ROCK;

        public static ImageIcon getRandom() {
            Random rng = new Random();
            switch(rng.nextInt(0, 4)) {
                case 1 -> {return new ImageIcon("Kaart Erts");}
                case 2 -> {return new ImageIcon("Kaart Graan");}
                case 3 -> {return new ImageIcon("Kaart Hout");}
                case 4 -> {return new ImageIcon("Kaart Schaap");}
                case 5 -> {return new ImageIcon("Kaart Steen");}
            }
            return getRandom();
        }
    }

    public GrondstofKaart(int x, int y, int height, int width, ImageIcon image) {
        super(x, y, height, width, image);

    }

    /**
     * A getter for the attribute type
     * @return the type of a card
     */
}

