import javax.swing.*;

public class Kaart extends JLabel {

    public enum Type{
        KNIGHT,
        TOWN,
        CITY,
        STREET,
        CITY_EXTENSION
    }

    private int x;
    private int y;
    private final int height;
    private final int width;
    private final Type type;
    public ImageIcon image;

    public Kaart(int x, int y, int height, int width, Type type, ImageIcon image) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.type = type;
        this.image = image;
        this.setIcon(image);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public Type getType() {
        return type;
    }
}
