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
    }

    public GrondstofKaart(int x, int y, int height, int width, ImageIcon image, GrondType type) {
        super(x, y, height, width, image);
        this.type = type;
    }

    public static GrondstofKaart getRandom() {
        Random rng = new Random();
        ImageIcon cardOre = new ImageIcon("Kaart Erts.png");
        ImageIcon cardGrain = new ImageIcon("Kaart Graan.png");
        ImageIcon cardWood = new ImageIcon("Kaart Hout.png");
        ImageIcon cardSheep = new ImageIcon("Kaart Schaap.png");
        ImageIcon cardRock = new ImageIcon("Kaart Steen.png");

        GrondstofKaart grondstofKaart = null;

        switch(rng.nextInt(1, 6)) {
            case 1 -> grondstofKaart = new GrondstofKaart(0, 100, cardOre.getIconWidth(), cardOre.getIconHeight(), cardOre, GrondstofKaart.GrondType.ORE);
            case 2 -> grondstofKaart = new GrondstofKaart(0, 100, cardGrain.getIconWidth(), cardGrain.getIconHeight(), cardGrain, GrondstofKaart.GrondType.GRAIN);
            case 3 -> grondstofKaart = new GrondstofKaart(0, 100, cardWood.getIconWidth(), cardWood.getIconHeight(), cardWood, GrondstofKaart.GrondType.WOOD);
            case 4 -> grondstofKaart = new GrondstofKaart(0, 100, cardSheep.getIconWidth(), cardSheep.getIconHeight(), cardSheep, GrondstofKaart.GrondType.SHEEP);
            case 5 -> grondstofKaart = new GrondstofKaart(0, 100, cardRock.getIconWidth(), cardRock.getIconHeight(), cardRock, GrondstofKaart.GrondType.ROCK);
        }
        return grondstofKaart;
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

