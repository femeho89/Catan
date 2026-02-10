import javax.swing.*;
import java.util.Random;

public class GrondstofKaart extends Kaart{

    public enum Type {
        ORE,
        GRAIN,
        WOOD,
        SHEEP,
        ROCK;

        public static GrondstofKaart getRandom() {
            Random rng = new Random();
            switch(rng.nextInt(0, 4)) {
                case 1 -> {return ORE;}
                case 2 -> {return GRAIN;}
                case 3 -> {return WOOD;}
                case 4 -> {return SHEEP;}
                case 5 -> {return ROCK;}
            }
            return ORE;
        }
    }

    public GrondstofKaart(int x, int y, int height, int width, Kaart.Type type, ImageIcon image) {
        super(x, y, height, width, type, image);
    }
}

