import javax.swing.*;

public class BouwKaart extends Kaart{

    private boolean isFront = true;

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
                case TOWN -> {return new ImageIcon("Kaart Dorp.png");}
                case CITY -> {return new ImageIcon("Kaart Stad.png");}
                case STREET -> {return new ImageIcon("Kaart Straat.png");}
                case CITY_EXTENSION -> {return new ImageIcon("Kaart Stadsuitbreiding.png");}
            }
            return new ImageIcon("error");
        }
//        public BouwKaart getBuildCard(int xBouw, int yBouw, int heightBouw, int widthBouw, ImageIcon image, BouwType type){
//            case KNIGHT -> {return new BouwKaart(xBouw, yBouw, heightBouw, widthBouw, image, type );}
//        };
    }

    public BouwKaart(int x, int y, int height, int width, BouwType type, ImageIcon frontCard, ImageIcon backCard) {
        super(x, y, height, width, frontCard, backCard);
        this.type = type;

        setIcon(frontCard);
    }

    public void turn() {
        isFront = !isFront;

        if(isFront) {
            setIcon(frontCard);
        }
        else{
            setIcon(backCard);
        }
    }

    /**
     * A getter for the attribute type
     * @return the type of card
     */
    public BouwType getBouwType() {
        return type;
    }
}
