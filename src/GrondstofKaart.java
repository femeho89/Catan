import javax.swing.*;
import java.util.Random;

public class GrondstofKaart extends Kaart{

    public enum Type {
        ORE,
        GRAIN,
        WOOD,
        SHEEP,
        ROCK;

        public ImageIcon getImage() {
            switch (this) {
                case ORE -> {return new ImageIcon("Kaart Erts.png");}
                case GRAIN -> {return new ImageIcon("Kaart Graan");}
                case WOOD -> {return new ImageIcon("Kaart Hout");}
                case SHEEP -> {return new ImageIcon("Kaart Schaap");}
                case ROCK -> {return new ImageIcon("Kaart Steen");}
            }
            return new ImageIcon("error");
        }

        public static Type getRandom() {
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

