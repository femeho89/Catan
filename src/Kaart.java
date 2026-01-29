import javax.swing.*;

public class Kaart extends JLabel {

    public enum Type{
        KNIGHT,
        TOWN,
        CITY,
        STREET,
        CITY_EXTENSION,
        ROCK;

        public ImageIcon getImage() {
            switch(this) {
                case KNIGHT -> {return new ImageIcon("Kaart Ridder.png");}
                case TOWN -> {return new ImageIcon("Kaart Dorp");}
                case CITY -> {return new ImageIcon("Kaart Stad");}
                case STREET -> {return new ImageIcon("Kaart Straat");}
                case CITY_EXTENSION -> {return new ImageIcon("Kaart Stadsuitbreiding");}
                case ROCK -> {return new ImageIcon("Kaart Steen");}
            }
            return new ImageIcon("error");
        }
    }

    private final Type type;
    public ImageIcon image;

    public Kaart(int x, int y, int height, int width, Type type, ImageIcon image) {
        this.type = type;
        this.image = image;
        this.setIcon(image);
        setBounds(x, y, width, height);
    }

    public void moveX(int pixels) {
        setLocation(getX() + pixels, getY());
    }

    public Type getType() {
        return type;
    }
}
